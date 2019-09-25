package com.pu.challengepu.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClient {

    companion object {

        private var client : ChallengeApi? = null

        @JvmStatic
        fun getClient(): ChallengeApi {
            if (client == null) {
                synchronized(ChallengeApi::javaClass) {
                    client = WebClient()
                        .initClient()
                }
            }
            return client!!
        }

        @JvmStatic
        fun clearInstance() {
            client = null
        }
    }


    fun initClient() : ChallengeApi? {

        val retrofit = Retrofit.Builder()
            .baseUrl(ChallengeApi.URL_BASE)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client = retrofit.create(ChallengeApi::class.java)

        return client
    }

}