package com.master.kotlinrestfulapi.model

data class WebResponse<T>(
    val code: Int,
    val message: String,
    val data: T
)