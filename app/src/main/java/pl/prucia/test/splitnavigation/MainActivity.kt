package pl.prucia.test.splitnavigation

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_default_appbar.*
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun provideLayout() = R.layout.activity_main

    override fun provideAppBarConfig() = AppBarConfig.Builder()
        .setActivityAppBar(appbar_default, View.VISIBLE)
        .setActivityToolbar(toolbar_default)
        .build()

    override fun setupLayout() {
        navController = findNavController(R.id.navHost)
        setupActionBarWithNavController(navController)

        bottomNavigation.setupWithNavController(navController)
        bottomNavigation.isItemHorizontalTranslationEnabled = false
    }
}
