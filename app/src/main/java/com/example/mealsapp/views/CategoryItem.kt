package com.example.mealsapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealsapp.model.Category

@Composable
fun CategoryScreen(categories: List<Category>) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) {
            category -> CategoryItem(category = category)
        }

    }
}

@Composable
fun CategoryItem(category: Category) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        
       Card(shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(
           defaultElevation = 6.dp
       ), modifier = Modifier
           .fillMaxSize()
           .aspectRatio(1f), colors = CardDefaults.cardColors(Color.White)
       ) {
           Image(painter = rememberAsyncImagePainter(category.strCategoryThumb ), contentDescription ="Thumbnail", modifier =Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
       }

        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )
    
    }
}