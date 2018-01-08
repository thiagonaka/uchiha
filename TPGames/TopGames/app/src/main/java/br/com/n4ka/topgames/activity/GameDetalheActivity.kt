package br.com.n4ka.topgames.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.com.n4ka.topgames.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_game_detalhe.*

class GameDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detalhe)

        val visualizacao:String = intent.getStringExtra("visualizacao")
        val canal:String = intent.getStringExtra("canal")
        val imagem:String = intent.getStringExtra("imagem")
        val nome:String = intent.getStringExtra("nome")

        txtVisualizacoes.setText(visualizacao)
        txtCanal.setText(canal)
        txtNome.setText(nome)
        imgGameDetalhe.loadUrl(imagem)
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}
