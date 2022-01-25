package kr.kua.backend.entity.members

import kr.kua.backend.entity.BaseDateEntity
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "users")
open class User : BaseDateEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var memberId: Long = 0

    @Column(name = "email", nullable = false, length = 30, unique = true)
    var emailAddress: String = ""

    @Column(name = "name", nullable = false, length = 30)
    var name: String = ""
}