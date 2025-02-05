package com.ernestgichiri.farmhub.data.mapper

import com.ernestgichiri.farmhub.data.dto.UserEntity
import com.ernestgichiri.farmhub.domain.entity.user.UserInformationEntity

fun UserInformationEntity.toUserEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        email = this.email,
        phone = this.phone,
        image = this.image,
        password = this.password
    )
}

fun UserEntity.toUserInformationEntity(): UserInformationEntity {
    return UserInformationEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        email = this.email,
        phone = this.phone,
        image = this.image,
        password = this.password,
        token = "" // JWT token is not needed for local storage
    )
}
