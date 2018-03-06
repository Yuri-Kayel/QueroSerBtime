package yuri.kayel.dojopuzzles.util

import android.content.Context
import android.support.design.widget.NavigationView
import android.util.AttributeSet

/**
 * Created by yurik on 20/02/2018.
 */

class CustomNavigationView : NavigationView
{
    constructor(context : Context) : super(context)
    {
        super.setItemIconTintList(null)
    }

    constructor(context : Context, attrs : AttributeSet) : super(context, attrs)
    {
        super.setItemIconTintList(null)
    }

    constructor(context : Context, attrs : AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr)
    {
        super.setItemIconTintList(null)
    }
}
