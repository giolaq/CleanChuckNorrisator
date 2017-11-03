package com.laquysoft.cleanchucknorrisator.framework.network

import com.laquysoft.cleanchucknorrisator.features.chooser.JokeResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface JokesApi {
    @GET(Endpoints.JOKES+Endpoints.RANDOM) fun randomJoke(): Single<JokeResponse>
    @GET(Endpoints.JOKES+Endpoints.RANDOM)
    fun randomJokeChangedName(@Query(Endpoints.PARAM_FIRST_NAME) name: String?,
                              @Query(Endpoints.PARAM_LAST_NAME) surname: String?): Single<JokeResponse>
}