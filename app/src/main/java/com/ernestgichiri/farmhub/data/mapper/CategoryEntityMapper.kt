package com.ernestgichiri.farmhub.data.mapper

import com.ernestgichiri.farmhub.data.dto.Category
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
