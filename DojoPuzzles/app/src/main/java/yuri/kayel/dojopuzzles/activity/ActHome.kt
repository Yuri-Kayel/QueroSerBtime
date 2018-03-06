package yuri.kayel.dojopuzzles.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import yuri.kayel.dojopuzzles.FragAgileMeth
import yuri.kayel.dojopuzzles.R
import yuri.kayel.dojopuzzles.fragment.*
import kotlinx.android.synthetic.main.act_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import yuri.kayel.bookofeulogies.util.Util.fragReplace

class ActHome : ActBase(), NavigationView.OnNavigationItemSelectedListener,
                DrawerLayout.DrawerListener
{
    private lateinit var selectedNavItem : MenuItem

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        setHomeFragment()

        nav_view.setNavigationItemSelectedListener(this)
        drawer_layout.setDrawerListener(this)
    }

    override fun onBackPressed()
    {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }

    private fun setHomeFragment()
    {
        fragReplace(R.id.act_main_framelayout, FragDiamonds())
    }

    override fun onNavigationItemSelected(item : MenuItem) : Boolean
    {
        selectedNavItem = item
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onDrawerClosed(drawerView : View?)
    {
        handleNavigationItemSelected(selectedNavItem)
    }

    fun handleNavigationItemSelected(item : MenuItem) : Boolean
    {
        val container = R.id.act_main_framelayout

        nav_view.setCheckedItem(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)

        when (item.itemId)
        {
//            ABOUT ME
            R.id.nav_aboutme ->
            {
                setHomeFragment()
            }
            R.id.nav_education ->
            {
                fragReplace(container, FragEducation())
            }
            R.id.nav_experience ->
            {
                fragReplace(container, FragExperience())
            }

//            SKILLS
            R.id.nav_backend_comm ->
            {
                fragReplace(container, FragBackEnd())
            }
            R.id.nav_local_persist ->
            {
                fragReplace(container, FragLocalPersist())
            }
            R.id.nav_architecture_patterns ->
            {
                fragReplace(container, FragArchPatterns())
            }
            R.id.nav_agile_methods ->
            {
                fragReplace(container, FragAgileMeth())
            }

//            CONTACT
            R.id.nav_mail ->
            {

            }

            R.id.nav_phone ->
            {

            }

            R.id.nav_linkedin ->
            {

            }
        }
        return true
    }

    //region USELESS
    override fun onDrawerStateChanged(newState : Int)
    {
    }

    override fun onDrawerSlide(drawerView : View?, slideOffset : Float)
    {
    }

    override fun onDrawerOpened(drawerView : View?)
    {
    }
    //endregion
}
