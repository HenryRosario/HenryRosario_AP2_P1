package com.example.henryrosario_ap2_p1

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.henryrosario_ap2_p1.data.local.database.ServicioDb
import com.example.henryrosario_ap2_p1.presentation.navigation.Parcial1NavHost
import com.example.henryrosario_ap2_p1.ui.theme.HenryRosario_AP2_P1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity(), Parcelable {
    private lateinit var servicioDb: ServicioDb

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

           HenryRosario_AP2_P1Theme {
                val navHost = rememberNavController()

                Parcial1NavHost(navHost)

            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun Preview() {
   HenryRosario_AP2_P1Theme {

    }
}