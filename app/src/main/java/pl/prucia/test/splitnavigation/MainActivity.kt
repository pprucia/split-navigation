package pl.prucia.test.splitnavigation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_default_appbar.*
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun provideLayout() = R.layout.activity_main

    override fun provideUIConfig() = UIConfig(
            activityAppBar = appbar_default,
            activityAppBarVisibility = View.VISIBLE,
            activityToolbar = toolbar_default
    )

    override fun setupLayout(savedInstanceState: Bundle?) {
        navController = findNavController(R.id.navHost)
        setupActionBarWithNavController(navController)

        bottomNavigation.setupWithNavController(navController)
        bottomNavigation.isItemHorizontalTranslationEnabled = false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_text -> {
                startActivity(Intent(this, TextActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}