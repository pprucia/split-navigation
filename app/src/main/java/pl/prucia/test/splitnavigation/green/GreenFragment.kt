package pl.prucia.test.splitnavigation.green

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_green.*
import pl.prucia.test.splitnavigation.R

class GreenFragment : Fragment() {

    companion object {
        fun newInstance() = GreenFragment()
    }

    private lateinit var viewModel: GreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_green, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mixGreenRed.setOnClickListener(View.OnClickListener(this::mixWithRed))
        mixGreenBlue.setOnClickListener(View.OnClickListener(this::mixWithBlue))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GreenViewModel::class.java)
    }

    private fun mixWithRed(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_green_to_yellowFragment)
    }

    private fun mixWithBlue(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_green_to_cyanFragment)
    }

}
