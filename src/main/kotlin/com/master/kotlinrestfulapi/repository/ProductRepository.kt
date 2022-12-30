package com.master.kotlinrestfulapi.repository

import com.master.kotlinrestfulapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>