package com.redvelvet.ui.screen.fun_activites

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun FunItem(
    onClickItem: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .height(212.dp)
            .clickable{onClickItem()},

        ) {

        Image(
            painter =  rememberAsyncImagePainter(""), // painterResource(id = R.) ,//
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp))
                .height(212.dp),
        )

        Row(
            Modifier
                .fillMaxWidth()
                .height(212.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "CinemaRoom", color = Color.White, maxLines = 2, fontSize = 20.sp)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFunItem() {
    FunItem({})
}