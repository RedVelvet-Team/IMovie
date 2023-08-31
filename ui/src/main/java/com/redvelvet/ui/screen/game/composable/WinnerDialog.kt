package com.redvelvet.ui.screen.game.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.BasicDialog
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color

@Composable
fun WinnerDialog(
    onClickHome : () -> Unit,
    onClickPlayAgain : () -> Unit,
    score: Int,
) {
    BasicDialog(
        submitText = "Play again",
        cancelText = "Home",
        onSubmitClick = onClickPlayAgain,
        onClickCancel = onClickHome
    ) {
        Icon(
            modifier = Modifier
                .size(84.dp)
                .padding(bottom = 16.dp),
            painter = painterResource(id = R.drawable.ic_winner),
            contentDescription = "",
        )
        Text(
            modifier = Modifier
                .width(117.dp)
                .padding(bottom = 16.dp),
            text = "Congratulation you earned $score",
            textAlign = TextAlign.Center,
            style = Typography.labelMedium,
            color = MaterialTheme.color.fontPrimary
        )
    }
}