package pl.prucia.test.splitnavigation.magenta

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class MagentaFragment : BaseFragment() {

    private lateinit var viewModel: MagentaViewModel

    override fun provideLayout() = R.layout.fragment_magenta

    override fun provideAppBarConfig() = AppBarConfig((activity as BaseActivity).provideAppBarConfig())
            .modifyAppBarVisibility(View.GONE, null)

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(MagentaViewModel::class.java)
    }

    companion object {
        fun newInstance() = MagentaFragment()
    }
}
