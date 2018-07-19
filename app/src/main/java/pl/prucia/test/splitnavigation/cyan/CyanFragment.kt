package pl.prucia.test.splitnavigation.cyan

import android.arch.lifecycle.ViewModelProviders
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class CyanFragment : BaseFragment() {

    private lateinit var viewModel: CyanViewModel

    override fun provideLayout() = R.layout.fragment_cyan

    override fun provideAppBarConfig() = AppBarConfig.Builder()
            .initWithActivity(activity as BaseActivity)
            .build()

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(CyanViewModel::class.java)
    }

    companion object {
        fun newInstance() = CyanFragment()
    }
}
