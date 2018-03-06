package yuri.kayel.bookofeulogies.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView

import yuri.kayel.dojopuzzles.R

/**
 * Created by rodri on 19/09/2016.
 */
class SimpleDividerItemDecoration(context : Context) : RecyclerView.ItemDecoration()
{
    private val divider : Drawable

    init
    {
        divider = context.resources.getDrawable(R.drawable.line_divider)
    }

    override fun onDrawOver(c : Canvas , parent : RecyclerView , state : RecyclerView.State?)
    {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount)
        {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left , top , right , bottom)
            divider.draw(c)
        }
    }
}