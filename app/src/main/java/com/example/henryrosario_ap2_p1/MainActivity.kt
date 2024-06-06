package com.example.henryrosario_ap2_p1

import ServicioScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.henryrosario_ap2_p1.data.local.database.servicioDb
import com.example.henryrosario_ap2_p1.data.repository.ServicioRepository
import com.example.henryrosario_ap2_p1.presentation.navigation.Parcial1NavHost
import com.example.henryrosario_ap2_p1.presentation.servicio.ServicioListScreen
import com.example.henryrosario_ap2_p1.presentation.servicio.ServicioViewModel
import com.example.henryrosario_ap2_p1.ui.theme.HenryRosario_AP2_P1Theme


class MainActivity : ComponentActivity() {
    private lateinit var servicioDb: servicioDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        servicioDb = Room.databaseBuilder(
            this,
            servicioDb::class.java,
            "Servicio.db"
        )
            .fallbackToDestructiveMigration()
            .build()
        val repository = ServicioRepository(servicioDb.servicioDao())

        enableEdgeToEdge()
        setContent {
            HenryRosario_AP2_P1Theme {
                Surface {
                    val viewModel: ServicioViewModel
                            = viewModel(
                        factory = ServicioViewModel.provideFactory(repository)
                    )
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .padding(8.dp)
                        ) {


                           ServicioScreen(viewModel = viewModel)
                            ServicioListScreen(viewModel = viewModel,
                                onVerServicio = {

                                })
                        }
                    }
                }
            }
        }
    }
}

@// TODO: El codigo esta completo pero no llego a la ejecucion correcta por el siguiente error ->   Caused by: org.jetbrains.kotlin.gradle.tasks.CompilationErrorException: Compilation error. See log for more details



@Preview(showBackground = true)
@Composable
fun Preview() {
   HenryRosario_AP2_P1Theme {

    }
}