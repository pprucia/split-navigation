package pl.prucia.test.splitnavigation.magenta

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.prucia.test.splitnavigation.R

class MagentaFragment : Fragment() {

    companion object {
        fun newInstance() = MagentaFragment()
    }

    private lateinit var viewModel: MagentaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_magenta, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MagentaViewModel::class.java)
    }

}
