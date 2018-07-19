package pl.prucia.test.splitnavigation.red

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_red.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class RedFragment : BaseFragment() {

    private lateinit var viewModel: RedViewModel

    override fun provideLayout() = R.layout.fragment_red

    override fun setupLayout() {
        mixRedGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
        mixRedBlue.setOnClickListener(View.OnClickListener(this::mixWithBlue))
    }

    override fun provideAppBarConfig() = AppBarConfig((activity as BaseActivity).provideAppBarConfig())

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(RedViewModel::class.java)
    }

    private fun mixWithGreen(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_red_to_yellowFragment)
    }

    private fun mixWithBlue(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_red_to_magentaFragment)
    }

    companion object {
        fun newInstance() = RedFragment()
    }
}
