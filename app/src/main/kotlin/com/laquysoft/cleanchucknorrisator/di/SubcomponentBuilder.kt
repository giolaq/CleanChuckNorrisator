package com.laquysoft.cleanchucknorrisator.di

interface SubcomponentBuilder<out T> {
    fun build(): T
}
