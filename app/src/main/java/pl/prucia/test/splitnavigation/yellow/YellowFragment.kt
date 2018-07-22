package pl.prucia.test.splitnavigation.yellow

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class YellowFragment : BaseFragment() {

    private lateinit var viewModel: YellowViewModel

    override fun provideLayout() = R.layout.fragment_yellow

    override fun provideUIConfig() = UIConfig((activity as BaseActivity).provideUIConfig())

    override fun initDataProviders(arguments: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(YellowViewModel::class.java)
    }

    companion object {
        fun newInstance() = YellowFragment()
    }
}
