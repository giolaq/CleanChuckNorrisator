package com.laquysoft.cleanchucknorrisator.features.chooser

import com.laquysoft.cleanchucknorrisator.framework.executor.ExecutionScheduler
import com.laquysoft.cleanchucknorrisator.framework.interactor.UseCase
import com.laquysoft.cleanchucknorrisator.prefs
import io.reactivex.Single
import javax.inject.Inject

class GetRandomJoke
@Inject constructor(private val jokeRepository: JokeRepository,
                    private val scheduler: ExecutionScheduler) : UseCase.RxSingle<Joke, UseCase.None>() {

    override fun build(params: None?): Single<Joke> =
            jokeRepository.joke(prefs.noExplicit).compose(scheduler.highPrioritySingle())
}