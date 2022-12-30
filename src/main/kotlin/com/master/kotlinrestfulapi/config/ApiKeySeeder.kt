package com.master.kotlinrestfulapi.config

import com.master.kotlinrestfulapi.entity.ApiKey
import com.master.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)) {
            apiKeyRepository.save(ApiKey(id = apiKey))
        }
    }
}