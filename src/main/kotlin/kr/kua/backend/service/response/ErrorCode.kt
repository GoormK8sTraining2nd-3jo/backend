package kr.kua.backend.service.response

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(val status: Int, val code: String, val message: String) {

    // Common
    SUCCESS(302, "0", "Success"),
}