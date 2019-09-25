package com.pu.challengepu.data.remote

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ChallengeApi {

    companion object {
        const val URL_BASE = "https://raw.githubusercontent.com/PeixeUrbano/"
    }

    @GET("desafio-android/master/api/deals.json")
    fun getListOffer(): Deferred<Response<ResponseBody>>

}
