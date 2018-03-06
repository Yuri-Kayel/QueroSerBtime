package yuri.kayel.dojopuzzles


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class FragAgileMeth : Fragment()
{


    override fun onCreateView(inflater : LayoutInflater?, container : ViewGroup?,
                              savedInstanceState : Bundle?) : View?
    {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.frag_agile_meth, container, false)
    }

}// Required empty public constructor
