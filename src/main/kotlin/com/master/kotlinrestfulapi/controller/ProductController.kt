package com.master.kotlinrestfulapi.controller

import com.master.kotlinrestfulapi.model.*
import com.master.kotlinrestfulapi.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            message = "Product created successfully",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)

        return WebResponse(
            code = 200,
            message = "Product retrieved successfully",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("id") id: String,
        @RequestBody body: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, body)

        return WebResponse(
            code = 200,
            message = "Product updated successfully",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id") id: String): WebResponse<String?> {
        productService.delete(id)

        return WebResponse(
            code = 200,
            message = "Product deleted successfully",
            data = null
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value = "limit", defaultValue = "10") limit: Int,
        @RequestParam(value = "offset", defaultValue = "0") offset: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(limit, offset)
        val productResponse = productService.list(request)

        return WebResponse(
            code = 200,
            message = "Products retrieved successfully",
            data = productResponse
        )
    }
}