package com.example.cpu10225.kotlinonandroid.ui.base

import com.example.cpu10225.kotlinonandroid.data.DataManager
import javax.inject.Inject

/**
 * Created by cpu10225 on 05/12/2017.
 */

open class BasePresenter<V : BaseMvpView> @Inject constructor(private val mDataManager : DataManager) : BaseMvpPresenter<V> {
    lateinit var mView: V

    fun getDataManager(): DataManager = mDataManager

    fun getMvpView(): V = mView

    override fun onAttach(mvpView: V) {
        mView = mvpView
    }
}