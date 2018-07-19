package pl.prucia.test.splitnavigation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.prucia.test.splitnavigation.ui.layout.UIConfig
import pl.prucia.test.splitnavigation.ui.layout.UIProvider

abstract class BaseFragment : Fragment(), UIProvider, UIConfig.Provider {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar(provideUIConfig())
        initDataProviders()
    }

    private fun setupAppBar(config: UIConfig) {
        config.activityAppBar?.apply {
            visibility = config.activityAppBarVisibility
        }
        config.fragmentAppBar?.apply {
            visibility = config.activityAppBarVisibility
        }
    }

    protected open fun initDataProviders() {}
}