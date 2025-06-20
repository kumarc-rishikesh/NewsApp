package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.feature_news_page.presentation.news_display.NewsDisplayScreen
import com.example.newsapp.feature_news_page.presentation.news_items.NewsItemScreen
import com.example.newsapp.feature_news_page.presentation.utils.NewsViewModel
import com.example.newsapp.feature_news_page.presentation.utils.Screen
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                val viewModel: NewsViewModel by viewModels()
                NavHost(
                    navController = navController,
                    startDestination = Screen.NewsItemsScreen.route
                ){
                    composable(route = Screen.NewsItemsScreen.route){
                        NewsItemScreen(navController)
                    }
                    composable(
                        route = Screen.NewsDisplayScreen.route + "?author={author}&title={title}&description={description}&url={url}&urlToImage={urlToImage}&publishedAt={publishedAt}&content={content}",
                        arguments = listOf(
                            navArgument(name = "author"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "title"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "description"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "url"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "urlToImage"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "publishedAt"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(name = "content"){
                                type = NavType.StringType
                                defaultValue = ""
                            },
                        )
                    ){
                        NewsDisplayScreen(
                            navController = navController,
                            author = it.arguments?.getString("author") ?: "",
                            title = it.arguments?.getString("title") ?: "",
                            description = it.arguments?.getString("description") ?: "",
                            url = it.arguments?.getString("url") ?: "",
                            urlToImage = it.arguments?.getString("urlToImage") ?: "",
                            publishedAt = it.arguments?.getString("publishedAt") ?: "",
                            content = it.arguments?.getString("content") ?: ""
                        )
                    }
                }
            }
        }
    }
}