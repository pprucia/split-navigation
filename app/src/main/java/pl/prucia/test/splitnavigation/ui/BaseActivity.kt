package pl.prucia.test.splitnavigation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig
import pl.prucia.test.splitnavigation.ui.layout.UIProvider

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), UIProvider, AppBarConfig.Provider {

    private lateinit var appBarConfig: AppBarConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())

        appBarConfig = provideAppBarConfig()
        setupAppBar(appBarConfig)
        setupLayout()
    }

    private fun setupAppBar(config: AppBarConfig) {
        config.activityAppBar?.apply {
            visibility = config.activityAppBarVisibility
        }
        config.activityToolbar?.apply {
            setSupportActionBar(this)
        }
    }
}