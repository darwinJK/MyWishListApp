package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChange(newSting: String) {
        wishTitleState = newSting
    }

    fun onWishDescriptionChange(newSting: String) {
        wishDescriptionState = newSting
    }

    lateinit var getAllWishes: Flow<List<Wish>>
    // promise that we make to the kotlin that
// variable will be initialized before you call any operations on it.

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWish()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { //IO - Input(add a wish), output(load a wish)
            //dispatchers are responsible for deciding what thread or threads the coroutine will run on.
            wishRepository.addWish(wish = wish)
        }
    }

    fun getAWishById(id:Long):Flow<Wish> {
        return wishRepository.getWishByID(id)
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { //IO - Input(add a wish), output(load a wish)
            //dispatchers are responsible for deciding what thread or threads the coroutine will run on.
            wishRepository.updateWish(wish = wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { //IO - Input(add a wish), output(load a wish)
            //dispatchers are responsible for deciding what thread or threads the coroutine will run on.
            wishRepository.deleteWish(wish = wish)
        }
    }
}
