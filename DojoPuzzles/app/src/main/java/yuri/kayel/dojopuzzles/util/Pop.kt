package yuri.kayel.bookofeulogies.util

import android.content.Context
import android.util.Log.*
import android.widget.Toast.*

import com.chootdev.csnackbar.Duration.*
import com.chootdev.csnackbar.Snackbar.*
import com.chootdev.csnackbar.Type
import com.chootdev.csnackbar.Type.*
import com.chootdev.csnackbar.Type.CUSTOM
import org.jetbrains.anko.alert
import yuri.kayel.bookofeulogies.util.Util.context

/**
 * Created by Kayel on 29/08/17.
 */

object Pop {

    fun log(message: String?) {
        d(context.javaClass.name, message)
    }

    fun log(context: Context, message: String?) {
        d(context.javaClass.name, message)
    }

    fun toast(message: String?) {
        makeText(context, message, LENGTH_SHORT).show()
    }

    fun snack(message: String?) {
        with(context, null)
        type(CUSTOM)
        message(message)
        duration(LONG)
        show()
    }

    fun infiniteSnack(message: String?) {
        with(context, null)
        type(CUSTOM)
        message(message)
        duration(INFINITE)
        show()
    }

    fun errorSnack(message: String?) {
        with(context, null)
        type(Type.ERROR)
        message(message)
        duration(INFINITE)
        show()
    }

    fun successSnack(message: String?) {
        with(context, null)
        type(SUCCESS)
        message(message)
        duration(LONG)
        show()
    }

    fun updateSnack(message: String?) {
        with(context, null)
        type(UPDATE)
        message(message)
        duration(LONG)
        show()
    }

    fun alert(message: String?) {
        context.alert(message!!, "Exception").show()
    }
}
