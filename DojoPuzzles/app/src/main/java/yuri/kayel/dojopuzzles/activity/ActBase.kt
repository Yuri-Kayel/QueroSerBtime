package yuri.kayel.dojopuzzles.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import yuri.kayel.bookofeulogies.util.Pop.errorSnack
import yuri.kayel.bookofeulogies.util.Util.context
import yuri.kayel.bookofeulogies.util.Util.goFullScreen


/**
 * Created by Kayel on 24/08/17.
 */

@SuppressLint("Registered")
open class ActBase : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        try
        {
            super.onCreate(savedInstanceState)

            context = this

            onCreateStart()

            dataSetup()

            viewSetup()

            onCreateEnd()
        }
        catch (e : Exception)
        {
            errorSnack(e.message)
        }
    }

    @SuppressLint("CommitPrefEdits")
    @Throws(Exception::class)
    open fun onCreateStart()
    {
//        goFullScreen(window)
    }

    @Throws(Exception::class)
    open fun dataSetup()
    {
    }

    @Throws(Exception::class)
    open fun viewSetup()
    {
    }

    @Throws(Exception::class)
    open fun onCreateEnd()
    {
    }

    override fun onResume()
    {
        super.onResume()
        context = this
    }
}
