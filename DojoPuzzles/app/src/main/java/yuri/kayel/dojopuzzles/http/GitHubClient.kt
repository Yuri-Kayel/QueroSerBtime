package yuri.kayel.bookofeulogies.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by yurik on 22/01/2018.
 */

interface GitHubClient
{
    @GET("/users/{user}/repos")
    fun reposForUser(@Path("user") user: String): Call<List<GitHubRepo>>
}
