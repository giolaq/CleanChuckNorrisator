package com.laquysoft.cleanchucknorrisator.framework.network

class Endpoints {
    companion object {
        //Parameters
        const val PARAM_MOVIE_ID = "movieId"

        //Api Urls
        const val BASE = "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture-Kotlin/"
        const val MOVIES = "movies.json"
        const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"

        const val ICNDB_BASE = "https://api.icndb.com/"
        const val JOKES = "jokes/"
        const val RANDOM = "random"
    }
}
