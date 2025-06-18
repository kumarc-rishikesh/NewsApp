package com.example.newsapp.feature_news_page.presentation.news_items

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.feature_news_page.domain.use_case.NewsItemsUseCases
import com.example.newsapp.feature_news_page.domain.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsItemsViewModel @Inject constructor(
    private val newsItemsUseCases: NewsItemsUseCases
): ViewModel() {
    private val _state = mutableStateOf(NewsItemsState())
    val state : State<NewsItemsState> = _state

    private var getNewsJob: Job? = null

    init{
        getNewsItems()
    }

    private fun getNewsItems(){
        // cancel existing job
        getNewsJob?.cancel()

        // cannot directly use since not Flow(which is async). This is a green thread
        getNewsJob = viewModelScope.launch(Dispatchers.IO){
            val resp = newsItemsUseCases.getNewsItems()
            Log.d("check for data", resp.toString())
            when (resp.status){
                Status.SUCCESS -> {
                    _state.value = state.value.copy(
                        newsItems = resp.data!!
                    )
                }
                Status.ERROR -> {}
                Status.LOADING -> {}
            }
        }
    }

}