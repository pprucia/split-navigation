package pl.prucia.test.splitnavigation.ui.layout

import android.support.annotation.LayoutRes

interface UIProvider {

    @LayoutRes
    fun provideLayout(): Int

    fun setupLayout() = Unit
}