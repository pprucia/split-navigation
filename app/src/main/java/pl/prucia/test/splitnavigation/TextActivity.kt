package pl.prucia.test.splitnavigation

import android.view.View
import kotlinx.android.synthetic.main.layout_default_appbar.*
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class TextActivity : BaseActivity() {

    override fun provideLayout() = R.layout.activity_text

    override fun provideAppBarConfig() = AppBarConfig(
            activityAppBar = appbar_default,
            activityAppBarVisibility = View.GONE,
            activityToolbar = toolbar_default
    )

    override fun setupLayout() {
        super.setupLayout()
        supportActionBar?.setTitle(R.string.text_title)
    }
}