package pl.prucia.test.splitnavigation.blue

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_blue.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class BlueFragment : BaseFragment() {

    private lateinit var viewModel: BlueViewModel

    override fun provideLayout() = R.layout.fragment_blue

    override fun setupLayout() {
        mixBlueRed.setOnClickListener(View.OnClickListener(this::mixWithRed))
        mixBlueGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
    }

    override fun provideAppBarConfig() = AppBarConfig.Builder()
        .initWithActivity(activity as BaseActivity)
        .setActivityAppBarVisibility(View.GONE)
        .build()

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(BlueViewModel::class.java)
    }

    private fun mixWithRed(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_blue_to_magentaFragment)
    }

    private fun mixWithGreen(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_blue_to_cyanFragment)
    }

    companion object {
        fun newInstance() = BlueFragment()
    }
}
