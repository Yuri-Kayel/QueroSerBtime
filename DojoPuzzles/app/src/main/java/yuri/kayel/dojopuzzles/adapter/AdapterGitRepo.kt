package yuri.kayel.bookofeulogies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import yuri.kayel.dojopuzzles.R
import yuri.kayel.dojopuzzles.activity.ActHome
import kotlinx.android.synthetic.main.recycler_hero_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

import yuri.kayel.bookofeulogies.http.GitHubRepo
import yuri.kayel.bookofeulogies.util.Pop.successSnack
import yuri.kayel.bookofeulogies.util.Pop.toast
import yuri.kayel.bookofeulogies.util.Util.context
import yuri.kayel.bookofeulogies.util.Util.start

/**
 * Created by kayel on 2017-09-25.
 */

class AdapterGitRepo(private val gitrepoList: MutableList<GitHubRepo>) : RecyclerView.Adapter<AdapterGitRepo.Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
    {
        return Holder(LayoutInflater.from(context).inflate(R.layout.recycler_gitrepo_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int)
    {
        try
        {
            val gitrepo = gitrepoList.get(position)
            holder.gitrepo_name.text = gitrepo.name
//            holder.gitrepo_thumb.imageResource = gitrepo.thumb
            holder.gitrepo_container.tag = gitrepo
            holder.gitrepo_container.onClick { start(ActHome::class.java) }
            successSnack(gitrepo.name)
        }
        catch (x: Exception)
        {
            toast(x.message)
        }
    }

    override fun getItemCount(): Int
    {
        return gitrepoList.size
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view)
    {
        var gitrepo_container: LinearLayout = view.hero_container
        var gitrepo_name: TextView = view.hero_name
        var gitrepo_thumb: ImageView = view.hero_thumb
    }
}
