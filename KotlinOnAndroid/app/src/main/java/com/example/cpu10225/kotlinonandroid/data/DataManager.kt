package com.example.cpu10225.kotlinonandroid.data

import com.example.cpu10225.kotlinonandroid.data.db.DbHelper
import com.example.cpu10225.kotlinonandroid.data.network.ApiHelper
import com.example.cpu10225.kotlinonandroid.data.prefs.PreferencesHelper

/**
 * Created by cpu10225 on 05/12/2017.
 */

interface DataManager : ApiHelper, DbHelper, PreferencesHelper {

}