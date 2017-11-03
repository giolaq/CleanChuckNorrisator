package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.features.chooser.JokeRepository
import com.laquysoft.cleanchucknorrisator.framework.executor.ExecutionScheduler
import com.laquysoft.cleanchucknorrisator.framework.interactor.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetRandomJokes
@Inject constructor(private val jokeRepository: JokeRepository,
                    private val scheduler: ExecutionScheduler) : UseCase.RxSingle<List<Joke>, UseCase.None>() {

    val numberOfJokes = 20
    override fun build(params: None?): Single<List<Joke>> =
            jokeRepository.jokes(numberOfJokes).compose(scheduler.highPrioritySingle())

}