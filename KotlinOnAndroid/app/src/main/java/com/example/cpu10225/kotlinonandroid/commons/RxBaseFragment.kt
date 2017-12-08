package com.example.cpu10225.kotlinonandroid.commons

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job
import rx.subscriptions.CompositeSubscription

/**
 * Created by cpu10225 on 04/12/2017.
 */

open class RxBaseFragment() : Fragment() {
    protected var job: Job? = null

    override fun onResume() {
        super.onResume()
        job = null
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
        job = null
    }
}