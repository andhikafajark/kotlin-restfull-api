package com.master.kotlinrestfulapi.service

import com.master.kotlinrestfulapi.entity.Product
import com.master.kotlinrestfulapi.model.CreateProductRequest
import com.master.kotlinrestfulapi.model.ListProductRequest
import com.master.kotlinrestfulapi.model.ProductResponse
import com.master.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}