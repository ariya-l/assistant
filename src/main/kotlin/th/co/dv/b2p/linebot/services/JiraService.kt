package th.co.dv.b2p.linebot.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import th.co.dv.b2p.linebot.model.IssueJiraModel
import th.co.dv.b2p.linebot.model.JiraModel
import th.co.dv.b2p.linebot.model.mappingCustomField
import th.co.dv.b2p.linebot.utilities.Utils.getFieldValue
import java.net.URLEncoder
import java.util.*

@Service
class JiraService {

    @Autowired
    lateinit var restTemplate: RestTemplate

    private val mapper = jacksonObjectMapper()

    private val url = "https://scb-digitalventures.atlassian.net/rest/api/3/search?jql="
    private val accessToken = "akkapong.k@dv.co.th:UgBUFfAzLelbbNQv4UHlDA55"

    /**
     * https://scb-digitalventures.atlassian.net/rest/api/3/search?jql=cf[10218]=newsit2+AND+scope=irpc&maxResults=5
     */
    enum class Mode(val key: String) {
        SPRINT("sprint="),
        ISSUE("issue="),
        DEPLOY("cf[10218]=:env+AND+scope=:scope")
    }
    private val AND = "+AND+"
    private val ANDENCODE = "%2BAND%2B"
    private val UTF8 = "UTF-8"

    /**
     * Method for complete url
     */
    private fun Mode.completeUrl(value: String, value2: String? = null, startAt: Int = 0): String {
        return when (this) {
            Mode.DEPLOY -> url + URLEncoder.encode(this.key.replace(":scope", value).replace(":env", value2!!), UTF8)
                    .replace(ANDENCODE, AND) + "&startAt=$startAt"
            else -> url + URLEncoder.encode(this.key + value, UTF8) + "&startAt=$startAt"
        }

    }

    /**
     * Get Gold information
     */
    fun getInformation(mode: Mode, value: String, value2: String?= null): List<IssueJiraModel> {

        val headers = HttpHeaders()

        val token = Base64.getEncoder().encodeToString(accessToken.toByteArray())
        headers.set(HttpHeaders.AUTHORIZATION, "Basic $token")

        var startAt = 0
        var total: Int
        var currentRecord: Int
        val outputs= mutableListOf<IssueJiraModel>()

        try {
            do {
                // codes inside body of do while loop
                val response = getDataByPage(
                        headers = headers,
                        mode = mode,
                        value = value,
                        value2 = value2,
                        startAt = startAt)
                total = response.total!!
                currentRecord =  response.startAt!! + response.maxResults!!
                startAt += response.maxResults!!

                outputs.addAll(response.issues ?: emptyList())

            } while (total > currentRecord)

        } catch (e: Exception) {
            throw Exception(e.message, e)
        }
        return outputs
    }

    private fun getDataByPage(headers: HttpHeaders, mode: Mode, value: String, value2: String? = null, startAt: Int = 0): JiraModel {
        val builder: UriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(mode.completeUrl(value, value2, startAt))
        println(">>>>>>>>>> ${mode.completeUrl(value, value2, startAt)}")
        return restTemplate.exchange(
                builder.build(true).toUri(),
                HttpMethod.GET,
                HttpEntity(null, headers),
                object : ParameterizedTypeReference<JiraModel>() {}
        ).body!!
    }

    /**
     * Method get tag deploy
     */
    fun getDeployTag(issueJiraModel: IssueJiraModel): List<String> {
        val fields = issueJiraModel.fields!!
        return mappingCustomField.map { (customFiled, customLabel) ->
            val value = fields.getFieldValue<String>(customFiled)
            "$customLabel : $value"
        }
    }
}