package pl.prucia.test.splitnavigation.yellow

import android.arch.lifecycle.ViewModelProviders
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class YellowFragment : BaseFragment() {

    private lateinit var viewModel: YellowViewModel

    override fun provideLayout() = R.layout.fragment_yellow

    override fun provideAppBarConfig() = AppBarConfig((activity as BaseActivity).provideAppBarConfig())

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(YellowViewModel::class.java)
    }

    companion object {
        fun newInstance() = YellowFragment()
    }
}
