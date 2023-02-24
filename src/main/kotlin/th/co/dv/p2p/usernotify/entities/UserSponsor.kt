package th.co.dv.p2p.usernotify.entities

import javax.persistence.*

@Entity
@Table
data class UserSponsor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val userId: Long? = null,
    val sponsor: String? = null
)
