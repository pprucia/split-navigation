package pl.prucia.test.splitnavigation

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.layout_default_appbar.*
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class TextActivity : BaseActivity() {

    override fun provideLayout() = R.layout.activity_text

    override fun navControllerId() = -1

    override fun provideUIConfig() = UIConfig(
            activityAppBar = appbar_default,
            activityAppBarVisibility = View.GONE,
            activityToolbar = toolbar_default
    )

    override fun setupLayout(savedInstanceState: Bundle?) {
        supportActionBar?.setTitle(R.string.text_title)
    }
}