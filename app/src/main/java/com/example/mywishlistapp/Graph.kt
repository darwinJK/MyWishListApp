package com.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.example.mywishlistapp.data.WishDatabase
import com.example.mywishlistapp.data.WishRepository

object Graph { // effectively acting as a simple dependency container where it initializes and provides
    // instances and of the database and repository needed by the app.
    lateinit var database:WishDatabase

    val wishRepository by lazy { // by lazy make sure that the variable only initialized once.
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,WishDatabase::class.java,"wishList.db").build()
    }
}
