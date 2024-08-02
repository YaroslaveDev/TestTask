package com.pfv.abzagencytesttask.ui.common.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImageFromNetwork(
    imgSource: Any,
    modifier: Modifier
) {

    GlideImage(
        modifier = modifier,
        imageModel = imgSource,
        success = {
            it.drawable?.toBitmap()?.asImageBitmap()?.let {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    bitmap = it,
                    contentDescription = "img"
                )
            }
        }
    )
}