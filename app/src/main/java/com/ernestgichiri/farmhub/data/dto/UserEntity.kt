package com.ernestgichiri.farmhub.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val image: String,
    val password: String
)
