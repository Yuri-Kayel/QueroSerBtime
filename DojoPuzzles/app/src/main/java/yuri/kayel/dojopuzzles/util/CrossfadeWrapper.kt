package yuri.kayel.bookofeulogies.util

import com.mikepenz.crossfader.Crossfader
import com.mikepenz.materialdrawer.interfaces.ICrossfader

/**
 * Created by kayel on 30/10/17.
 */

class CrossfadeWrapper(private val mCrossfader: Crossfader<*>) : ICrossfader
{
    override fun crossfade() = mCrossfader.crossFade()

    override fun isCrossfaded() = mCrossfader.isCrossFaded()
}