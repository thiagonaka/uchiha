package br.com.n4ka.topgames.util


import br.com.n4ka.topgames.bean.GameResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by Thiago on 07/01/2018.
 */
interface ServicoParametro {

    @GET("/kraken/games/top?limit=100")
    fun getGames(@Header("Client-ID") clienteId : String): Call<GameResponse>

}