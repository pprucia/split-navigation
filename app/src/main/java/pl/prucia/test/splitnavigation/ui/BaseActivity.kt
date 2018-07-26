package pl.prucia.test.splitnavigation.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.prucia.test.splitnavigation.ui.layout.UIConfig
import pl.prucia.test.splitnavigation.ui.layout.UIProvider

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), UIProvider, UIConfig.Provider {

    private lateinit var uiConfig: UIConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())

        uiConfig = provideUIConfig()
        setupUI(uiConfig)
        setupLayout(savedInstanceState)
    }

    private fun setupUI(config: UIConfig) {
        config.activityAppBar?.apply { visibility = config.activityAppBarVisibility }
        config.activityToolbar?.apply { setSupportActionBar(this) }

        config.isBackActionVisible?.let { supportActionBar?.setDisplayHomeAsUpEnabled(it) }
        config.appBarTitle?.let { title = it }
    }

    fun modifyUI(config: UIConfig) {
        navBarBackgroundView.layoutParams.height = findNavigationBarHeight()
        navBarBackgroundView.requestLayout()
        navBarBackgroundView.background = getDrawable(config.systemBarsStyle.navigationBarBackground)
    }

    fun resetUI(config: UIConfig) {
        navBarBackgroundView.layoutParams.height = 0
        navBarBackgroundView.requestLayout()
        navBarBackgroundView.background = getDrawable(UIConfig.DEFAULTS.systemBarsStyle.navigationBarBackground)
    }

    private fun findNavigationBarHeight(): Int {
        val id = resources.getIdentifier(
            if (requestedOrientation == Configuration.ORIENTATION_PORTRAIT)
                "navigation_bar_height"
            else
                "navigation_bar_height_landscape",
            "dimen", "android"
        )
        return if (id > 0) resources.getDimensionPixelSize(id) else 0
    }
}