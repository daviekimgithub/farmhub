package com.mustafaunlu.ecommerce_compose.data.mapper

import com.mustafaunlu.ecommerce_compose.data.dto.Category
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import javax.inject.Inject

class CategoryEntityMapper @Inject constructor() :
ProductListMapper<Category, String> {
    override fun map(input: List<Category>): List<String> {
        return input.map {
            it.name
        }
    }
}
