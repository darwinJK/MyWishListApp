package com.example.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) { //creating repostiory for the dao
    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }
    fun getWish(): Flow<List<Wish>> = wishDao.getAllWishes() // flow acts us suspend so no need to call suspend function

    fun getWishByID(id:Long) : Flow<Wish> {
        return wishDao.getAWishById(id)
    }
    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }
    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}