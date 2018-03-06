package yuri.kayel.bookofeulogies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yuri.kayel.dojopuzzles.R
import yuri.kayel.bookofeulogies.model.Hero
import yuri.kayel.bookofeulogies.util.Pop.toast
import yuri.kayel.bookofeulogies.util.Util.context
import java.util.*

/**
 * Created by kayel on 2017-09-25.
 */

class AdapterBase(private val heroList: MutableList<Hero>) : RecyclerView.Adapter<AdapterBase.Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
    {
        return Holder(LayoutInflater.from(context).inflate(R.layout.recycler_hero_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int)
    {
        try
        {

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

    fun remove(position: Int)
    {
        heroList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun swap(firstPosition: Int, secondPosition: Int)
    {
        Collections.swap(heroList, firstPosition, secondPosition)
        notifyItemMoved(firstPosition, secondPosition)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)
    {
//        var hero_container = view.hero_container
//        var hero_name = view.hero_name
//        var hero_thumb = view.hero_thumb
    }
}
