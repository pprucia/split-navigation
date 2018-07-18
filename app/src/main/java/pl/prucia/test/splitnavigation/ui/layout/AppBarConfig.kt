package pl.prucia.test.splitnavigation.ui.layout

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.view.View
import pl.prucia.test.splitnavigation.ui.BaseActivity

class AppBarConfig private constructor() {

    var activityAppBar: AppBarLayout? = null
        private set
    var activityToolbar: Toolbar? = null
        private set

    var fragmentAppBar: AppBarLayout? = null
        private set
    var fragmentToolbar: Toolbar? = null
        private set

    var activityAppBarVisibility = View.VISIBLE
        private set
    var fragmentAppBarVisibility = View.GONE
        private set

    class Builder {
        private val config = AppBarConfig()

        fun initWithActivity(activity: BaseActivity): Builder {
            val aConfig = activity.provideAppBarConfig()
            setActivityAppBar(aConfig.activityAppBar, aConfig.activityAppBarVisibility)
            setActivityToolbar(aConfig.activityToolbar)
            return this
        }

        fun setActivityAppBar(appBar: AppBarLayout?, visibility: Int): Builder {
            config.activityAppBar = appBar
            config.activityAppBarVisibility = visibility
            return this
        }

        fun setActivityAppBarVisibility(visibility: Int): Builder {
            config.activityAppBarVisibility = visibility
            return this
        }

        fun setActivityToolbar(toolbar: Toolbar?): Builder {
            config.activityToolbar = toolbar
            return this
        }

        fun setFragmentAppBar(appBar: AppBarLayout?, visibility: Int): Builder {
            config.fragmentAppBar = appBar
            config.fragmentAppBarVisibility = visibility
            return this
        }

        fun setFragmentAppBarVisibility(visibility: Int): Builder {
            config.fragmentAppBarVisibility = visibility
            return this
        }

        fun build(): AppBarConfig {
            validate(config)
            return config
        }

        @Throws(IllegalStateException::class)
        private fun validate(config: AppBarConfig) {
            config.apply {
                if (activityAppBarVisibility != View.GONE && activityAppBar == null) {
                    throw IllegalStateException("Activity level appBar needs to be set when it's visibility is other than GONE")
                }
                if (fragmentAppBarVisibility != View.GONE && fragmentAppBar == null) {
                    throw IllegalStateException("Fragment level appBar needs to be set when it's visibility is other than GONE")
                }
            }
        }
    }

    interface Provider {
        fun provideAppBarConfig() = AppBarConfig()
    }
}