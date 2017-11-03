package com.laquysoft.cleanchucknorrisator.features.chooser

import com.laquysoft.cleanchucknorrisator.framework.extension.empty

class Joke
private constructor(val id: Int, val joke: String, val categories: List<String>) {

    private constructor(builder: Builder) : this(builder.id, builder.joke, builder.categories)

    companion object { fun create(init: Builder.() -> Unit) = Builder(init).build() }

    class Builder private constructor() {
        constructor(init: Builder.() -> Unit) : this() { init() }

        var id = 0
        var joke = String.empty()
        var categories = listOf<String>()

        fun build() = Joke(this)
    }
}