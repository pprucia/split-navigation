package pl.prucia.test.splitnavigation

import android.view.View
import kotlinx.android.synthetic.main.layout_default_appbar.*
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class TextActivity : BaseActivity() {

    override fun provideLayout() = R.layout.activity_text

    override fun provideAppBarConfig() = AppBarConfig.Builder()
        .setActivityAppBar(appbar_default, View.GONE)
        .setActivityToolbar(toolbar_default)
        .build()

    override fun setupLayout() {
        super.setupLayout()
        supportActionBar?.setTitle(R.string.text_title)
    }
}