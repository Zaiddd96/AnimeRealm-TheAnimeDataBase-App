package com.example.animerealm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.animerealm.model.DateDetails
import com.example.animerealm.model.ImageDetail
import com.example.animerealm.model.Images
import com.example.animerealm.model.Manga
import com.example.animerealm.model.Prop
import com.example.animerealm.model.Published

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen"){
            SplashScreen(navController)
        }
        composable("HomeScreen") {
            HomeScreen { manga ->
                navController.currentBackStackEntry?.savedStateHandle?.set("manga", manga)
                navController.navigate("DetailedScreen")
            }
        }
        composable("DetailedScreen") {
            val manga = navController.previousBackStackEntry?.savedStateHandle?.get<Manga>("manga") ?: Manga(
                malId = 0,
                url = "",
                images = Images(
                    jpg = ImageDetail("", "", ""),
                    webp = ImageDetail("", "", "")
                ),
                approved = false,
                titles = emptyList(),
                title = "",
                titleEnglish = null,
                titleJapanese = "",
                titleSynonyms = emptyList(),
                type = "",
                chapters = null,
                volumes = null,
                status = "",
                publishing = false,
                published = Published("", null, Prop(DateDetails(0, 0, 0), null), ""),
                score = 0.0,
                scored = 0.0,
                scoredBy = 0,
                rank = null,
                popularity = 0,
                members = 0,
                favorites = 0,
                synopsis = "",
                background = null,
                authors = emptyList(),
                serializations = emptyList(),
                genres = emptyList(),
                themes = emptyList(),
                demographics = emptyList()
            )

            DetailScreen(manga = manga)
        }
    }
}