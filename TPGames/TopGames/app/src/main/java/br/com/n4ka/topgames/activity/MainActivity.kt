package br.com.n4ka.topgames.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import br.com.n4ka.topgames.R
import br.com.n4ka.topgames.adapter.GameAdapter
import br.com.n4ka.topgames.bean.GameResponse
import br.com.n4ka.topgames.bean.TopBean
import br.com.n4ka.topgames.util.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    var gameResponse : GameResponse? = null
    lateinit var listTopGame : List<TopBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)

        gridlistGames.setOnItemClickListener(this)

    }

    override fun onResume() {
        super.onResume()

        val call = RetrofitInitializer().servicoParametro.getGames("2z7mezxwdaop2ny0uouccd6dk502wt")
        call.enqueue(object : Callback<GameResponse> {
            override fun onResponse(call: Call<GameResponse>?, response: Response<GameResponse>?) {
                val statucode: Int = response!!.code()

                if (response.code() == 200){
                    gameResponse  = response.body()!!

                    listTopGame = gameResponse!!.top;
                    gridlistGames.setAdapter(GameAdapter(this@MainActivity, listTopGame))

                }else{

                    toast("Erro ao carregar a lista")

                }
            }

            override fun onFailure(call: Call<GameResponse>?, t: Throwable?) {

                toast("Erro ao carregar a lista")
            }

        })
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val tpg : TopBean = listTopGame.get(position);

        val visualizacao : String = tpg.viewers.toString()
        val canal : String = tpg.channels.toString()
        val imagem : String = tpg.game.box.large
        val nome : String = tpg.game.name

        val intent = Intent(this, GameDetalheActivity::class.java)
        intent.putExtra("visualizacao", visualizacao)
        intent.putExtra("canal", canal)
        intent.putExtra("imagem", imagem)
        intent.putExtra("nome", nome)
        startActivity(intent)

    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

