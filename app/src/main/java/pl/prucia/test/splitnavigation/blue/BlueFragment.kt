package pl.prucia.test.splitnavigation.blue

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_blue.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class BlueFragment : BaseFragment() {

    private lateinit var viewModel: BlueViewModel

    override fun provideLayout() = R.layout.fragment_blue

    override fun provideUIConfig() = UIConfig((activity as BaseActivity).provideUIConfig())
        .modifyAppBarVisibility(View.GONE, null)

    override fun setupLayout(savedInstanceState: Bundle?) {
        mixBlueRed.setOnClickListener(View.OnClickListener(this::mixWithRed))
        mixBlueGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
    }

    override fun initDataProviders(arguments: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(BlueViewModel::class.java)
    }

    private fun mixWithRed(view: View) {
        activity?.findNavController(navControllerId())?.navigate(R.id.action_navigation_tab_blue_to_magentaFragment)
    }

    private fun mixWithGreen(view: View) {
        activity?.findNavController(navControllerId())?.navigate(R.id.action_navigation_tab_blue_to_cyanFragment)
    }

    companion object {
        fun newInstance() = BlueFragment()
    }
}
