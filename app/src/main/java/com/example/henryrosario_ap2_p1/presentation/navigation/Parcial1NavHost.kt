package com.example.henryrosario_ap2_p1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Parcial1NavHost(navHostController: NavHostController) {
   NavHost(navController = navHostController,
       startDestination = Screen.List) {

       composable<Screen.List>{
           //Aqui el componente de la lista

       }
       composable<Screen.Registro>{

       }
   }
}