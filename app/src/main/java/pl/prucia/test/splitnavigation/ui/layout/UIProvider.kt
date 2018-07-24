package pl.prucia.test.splitnavigation.ui.layout

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes

interface UIProvider {

    @LayoutRes
    fun provideLayout(): Int
    @IdRes
    fun navControllerId(): Int
    fun setupLayout(savedInstanceState: Bundle?) = Unit
}