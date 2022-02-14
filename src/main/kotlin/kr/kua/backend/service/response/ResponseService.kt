package kr.kua.backend.service.response

import kr.kua.backend.model.response.BaseResult
import kr.kua.backend.model.response.ImageListResult
import org.springframework.stereotype.Service

@Service
class ResponseService {
    var successResult: BaseResult
        get() {
            val result = BaseResult()
            successResult = result
            return result
        }
        set(result) {
            result.code = ErrorCode.SUCCESS.code
            result.message = ErrorCode.SUCCESS.message
        }

    fun getFailureResult(code: ErrorCode, msg: String): BaseResult {
        val result = BaseResult()
        result.code = code.code
        result.message = msg
        return result
    }

    fun getFailureResult(error: ErrorCode): BaseResult {
        val result = BaseResult()
        result.code = error.code
        result.message = error.message
        return result
    }

    fun getImageListResult(map: Map<String, String>): ImageListResult {
        val result = ImageListResult(map)
        result.code = ErrorCode.SUCCESS.code
        result.message = ErrorCode.SUCCESS.message
        return result
    }
}