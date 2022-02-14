package kr.kua.backend.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Getter
@Setter
@Table(name = "images")
class Images(fileNameParam: String?, pathParam: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var imageId: Long = 0

    @Column(name = "fileName", nullable = false, length = 60)
    lateinit var fileName: String

    @Column(name = "path", nullable = false)
    lateinit var path: String

    constructor(fileNameParam: String) : this(fileNameParam, "")
    constructor() : this(null, "") { }

    init {
        if (!fileNameParam.isNullOrEmpty()) {
            this.fileName = fileNameParam
            this.path = pathParam
        }
    }
}