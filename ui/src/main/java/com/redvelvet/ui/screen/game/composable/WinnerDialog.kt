package com.redvelvet.ui.screen.game.composable

import androidx.compose.runtime.Composable

@Composable
fun WinnerDialog(
    onClickHome : () -> Unit,
    onClickPlayAgain : () -> Unit,
    score: Int,
) {
//    BasicDialog(
//        submitText = "Play again",
//        cancelText = "Home",
//        onSubmitClick = onClickPlayAgain,
//        onClickCancel = onClickHome
//    ) {
//        Icon(
//            modifier = Modifier
//                .size(84.dp)
//                .padding(bottom = 16.dp),
//            painter = painterResource(id = R.drawable.ic_winner),
//            contentDescription = "",
//        )
//        Text(
//            modifier = Modifier
//                .width(117.dp)
//                .padding(bottom = 16.dp),
//            text = "Congratulation you earned $score",
//            textAlign = TextAlign.Center,
//            style = Typography.labelMedium,
//            color = MaterialTheme.color.fontPrimary
//        )
//    }
}