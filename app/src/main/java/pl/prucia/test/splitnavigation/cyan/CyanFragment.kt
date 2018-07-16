package pl.prucia.test.splitnavigation.cyan

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.prucia.test.splitnavigation.R

class CyanFragment : Fragment() {

    companion object {
        fun newInstance() = CyanFragment()
    }

    private lateinit var viewModel: CyanViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cyan, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CyanViewModel::class.java)
    }

}
