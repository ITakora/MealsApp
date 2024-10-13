package com.example.mealsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mealsapp.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(category: Category, navigateBack: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { CenterAlignedTopAppBar(title = { Text(text = category.strCategory)}, 
        navigationIcon = {
        IconButton(onClick = navigateBack) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Localized description"
            )
        }
    }
    ) }) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {
            Image(painter = rememberAsyncImagePainter(category.strCategoryThumb ),
                modifier = Modifier.wrapContentSize()
                    .size(200.dp),
                contentDescription ="Thumbnail",
                alignment = Alignment.Center
                )
            Text(text = category.strCategoryDescription, textAlign = TextAlign.Justify, modifier = Modifier.verticalScroll(
                rememberScrollState()) )
        }
        
    }
}