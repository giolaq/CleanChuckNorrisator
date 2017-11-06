package com.laquysoft.cleanchucknorrisator.features.chooser


data class JokeResponse(private val type: String, private val value: JokeEntity) {

    fun toJoke(): Joke {
        return Joke.create {
            this@JokeResponse.let {
                id = it.value.id
                joke = android.text.Html.fromHtml(it.value.joke).toString()
                categories = it.value.categories
            }
        }
    }


    data class JokeEntity(val id: Int, val joke: String, val categories: List<String>)
}