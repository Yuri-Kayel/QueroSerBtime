package yuri.kayel.dojopuzzles.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import yuri.kayel.bookofeulogies.util.Util.context
import yuri.kayel.bookofeulogies.util.Util.start

/**
 * Created by Kayel on 30/08/17.
 */

class ActSplash : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)

        context = this

        start(ActHome::class.java)

        finish()
    }
}
