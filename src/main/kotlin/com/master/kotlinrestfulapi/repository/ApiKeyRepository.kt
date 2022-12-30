package com.master.kotlinrestfulapi.repository

import com.master.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String>