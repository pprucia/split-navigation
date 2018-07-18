package pl.prucia.test.splitnavigation.yellow

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.prucia.test.splitnavigation.R

class YellowFragment : Fragment() {

    companion object {
        fun newInstance() = YellowFragment()
    }

    private lateinit var viewModel: YellowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_yellow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YellowViewModel::class.java)
    }
}
