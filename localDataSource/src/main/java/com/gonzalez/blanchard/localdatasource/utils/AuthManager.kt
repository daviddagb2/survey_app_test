package com.gonzalez.blanchard.localdatasource.utils // ktlint-disable filename

import com.gonzalez.blanchard.localdatasource.datasources.AuthLocalDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor(
    authLocalDataSource: AuthLocalDataSource,
) {

    private var _accessToken: String = ""
    val accessToken get() = _accessToken

    private var disposable: Disposable

    init {
        val userFlowable = authLocalDataSource
            .getAuthTokenFlowable()
        disposable = userFlowable
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _accessToken = it?.accessToken ?: ""
            }, {
                // Do nothing
            })
    }
}
