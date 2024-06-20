package com.example.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // it tells that if the data gets repeated what to do, here it gets just ignored.
    abstract suspend fun addWish(wishEntity: Wish)

    //loads all the items inside wish table
    @Query("Select * from `wish-table`") //define what we want to load from database.
    abstract fun getAllWishes(): Flow<List<Wish>> //Live data
    // a simple and efficient way to handle asynchronous data stream in reactive way.
    //works wel in room to fetch and emit update during data manipulation.

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id = :id") //define what we want to load from database.
    abstract fun getAWishById(id:Long): Flow<Wish>

}