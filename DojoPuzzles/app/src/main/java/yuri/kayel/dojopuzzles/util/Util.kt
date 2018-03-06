package yuri.kayel.bookofeulogies.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.widget.EditText

import android.annotation.SuppressLint

import android.content.*
import android.net.Uri
import android.os.Parcelable
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.LocalBroadcastManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.View.*
import android.view.Window
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.*


@Suppress("NAME_SHADOWING")
@SuppressLint("StaticFieldLeak")
/**
 * Created by Kayel on 24/08/17.
 */

object Util
{
    var isReceiverRegistered : Boolean = false
    var registrationBroadcastReceiver : BroadcastReceiver? = null
    lateinit var gcmRegistrationToken : String
    lateinit var appContext : Context
    lateinit var baseContext : Context
    lateinit var context : AppCompatActivity

    var preferences : SharedPreferences? = null
    var preferencesEditor : SharedPreferences.Editor? = null

    var selectedRecycler = 0

//        fun wipeAllData()
//        {
//            preferencesEditor!!.run {
//                remove("strUsuario")
//                remove("strSenha")
//                remove("userName")
//                apply()
//            }
//            DBMensagens().purge()
//            DBMensalidades().purge()
//        }

//        fun lightNavigation(context : Context)
//        {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//            {
//                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                window.statusBarColor = resources.getColor(R.color.md_white_1000)
//            }
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//            {
//                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//            }
//        }

