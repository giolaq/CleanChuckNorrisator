package com.laquysoft.cleanchucknorrisator.framework.network

class Endpoints {
    companion object {
        //Parameters
        const val PARAM_FIRST_NAME = "firstName"
        const val PARAM_LAST_NAME = "lastName"
        const val PARAM_JOKES_NUM = "Num"

        const val ICNDB_BASE = "https://api.icndb.com/"
        const val JOKES = "jokes/"
        const val RANDOM = "random"
        const val RANDOM_NUM = "random/" + PARAM_JOKES_NUM
    }
}
