package com.master.kotlinrestfulapi.auth

import com.master.kotlinrestfulapi.error.UnauthorizedException
import com.master.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor, HandlerInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-API-KEY") ?: throw UnauthorizedException()

        if (!apiKeyRepository.existsById(apiKey)) {
            throw UnauthorizedException()
        }
        // Valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // Nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // Nothing
    }
}