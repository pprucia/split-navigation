package pl.prucia.test.splitnavigation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
}