package com.example.mywishlistapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.mywishlistapp.R

@Composable
fun AppBarView(
    title:String,
    onBackNavClicked:()->Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit)? =

        //if the page does not contains wishlist, it shows the back button else null
        if (title.contains("WishList")) {
            {
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        // used to mirror the icon bcz arabic and hebrews reading right to left
                        tint = Color.White,
                        contentDescription = null
                    )
                }
        }
        }else{
            null
        }

    TopAppBar(title = { Text(text = title, // displays information on the top of the app
        color = colorResource(id = R.color.white),
        modifier = Modifier
            .padding(start = 4.dp)
            .heightIn(max = 24.dp) ) },
// r gives us the resource folder and value inside then color. it has a source of color.
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color), // this is a color that we have created for the title bg
navigationIcon = navigationIcon
        )
}