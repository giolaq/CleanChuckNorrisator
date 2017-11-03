package com.laquysoft.cleanchucknorrisator.framework.network

import com.laquysoft.cleanchucknorrisator.features.chooser.JokeResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface JokesApi {
    @GET(Endpoints.JOKES+Endpoints.RANDOM) fun randomJoke(): Single<JokeResponse>
}