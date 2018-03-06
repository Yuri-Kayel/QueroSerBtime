package yuri.kayel.dojopuzzles.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import yuri.kayel.dojopuzzles.R


/**
 * A simple [Fragment] subclass.
 */
class FragLocalPersist : Fragment()
{
    override fun onCreateView(inflater : LayoutInflater?, container : ViewGroup?, savedInstanceState : Bundle?) : View?
    {
        activity.title = getString(R.string.local_persist)
        return inflater!!.inflate(R.layout.frag_local_persist, container, false)
    }
}