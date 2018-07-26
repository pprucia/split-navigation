package pl.prucia.test.splitnavigation.ui.layout

import android.annotation.SuppressLint
import android.support.annotation.ColorRes
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.view.View
import pl.prucia.test.splitnavigation.R

class UIConfig(
    var activityAppBar: AppBarLayout? = null,
    var activityToolbar: Toolbar? = null,
    var activityAppBarVisibility: Int = View.VISIBLE,

    var fragmentAppBar: AppBarLayout? = null,
    var fragmentToolbar: Toolbar? = null,
    var fragmentAppBarVisibility: Int = View.GONE,

    var isBackActionVisible: Boolean? = null,
    var appBarTitle: String? = null,
    var systemBarsStyle: Style = Style.COLORED
) {

    constructor(activityConfig: UIConfig) : this(
        activityAppBar = activityConfig.activityAppBar,
        activityToolbar = activityConfig.activityToolbar,
        activityAppBarVisibility = activityConfig.activityAppBarVisibility
    )

    constructor(
        activityConfig: UIConfig,
        fragmentAppBar: AppBarLayout? = null,
        fragmentToolbar: Toolbar? = null
    ) : this(
        activityAppBar = activityConfig.activityAppBar,
        activityToolbar = activityConfig.activityToolbar,
        activityAppBarVisibility = activityConfig.activityAppBarVisibility,
        fragmentAppBar = fragmentAppBar,
        fragmentToolbar = fragmentToolbar
    )

    fun modifyAppBarVisibility(activityAppBarVisibility: Int?, fragmentAppBarVisibility: Int?): UIConfig {
        activityAppBarVisibility?.let { this.activityAppBarVisibility = it }
        fragmentAppBarVisibility?.let { this.fragmentAppBarVisibility = it }
        return this
    }

    fun setBackActionVisibility(isBackActionVisible: Boolean?): UIConfig {
        isBackActionVisible?.let { this.isBackActionVisible = isBackActionVisible }
        return this
    }

    fun setAppBarTitle(title: String?): UIConfig {
        appBarTitle = title
        return this
    }

    fun setSystemBarsStyle(style: Style): UIConfig {
        systemBarsStyle = style
        return this
    }

    fun hasActivityAppBarConfig() = activityAppBar != null

    fun hasFragmentAppBarConfig() = fragmentAppBar != null

    interface Provider {
        fun provideUIConfig() = UIConfig()
    }

    enum class Style {
        COLORED, TRANSPARENT_NO_LIMITS, TRANSPARENT_STATUS;

        @ColorRes
        var statusBarBackground: Int = R.color.statusBarDefault
        @ColorRes
        var navigationBarBackground: Int = R.color.navigationBarDefault
        var systemStatusBarMode: Int = 0
        var systemNavigationBarMode: Int = 0

        /**
         * @param statusBarMode Used to set status bar icons color mode.\n
         *                      Can be ether 0 or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
         *
         * @param navigationBarMode Used to set navigation bar icons color mode.
         *                          Can be ether 0 or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
         */
        fun withSystemBarsMode(statusBarMode: Int = 0, navigationBarMode: Int = 0): Style {
            systemStatusBarMode = statusBarMode
            systemNavigationBarMode = navigationBarMode
            return this
        }

        /**
         * @param statusBar Used to set background color for status bar.
         *                   Can be 0 or an id of a color resource.
         *
         * @param navigationBar Used to set background color for navigation bar.
         *                   Can be 0 or an id of a color resource.
         */
        fun withSystemBarsColor(@ColorRes statusBar: Int, @ColorRes navigationBar: Int): Style {
            statusBarBackground = statusBar
            navigationBarBackground = navigationBar
            return this
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        val DEFAULTS = UIConfig()
    }
}