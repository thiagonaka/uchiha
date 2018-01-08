package br.com.n4ka.topgames.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import br.com.n4ka.topgames.R
import br.com.n4ka.topgames.bean.TopBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_games.view.*

/**
 * Created by Thiago on 07/01/2018.
 */
class GameAdapter(context: Context, listGames : List<TopBean>) : BaseAdapter() {

    private val listGames = listGames
    private val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder =  LayoutInflater.from(context)
                .inflate(R.layout.adapter_games, parent, false)

        val lg : TopBean = listGames.get(position)

        val nome : String = lg.game.name
        val img : String = lg.game.box.large

        viewHolder.nomeGame.setText(nome)
        viewHolder.imgGame.loadUrl(img)

        return viewHolder
    }

    override fun getItem(position: Int): Any {
        return listGames[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listGames.size
    }


    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}