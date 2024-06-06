package com.example.henryrosario_ap2_p1.presentation.servicio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
import com.example.henryrosario_ap2_p1.ui.theme.HenryRosario_AP2_P1Theme


@Composable
fun ServicioListScreen(
    viewModel: ServicioViewModel,
    onVerServicio: (ServicioEntity) -> Unit
) {
    val servicios by viewModel.servicios.collectAsStateWithLifecycle()
    ServicioListBody(
        servicios = servicios,
        onVerServicio = onVerServicio
    )
}
@Composable
fun ServicioListBody(
    servicios: List<ServicioEntity>,
    onVerServicio: (ServicioEntity) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(servicios) { servicio ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onVerServicio(servicio) }
                        .padding(16.dp)
                ) {
                    Text(text = servicio.servicioId.toString(), modifier = Modifier.weight(0.10f))
                    servicio.descripcion?.let { Text(text = it, modifier = Modifier.weight(0.400f)) }
                    servicio.precio?.let { Text(text = it, modifier = Modifier.weight(0.40f)) }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ServicioListPreview() {
    val servicios = listOf(
        ServicioEntity(
            descripcion = "Henry Rosario",
            precio =  "500"
        )
    )
   HenryRosario_AP2_P1Theme {
      ServicioListBody(servicios = servicios) {

        }
    }
}

