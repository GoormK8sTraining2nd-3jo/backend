package kr.kua.backend.model.response

import lombok.Getter
import lombok.Setter

@Getter
@Setter
open class ImageListResult(get: Map<String, String>) : BaseResult() {
    var images: Map<String, String>

    init {
        images = get
    }
}
