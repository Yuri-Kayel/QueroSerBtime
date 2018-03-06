package yuri.kayel.bookofeulogies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import yuri.kayel.dojopuzzles.R
import yuri.kayel.dojopuzzles.activity.ActHome
import kotlinx.android.synthetic.main.recycler_hero_item.view.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk25.coroutines.onClick
import yuri.kayel.bookofeulogies.model.Hero
import yuri.kayel.bookofeulogies.util.Pop.toast
import yuri.kayel.bookofeulogies.util.Util.context
import yuri.kayel.bookofeulogies.util.Util.start

/**
 * Created by kayel on 2017-09-25.
 */

class AdapterHero(private val heroList: MutableList<Hero>) : RecyclerView.Adapter<AdapterHero.Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
    {
        return Holder(LayoutInflater.from(context).inflate(R.layout.recycler_hero_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int)
    {
        try
        {
            val hero = heroList.get(position)
            holder.hero_name.text = hero.heroName
            holder.hero_thumb.imageResource = hero.thumb
            holder.hero_container.tag = hero
            holder.hero_container.onClick { start(ActHome::class.java) }
        }
        catch (x: Exception)
        {
            toast(x.message)
        }
    }

    override fun getItemCount(): Int
    {
        return heroList.size
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)
    {
        var hero_container: LinearLayout = view.hero_container
        var hero_name: TextView = view.hero_name
        var hero_thumb: ImageView = view.hero_thumb
    }
}
