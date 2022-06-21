package com.kroger.start

import com.kroger.start.db.Comic
import com.kroger.start.network.ComicsApi
import retrofit2.Retrofit

class ComicRepository constructor(private val retrofitService: ComicsApi){
   suspend fun getCurrentComic() = retrofitService.getCurrentComic()
}

