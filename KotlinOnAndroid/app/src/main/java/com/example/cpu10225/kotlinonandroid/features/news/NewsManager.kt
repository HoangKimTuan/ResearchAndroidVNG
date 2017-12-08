package com.example.cpu10225.kotlinonandroid.features.news

import com.example.cpu10225.kotlinonandroid.api.NewsAPI
import com.example.cpu10225.kotlinonandroid.api.RedditNewsResponse
import com.example.cpu10225.kotlinonandroid.commons.RedditNews
import com.example.cpu10225.kotlinonandroid.commons.RedditNewsItem
import com.example.cpu10225.kotlinonandroid.data.DataManager
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cpu10225 on 04/12/2017.
 */

@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    suspend fun getNews(after: String, limit: String = "10"): RedditNews {
        val result = api.getNews(after, limit).awaitResult()
        return when (result) {
            is Result.Ok -> process(result.value)
            is Result.Error -> throw Throwable("HTTP error: ${result.response.message()}")
            is Result.Exception -> throw result.exception
            else -> {
                throw Throwable("Something went wrong, please try again later.")
            }
        }
    }

    private fun process(response: RedditNewsResponse): RedditNews {
        val dataResponse = response.data
        val news = dataResponse.children.map {
            val item = it.data
            RedditNewsItem(item.author, item.title, item.num_comments,
                    item.created, item.thumbnail, item.url)
        }
        return RedditNews(
                dataResponse.after.orEmpty(),
                dataResponse.before.orEmpty(),
                news)
    }
}