package com.film.guide.screens.map

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.film.guide.screens.components.Title
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen() {
    Column(modifier = Modifier.fillMaxSize()){
        Title(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = "Кинотеатры"
        )

        Title(
            Modifier
                .fillMaxWidth().weight(1f)
                .padding(16.dp)
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp)),
            text = "Здесь будет карта"
        )

    }
}