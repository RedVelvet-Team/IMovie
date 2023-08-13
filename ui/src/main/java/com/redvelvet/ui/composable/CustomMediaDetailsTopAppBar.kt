package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Primary

@Composable
fun CustomMediaDetailsTopAppBar(
    onBackClicked: () -> Unit,
    onFavoriteClicked: () -> Unit,
    onSaveClicked: () -> Unit,
    isScrolled: Boolean
) {
    val background = if (isScrolled) Primary else Color.Transparent
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(background)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .shadow(if (isScrolled) 3.dp else 0.dp, ambientColor = Color(0x15ffffff))
    ) {

        Icon(
            painter = painterResource(id = R.drawable.icon_back),
            contentDescription = "Back",
            modifier = Modifier.clickable { onBackClicked() },
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.icon_favorite),
            contentDescription = "Favorite",
            modifier = Modifier.clickable { onFavoriteClicked() },
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.icon_save),
            contentDescription = "Save",
            modifier = Modifier.clickable { onSaveClicked() },
            tint = Color.White
        )
    }
}
