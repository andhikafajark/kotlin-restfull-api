package com.master.kotlinrestfulapi.service.impl

import com.master.kotlinrestfulapi.entity.Product
import com.master.kotlinrestfulapi.error.NotFoundException
import com.master.kotlinrestfulapi.model.CreateProductRequest
import com.master.kotlinrestfulapi.model.ListProductRequest
import com.master.kotlinrestfulapi.model.ProductResponse
import com.master.kotlinrestfulapi.model.UpdateProductRequest
import com.master.kotlinrestfulapi.repository.ProductRepository
import com.master.kotlinrestfulapi.service.ProductService
import com.master.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = findProductById(id)

        return convertProductToProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductById(id)

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductById(id)

        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.offset, listProductRequest.limit))
        val products = page.get().collect(Collectors.toList())

        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductById(id: String): Product {
        return productRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}