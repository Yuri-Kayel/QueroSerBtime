package yuri.kayel.dojopuzzles.fragment


import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_diamonds.*
import org.jetbrains.anko.sdk25.coroutines.onClick

import yuri.kayel.dojopuzzles.R
import yuri.kayel.dojopuzzles.presenter.FragDiamondsPresenter

/**
 * A simple [Fragment] subclass.
 */
class FragDiamonds : Fragment(), FragDiamondsPresenter.IFragDiamondsView
{
    private var presenter : FragDiamondsPresenter? = null

    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View?
    {
        activity.title = getString(R.string.diamonds)

        return inflater!!.inflate(R.layout.frag_diamonds, container, false)
    }

    override fun setPresenter(presenter : FragDiamondsPresenter)
    {
        this.presenter = presenter
    }

    override fun onViewCreated(view : View?, savedInstanceState : Bundle?)
    {
        FragDiamondsPresenter(this)

        frag_diamonds_output.typeface = Typeface.MONOSPACE

        frag_diamonds_button_ok?.onClick { presenter!!.updateOutput(userInput()) }
    }

    private fun userInput() = frag_diamonds_input.text.toString().toUpperCase()

    override fun display(output : String)
    {
        frag_diamonds_output.text = output
    }

    override fun setOutputTextSize(size : Float)
    {
        frag_diamonds_output.textSize = size
    }

}