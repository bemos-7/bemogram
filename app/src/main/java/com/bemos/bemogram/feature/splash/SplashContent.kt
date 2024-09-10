package com.bemos.bemogram.feature.splash

import androidx.collection.arrayMapOf
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bemos.bemogram.ui.theme.Nunito

@Composable
fun SplashContent(modifier: Modifier = Modifier) {
    var animateIn by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        animateIn = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = animateIn,
            enter = fadeIn(
                spring(stiffness = Spring.StiffnessHigh)
            ) + scaleIn(
                initialScale = .1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            ),
            exit = scaleOut(
                targetScale = 0.1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            ) + fadeOut(
                animationSpec = spring(stiffness = Spring.StiffnessHigh)
            )
        ) {
            Text(
                text = "bemogram",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Nunito,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
private fun SplashContentPreview() {
    SplashContent()
}