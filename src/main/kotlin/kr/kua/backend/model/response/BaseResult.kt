package kr.kua.backend.model.response

import lombok.Getter
import lombok.Setter

@Getter
@Setter
open class BaseResult {
    lateinit var code: String
    lateinit var message: String
}
