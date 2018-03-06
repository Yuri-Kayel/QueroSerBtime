package yuri.kayel.bookofeulogies.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

import yuri.kayel.dojopuzzles.R

/*
  Source: http://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
  USAGE:

  ItemClickSupport.addTo(recycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View value) {
          // do it
      }
  });

*/
class ItemClickSupport(private val recycler: RecyclerView)
{
    private var clickListener: OnItemClickListener? = null
    private var longClickListener: OnItemLongClickListener? = null

    //region Interfaces
    interface OnItemClickListener
    {
        fun onItemClicked(recyclerView: RecyclerView, position: Int, view: View)
    }

    interface OnItemLongClickListener
    {
        fun onItemLongClicked(recyclerView: RecyclerView, position: Int, view: View): Boolean
    }

    //endregion

    //region Listeners
    private val onClickListener = View.OnClickListener { view ->
        if (clickListener != null)
        {
            clickListener!!.onItemClicked(recycler, recycler.getChildViewHolder(view).adapterPosition, view)
        }
    }

    private val onLongClickListener = View.OnLongClickListener { view ->
        if (longClickListener != null)
        {
            return@OnLongClickListener longClickListener!!
                    .onItemLongClicked(recycler, recycler.getChildViewHolder(view).adapterPosition, view)
        }
        false
    }

    private val attachListener = object : RecyclerView.OnChildAttachStateChangeListener
    {
        override fun onChildViewAttachedToWindow(view: View)
        {
            if (clickListener != null)
            {
                view.setOnClickListener(onClickListener)
            }
            if (longClickListener != null)
            {
                view.setOnLongClickListener(onLongClickListener)
            }
        }

        override fun onChildViewDetachedFromWindow(view: View)
        {

        }
    }
    //endregion

    init
    {
        recycler.setTag(R.id.item_click_support, this)
        recycler.addOnChildAttachStateChangeListener(attachListener)
    }

    fun setOnItemClickListener(listener: OnItemClickListener): ItemClickSupport
    {
        clickListener = listener
        return this
    }

    fun setOnItemLongClickListener(listener: OnItemLongClickListener): ItemClickSupport
    {
        longClickListener = listener
        return this
    }

    private fun detach(view: RecyclerView)
    {
        view.removeOnChildAttachStateChangeListener(attachListener)
        view.setTag(R.id.item_click_support, null)
    }

    companion object
    {
        fun addTo(view: RecyclerView): ItemClickSupport
        {
            var support: ItemClickSupport? = view.getTag(R.id.item_click_support) as ItemClickSupport
            if (support == null)
            {
                support = ItemClickSupport(view)
            }
            return support
        }

        fun removeFrom(view: RecyclerView): ItemClickSupport?
        {
            val support = view.getTag(R.id.item_click_support) as ItemClickSupport
            support.detach(view)
            return support
        }
    }
}