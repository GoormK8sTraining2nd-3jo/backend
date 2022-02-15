package kr.kua.backend.dto.control

data class S3UploadImageRequest(
    val extension: String,
    val base64: String
)