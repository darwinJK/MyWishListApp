package com.example.mywishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wish::class], // dataclass name
    version = 1,  // first database
    exportSchema = false
)
abstract class WishDatabase:RoomDatabase() {
    abstract fun wishDao(): WishDao
}