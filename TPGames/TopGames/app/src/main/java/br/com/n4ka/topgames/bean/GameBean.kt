package br.com.n4ka.topgames.bean

/**
 * Created by Thiago on 07/01/2018.
 */
class GameBean(val name : String, val popularity: Long, val _id: Long,
               val giantbomb_id : Long, val box : BoxBean, val logo : LogoBean,
               val _links : LinksBean, val localized_name: String, val locale: String) {
}