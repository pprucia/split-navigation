package pl.prucia.test.splitnavigation.cyan

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class CyanFragment : BaseFragment() {

    private lateinit var viewModel: CyanViewModel

    override fun provideLayout() = R.layout.fragment_cyan

    override fun provideUIConfig() = UIConfig((activity as BaseActivity).provideUIConfig())

    override fun initDataProviders(arguments: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(CyanViewModel::class.java)
    }

    companion object {
        fun newInstance() = CyanFragment()
    }
}
