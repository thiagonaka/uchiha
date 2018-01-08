package br.com.n4ka.topgames.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Thiago on 07/01/2018.
 */
class RetrofitInitializer {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.twitch.tv")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val servicoParametro = retrofit.create(ServicoParametro::class.java)


}