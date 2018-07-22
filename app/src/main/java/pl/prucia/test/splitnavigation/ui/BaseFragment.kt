package pl.prucia.test.splitnavigation.ui

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import pl.prucia.test.splitnavigation.ui.layout.UIConfig
import pl.prucia.test.splitnavigation.ui.layout.UIProvider

abstract class BaseFragment : Fragment(), UIProvider, UIConfig.Provider {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI(provideUIConfig())
        initDataProviders(arguments)
    }

    private fun setupUI(config: UIConfig) {
        config.activityAppBar?.apply { visibility = config.activityAppBarVisibility }
        config.fragmentAppBar?.apply { visibility = config.fragmentAppBarVisibility }
        config.fragmentToolbar?.apply { (activity as BaseActivity).setSupportActionBar(this) }

        config.isBackActionVisible?.let { (activity as BaseActivity).supportActionBar?.setDisplayHomeAsUpEnabled(it) }
        config.appBarTitle?.let { (activity as BaseActivity).supportActionBar?.setTitle(it) }

        when (config.systemBarsStyle) {
            UIConfig.Style.COLORED -> {
                activity?.apply {
                    window?.statusBarColor =
                        ContextCompat.getColor(this, config.systemBarsStyle.statusBarBackground)
                    window?.navigationBarColor =
                        ContextCompat.getColor(this, config.systemBarsStyle.navigationBarBackground)
                }
            }
            UIConfig.Style.TRANSPARENT_NO_LIMITS -> {
                activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
                activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity?.window?.decorView?.systemUiVisibility = config.systemBarsStyle.systemStatusBarMode or
                        config.systemBarsStyle.systemNavigationBarMode
                }
            }
        }
    }

//    private fun resetSystemUIVisibility() {
//        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
//        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            activity?.window?.decorView?.systemUiVisibility = 0
//        }
//    }

    protected open fun initDataProviders(arguments: Bundle?) = Unit
}