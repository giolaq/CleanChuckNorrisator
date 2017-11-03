package com.laquysoft.cleanchucknorrisator.framework.network

import com.laquysoft.cleanchucknorrisator.features.chooser.JokeResponse
import com.laquysoft.cleanchucknorrisator.features.neverendingjokes.JokesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface JokesApi {
    @GET(Endpoints.JOKES+Endpoints.RANDOM) fun randomJoke(): Single<JokeResponse>
    @GET(Endpoints.JOKES+Endpoints.RANDOM_NUM) fun randomJokes(@Path(Endpoints.PARAM_JOKES_NUM) number: Int): Single<JokesResponse>
    @GET(Endpoints.JOKES+Endpoints.RANDOM)
    fun randomJokeChangedName(@Query(Endpoints.PARAM_FIRST_NAME) name: String?,
                              @Query(Endpoints.PARAM_LAST_NAME) surname: String?): Single<JokeResponse>
}