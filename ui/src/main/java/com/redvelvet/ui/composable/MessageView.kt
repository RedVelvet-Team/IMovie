package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun MessageView(
    messageIcon: Painter,
    messageTitle: String,
    messageDescription: String,
    modifier: Modifier = Modifier,
    messageTitleStyle: TextStyle = Typography.labelLarge,
    messageDescriptionStyle: TextStyle = Typography.displaySmall,
    spacingBetweenTitleAndImage: Dp = MaterialTheme.spacing.spacing32,
    spacingBetweenTitleAndDescription: Dp = MaterialTheme.spacing.spacing4,
    messageIconHeight: Dp = MaterialTheme.dimens.dimens70,
    messageIconWidth: Dp = MaterialTheme.dimens.dimens78,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.height(messageIconHeight).width(messageIconWidth),
            painter = messageIcon,
            contentDescription = stringResource(R.string.no_search_results)
        )
        Text(
            modifier = Modifier.padding(top = spacingBetweenTitleAndImage),
            text = messageTitle,
            style = messageTitleStyle,
            color = MaterialTheme.color.fontSecondary
        )
        Text(
            text = messageDescription,
            style = messageDescriptionStyle,
            color = MaterialTheme.color.fontAccent,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = spacingBetweenTitleAndDescription)
        )
    }
}
