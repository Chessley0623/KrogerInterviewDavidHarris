package com.kroger.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroger.start.db.Comic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(private val repository: ComicRepository) : ViewModel() {

    val currentComic = MutableLiveData<Comic>()

    fun getCurrentComic(){

        viewModelScope.launch {

            val response = repository.getCurrentComic()
            currentComic.postValue(response)
        }
    }
}
