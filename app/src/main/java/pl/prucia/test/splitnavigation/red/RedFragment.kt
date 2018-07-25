package pl.prucia.test.splitnavigation.red

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_red.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class RedFragment : BaseFragment() {

    private lateinit var viewModel: RedViewModel

    override fun provideLayout() = R.layout.fragment_red

    override fun provideUIConfig() = UIConfig((activity as BaseActivity).provideUIConfig())

    override fun setupLayout(savedInstanceState: Bundle?) {
        mixRedGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
        mixRedBlue.setOnClickListener(View.OnClickListener(this::mixWithBlue))
    }

    override fun initDataProviders(arguments: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(RedViewModel::class.java)
    }

    private fun mixWithGreen(view: View) {
        activity?.findNavController(navControllerId())?.navigate(R.id.action_navigation_tab_red_to_yellowFragment)
    }

    private fun mixWithBlue(view: View) {
        activity?.findNavController(navControllerId())?.navigate(R.id.action_navigation_tab_red_to_magentaFragment)
    }

    companion object {
        fun newInstance() = RedFragment()
    }
}
