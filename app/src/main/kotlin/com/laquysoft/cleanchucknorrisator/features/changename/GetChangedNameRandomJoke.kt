package com.laquysoft.cleanchucknorrisator.features.changename

import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.features.chooser.JokeRepository
import com.laquysoft.cleanchucknorrisator.framework.executor.ExecutionScheduler
import com.laquysoft.cleanchucknorrisator.framework.interactor.UseCase
import com.laquysoft.cleanchucknorrisator.features.changename.GetChangedNameRandomJoke.Params
import io.reactivex.Single
import javax.inject.Inject

class GetChangedNameRandomJoke
@Inject constructor(private val jokeRepository: JokeRepository,
                    private val scheduler: ExecutionScheduler) : UseCase.RxSingle<Joke, Params>() {

    override fun build(params: Params?): Single<Joke> =
            jokeRepository.jokeChangedName(params!!.name, params!!.surname).compose(scheduler.highPrioritySingle())


    data class Params(val name: String?, val surname: String?)

}