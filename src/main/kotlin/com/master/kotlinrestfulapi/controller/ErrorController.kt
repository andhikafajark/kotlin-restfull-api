package com.master.kotlinrestfulapi.controller

import com.master.kotlinrestfulapi.error.NotFoundException
import com.master.kotlinrestfulapi.error.UnauthorizedException
import com.master.kotlinrestfulapi.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            message = "Bad Request",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException): WebResponse<String?> {
        return WebResponse(
            code = 404,
            message = "Not Found",
            data = null
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorizedHandler(unauthorizedException: UnauthorizedException): WebResponse<String?> {
        return WebResponse(
            code = 401,
            message = "Unauthorized",
            data = null
        )
    }
}