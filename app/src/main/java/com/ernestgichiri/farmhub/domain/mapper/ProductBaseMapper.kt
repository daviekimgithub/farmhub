package com.ernestgichiri.farmhub.domain.mapper

interface ProductBaseMapper<I, O> {
    fun map(input: I): O
}
