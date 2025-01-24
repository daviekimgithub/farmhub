package com.ernestgichiri.farmhub.data.mapper

import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.data.dto.Product
import javax.inject.Inject

class SingleProductEntityMapper @Inject constructor() :
    ProductBaseMapper<Product, DetailProductEntity> {
    override fun map(input: Product): DetailProductEntity {
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price,
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}
