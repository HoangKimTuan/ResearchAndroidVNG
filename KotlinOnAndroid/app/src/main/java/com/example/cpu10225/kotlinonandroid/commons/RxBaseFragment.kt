package com.example.cpu10225.kotlinonandroid.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by cpu10225 on 04/12/2017.
 */

open class RxBaseFragment() : Fragment() {
    protected var subcriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subcriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subcriptions.isUnsubscribed) {
            subcriptions.unsubscribe()
        }
        subcriptions.clear()
    }
}