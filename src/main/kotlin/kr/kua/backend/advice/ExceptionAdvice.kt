package kr.kua.backend.advice

import kr.kua.backend.model.response.BaseResult
import kr.kua.backend.service.response.ErrorCode
import kr.kua.backend.service.response.ResponseService
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RequiredArgsConstructor
@RestControllerAdvice
class ExceptionAdvice {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var responseService: ResponseService

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected fun defaultException(request: HttpServletRequest, e: Exception): BaseResult {
        logger.error("${e.localizedMessage} | ${e.stackTrace.joinToString("\n")}")
        return responseService.getFailureResult(ErrorCode.UNKNOWN_ERROR)
    }
}