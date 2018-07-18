package pl.prucia.test.splitnavigation.blue

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_blue.*
import pl.prucia.test.splitnavigation.R

class BlueFragment : Fragment() {

    companion object {
        fun newInstance() = BlueFragment()
    }

    private lateinit var viewModel: BlueViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mixBlueRed.setOnClickListener(View.OnClickListener(this::mixWithRed))
        mixBlueGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlueViewModel::class.java)
    }

    private fun mixWithRed(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_blue_to_magentaFragment)
    }

    private fun mixWithGreen(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_blue_to_cyanFragment)
    }
}
