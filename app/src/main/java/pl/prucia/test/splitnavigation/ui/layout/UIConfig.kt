package pl.prucia.test.splitnavigation.ui.layout

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.view.View

class UIConfig(
    var activityAppBar: AppBarLayout? = null,
    var activityToolbar: Toolbar? = null,
    var activityAppBarVisibility: Int = View.VISIBLE,

    var fragmentAppBar: AppBarLayout? = null,
    var fragmentToolbar: Toolbar? = null,
    var fragmentAppBarVisibility: Int = View.GONE
) {

    constructor(activityConfig: UIConfig) : this(
        activityAppBar = activityConfig.activityAppBar,
        activityToolbar = activityConfig.activityToolbar,
        activityAppBarVisibility = activityConfig.activityAppBarVisibility
    )

    fun modifyAppBarVisibility(activityAppBarVisibility: Int?, fragmentAppBarVisibility: Int?): UIConfig {
        activityAppBarVisibility?.let { this.activityAppBarVisibility = it }
        fragmentAppBarVisibility?.let { this.fragmentAppBarVisibility = it }
        return this
    }

    fun hasActivityAppBarConfig() = activityAppBar != null

    fun hasFragmentAppBarConfig() = fragmentAppBar != null

    interface Provider {
        fun provideUIConfig() = UIConfig()
        fun uiConfig() = Unit
    }
}