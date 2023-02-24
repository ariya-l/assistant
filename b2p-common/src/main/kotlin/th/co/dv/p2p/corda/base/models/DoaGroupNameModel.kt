package th.co.dv.p2p.corda.base.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class DoaGroupNameModel(
    val groupId: Int? = null,
    val groupName: String? = null,
    val doaUsernames: List<DoaUsernameModel>? = null,
    val doaCriteria: List<DoaCriteriaModel>? = null
)
