package com.example.cpu10225.kotlinonandroid.data

import com.example.cpu10225.kotlinonandroid.data.db.DbHelper
import com.example.cpu10225.kotlinonandroid.data.network.ApiHelper
import com.example.cpu10225.kotlinonandroid.data.network.News
import com.example.cpu10225.kotlinonandroid.data.prefs.PreferencesHelper
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Singleton
class AppDataManager
@Inject constructor(
        private val mApiHelper: ApiHelper,
        private val mDbHelper: DbHelper,
        private val mPreferencesHelper: PreferencesHelper)
    : DataManager {

    override fun getTop(after: String, limit: String): Observable<News> {
        return mApiHelper.getTop(after, limit)
    }
}