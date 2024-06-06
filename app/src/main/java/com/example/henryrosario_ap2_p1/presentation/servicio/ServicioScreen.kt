import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
import com.example.henryrosario_ap2_p1.presentation.servicio.ServicioViewModel
import com.example.henryrosario_ap2_p1.ui.theme.HenryRosario_AP2_P1Theme


@Composable
fun ServicioScreen(
    viewModel: ServicioViewModel
) {
    val servicio by viewModel.servicios.collectAsStateWithLifecycle()
    ServicioBody(
        onSaveServicio = { servicio ->
            viewModel.saveServicio(servicio)
        }
    )
}

@Composable
fun ServicioBody(onSaveServicio: (ServicioEntity) -> Unit) {
    var servicioId by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf(0) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {


            OutlinedTextField(
                label = { Text(text = "Descripcion") },
                value = descripcion,
                onValueChange = { descripcion = it },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = { Text(text = "Precio") },
                value = precio.toString(),
                onValueChange = { precio = it.toIntOrNull() ?: 0 },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    onClick = {
                        servicioId = ""
                        descripcion = ""
                        precio = 0
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "new button"
                    )
                    Text(text = "Nuevo")
                }
                OutlinedButton(
                    onClick = {
                        onSaveServicio(
                            ServicioEntity(
                                servicioId = servicioId.toIntOrNull(),
                                descripcion = descripcion,
                                precio =  precio.toString()
                            )
                        )
                        servicioId = ""
                       descripcion = ""
                       precio = 0
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "save button"
                    )
                    Text(text = "Guardar")
                }
            }
        }

    }

}


@Preview
@Composable
private fun ServicioPreview() {
    HenryRosario_AP2_P1Theme {

        ServicioBody() {
        }
    }
}