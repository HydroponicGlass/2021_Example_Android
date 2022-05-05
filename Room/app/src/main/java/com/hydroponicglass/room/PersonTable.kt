package com.hydroponicglass.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonTable (
    @PrimaryKey val id: Int,
    val name: String,
    val age: Int,
)