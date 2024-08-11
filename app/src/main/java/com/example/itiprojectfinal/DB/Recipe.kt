package com.example.itiprojectfinal.DB


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val instructions: String
)