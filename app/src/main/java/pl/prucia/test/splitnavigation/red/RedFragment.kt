package pl.prucia.test.splitnavigation.red

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_red.*
import pl.prucia.test.splitnavigation.R

class RedFragment : Fragment() {

    companion object {
        fun newInstance() = RedFragment()
    }

    private lateinit var viewModel: RedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mixRedGreen.setOnClickListener(View.OnClickListener(this::mixWithGreen))
        mixRedBlue.setOnClickListener(View.OnClickListener(this::mixWithBlue))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RedViewModel::class.java)
    }

    private fun mixWithGreen(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_red_to_yellowFragment)
    }

    private fun mixWithBlue(view: View) {
        view.findNavController().navigate(R.id.action_navigation_tab_red_to_magentaFragment)
    }
}
