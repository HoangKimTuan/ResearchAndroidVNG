package com.example.cpu10225.kotlinonandroid.ui.base

import com.example.cpu10225.kotlinonandroid.data.DataManager
import javax.inject.Inject

/**
 * Created by cpu10225 on 08/12/2017.
 */

open class BasePresenter<V : BaseMvpView> @Inject constructor(private val mDataManager: DataManager) : BaseMvpPresenter<V> {
    private var mView: V? = null

    override fun onAttach(mvpView: V) {
        mView = mvpView
    }

    fun getMvpView() = mView

    fun getDataManager() = mDataManager
}