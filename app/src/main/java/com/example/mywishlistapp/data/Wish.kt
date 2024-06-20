package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//table which has dataclass and having column with primary key and column name
@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)    //select the primary key which is unique
    val id: Long = 0L,  //here id is used us primary key
    @ColumnInfo(name ="wish-title") // giving column name
    val title : String= "",
    @ColumnInfo(name = "wish-desc")
    val description : String = ""
)
object Dummywish{
    val wishList = listOf(
        Wish(title = "google watch pixel 2", description = "an android watch"),
        Wish(title = "google pixel 7", description = "i love pixel"),
        Wish(title = "google pixel 7 pro", description = "pixel has wide varieties.")

    )
}