    fun goFullScreen(window : Window)
    {
        window.decorView.systemUiVisibility =
                SYSTEM_UI_FLAG_LOW_PROFILE or
                SYSTEM_UI_FLAG_FULLSCREEN or
                SYSTEM_UI_FLAG_LAYOUT_STABLE or
                SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    fun unregisterReceiver(context : Context)
    {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(registrationBroadcastReceiver)
        isReceiverRegistered = false
    }

    @SuppressLint("CommitPrefEdits")
    fun enforcePreferenceEditor()
    {
        if (preferencesEditor == null)
        {
            preferences = PreferenceManager.getDefaultSharedPreferences(appContext)
            preferencesEditor = preferences!!.edit()
        }
    }

    fun persist(key : String, value : String)
    {
        preferencesEditor!!.putString(key, value).apply()
    }

    fun persist(key : String, value : Int)
    {
        preferencesEditor!!.putInt(key, value).apply()
    }

    fun persist(key : String, value : Boolean)
    {
        preferencesEditor!!.putBoolean(key, value).apply()
    }

    fun persist(keys : Array<String>, values : Array<String>)
    {
        var index = 0

        for (key in keys)
        {
            preferencesEditor!!.putString(key, values[index])
            index++
        }
        preferencesEditor!!.apply()
    }

    fun persist(keys : Array<String>, values : Array<Int>)
    {
        var index = 0

        for (key in keys)
        {
            preferencesEditor!!.putInt(key, values[index])
            index++
        }
        preferencesEditor!!.apply()
    }

    fun persist(keys : Array<String>, values : Array<Boolean>)
    {
        var index = 0

        for (key in keys)
        {
            preferencesEditor!!.putBoolean(key, values[index])
            index++
        }
        preferencesEditor!!.apply()
    }

    fun persistRemove(keys : Array<String>)
    {
        for (key in keys)
        {
            preferencesEditor!!.remove(key)
        }
        preferencesEditor!!.apply()
    }

    fun start(activity : Class<*>)
    {
        context.startActivity(Intent(context, activity))
    }

    fun start(intent : Intent)
    {
        context.startActivity(intent)
    }

    fun start(activity : Class<*>, vararg flags : Int)
    {
        val intent = Intent(context, activity)

        for (flag in flags)
        {
            intent.addFlags(flag)
        }

        context.startActivity(intent)
    }

    fun start(activity : Class<*>,
              extraKey : Array<String>,
              extraValue : Array<Int>,
              flags : Array<Int>)
    {
        val intent = Intent(context, activity)

        for (flag in flags)
        {
            intent.addFlags(flag)
        }

        for (key in extraKey)
        {
            intent.putExtra(key, extraValue[extraKey.indexOf(key)])
        }

        context.startActivity(intent)
    }

    fun start(activity : Class<*>,
              extraKey : Array<String>,
              extraValue : Array<String>,
              flags : Array<Int>)
    {
        val intent = Intent(context, activity)

        for (flag in flags)
        {
            intent.addFlags(flag)
        }

        for (key in extraKey)
        {
            intent.putExtra('"' + key + '"', extraValue[extraKey.indexOf(key)])
        }

        context.startActivity(intent)
    }

    fun start(activity : Class<*>,
              extraKey : Array<String>,
              extraValue : Array<Parcelable>,
              flags : Array<Int>)
    {
        val intent = Intent(context, activity)

        for (flag in flags)
        {
            intent.addFlags(flag)
        }

        for (key in extraKey)
        {
            intent.putExtra('"' + key + '"', extraValue[extraKey.indexOf(key)])
        }

        context.startActivity(intent)
    }

    fun clearError(vararg editTextList : EditText?)
    {
        for (editText in editTextList)
        {
            editText?.error = null
        }
    }

    fun showProgress(
            show : Boolean,
            container : View?,
            progress : View?,
            goneOrInvisible : Int
                    )
    {

        container?.visibility = if (show) goneOrInvisible else VISIBLE
        container?.animate()
                ?.setDuration(3000)
                ?.alpha((if (show) 0 else 1).toFloat())
                ?.setListener(object : AnimatorListenerAdapter()
                {
                    override fun onAnimationEnd(animation : Animator)
                    {
                        container.visibility = if (show) goneOrInvisible else VISIBLE
                    }
                })

        progress?.visibility = if (show) VISIBLE else goneOrInvisible
        progress?.animate()
                ?.setDuration(3000)
                ?.alpha((if (show) 1 else 0).toFloat())
                ?.setListener(object : AnimatorListenerAdapter()
                {
                    override fun onAnimationEnd(animation : Animator)
                    {
                        progress.visibility = if (show) VISIBLE else goneOrInvisible
                    }
                })

    }

    fun capitalizeFirst(string : String) : String
    {
        val builder = StringBuilder(string.length)
        val words = string.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (index in words.indices)
        {
            if (index > 0)
            {
                builder.append(" ")
            }
            builder.append(Character.toUpperCase(words[index][0]))
            builder.append(words[index].substring(1))
        }
        return builder.toString()
    }

    fun installPlayServices()
    {
        try
        {
            start(Intent(Intent.ACTION_VIEW,
                    Uri.parse
                    ("market://details?id=com.google.android.gms")))
        }
        catch (anfe : ActivityNotFoundException)
        {
            start(Intent(Intent.ACTION_VIEW,
                    Uri.parse
                    ("https://play.google.com/store/apps/details?id=com.google.android.gms")))
        }
    }

    fun drawerIsClosed(drawer : DrawerLayout) : Boolean
    {
        if (!drawer.isDrawerOpen(GravityCompat.START))
        {
            return true
        }
        drawer.closeDrawer(GravityCompat.START)
        return false
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentTime() : String
    {
        val dateFormat = SimpleDateFormat("dd//MM/yyyy HH:mm:ss")
        val calendar = Calendar.getInstance()

        return dateFormat.format(calendar.time)
    }

    @SuppressLint("CommitTransaction")
    fun fragReplace(containerViewID : Int, fragment : Fragment)
    {
        val fragmentName = fragment.javaClass.name
        val fragmentManager = context.supportFragmentManager

        if (isFragmentInBackstack(fragmentManager, fragmentName))
        {
            fragmentManager.popBackStackImmediate(fragmentName, 0)
        }
        else
        {
            fragmentManager
                    .beginTransaction()
                    .replace(containerViewID, fragment)
                    .addToBackStack(fragmentName)
                    .commit()
        }
    }

    fun isFragmentInBackstack(fragmentManager : FragmentManager, fragmentTagName : String) : Boolean
    {
        for (entry in 0 until fragmentManager.backStackEntryCount)
        {
            if (fragmentTagName == fragmentManager.getBackStackEntryAt(entry).name)
            {
                return true
            }
        }
        return false
    }

    fun hideKeyboard()
    {
        try
        {
            val view = context.currentFocus
            if (view != null)
            {
                val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
        catch (e : Exception)
        {
            e.printStackTrace()
        }

    }
}

