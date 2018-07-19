package pl.prucia.test.splitnavigation.green

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_green.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig

class GreenFragment : BaseFragment() {

    private lateinit var viewModel: GreenViewModel

    override fun provideLayout() = R.layout.fragment_green

    override fun setupLayout() {
        mixGreenRed.setOnClickListener(View.OnClickListener(this::mixWithRed))
        mixGreenBlue.setOnClickListener(View.OnClickListener(this::mixWithBlue))
    }

    override fun provideAppBarConfig() = AppBarConfig.Builder()
            .initWithActivity(activity as BaseActivity)
            .build()

    override fun initDataProviders() {
        viewModel = ViewModelProviders.of(this).get(GreenViewModel::class.java)
    }


    private fun mixWithRed(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_green_to_yellowFragment)
    }

    private fun mixWithBlue(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_green_to_cyanFragment)
    }

    companion object {
        fun newInstance() = GreenFragment()
    }
}
