package pl.prucia.test.splitnavigation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.prucia.test.splitnavigation.ui.layout.AppBarConfig
import pl.prucia.test.splitnavigation.ui.layout.UIProvider

abstract class BaseFragment : Fragment(), UIProvider, AppBarConfig.Provider {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAppBar(provideAppBarConfig())
        initDataProviders()
    }

    private fun setupAppBar(config: AppBarConfig) {
        config.activityAppBar?.apply {
            visibility = config.activityAppBarVisibility
        }
        config.fragmentAppBar?.apply {
            visibility = config.activityAppBarVisibility
        }
    }

    protected open fun initDataProviders() {}
}