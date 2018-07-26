package pl.prucia.test.splitnavigation.yellow

import android.animation.ValueAnimator
import android.annotation.TargetApi
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.design.widget.AppBarLayout
import android.view.View
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.fragment_yellow.*
import pl.prucia.test.splitnavigation.R
import pl.prucia.test.splitnavigation.ui.BaseActivity
import pl.prucia.test.splitnavigation.ui.BaseFragment
import pl.prucia.test.splitnavigation.ui.layout.UIConfig

class YellowFragment : BaseFragment(), AppBarLayout.OnOffsetChangedListener {

    private var isAppBarTitleVisible = false
    private var isTitleContainerVisible = true
    private lateinit var viewModel: YellowViewModel

    override fun provideLayout() = R.layout.fragment_yellow

    override fun provideUIConfig() =
        UIConfig((activity as BaseActivity).provideUIConfig(), appbar_fragment, toolbar_fragment)
            .modifyAppBarVisibility(View.GONE, View.VISIBLE)
            .setBackActionVisibility(true)
            .setSystemBarsStyle(
                UIConfig.Style.TRANSPARENT_STATUS
                    .withSystemBarsColor(R.color.red, R.color.orange)
            )

    override fun setupLayout(savedInstanceState: Bundle?) {
        appbar_fragment.addOnOffsetChangedListener(this)
        toolbar_fragment.title = ""
    }

    override fun initDataProviders(arguments: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(YellowViewModel::class.java)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
        val maxScroll = appBarLayout.totalScrollRange
        val percentage = Math.abs(offset).toFloat() / maxScroll.toFloat()

        handleAlphaOnTitle(percentage)
        handleToolbarTitleVisibility(percentage)
    }

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
            if (isAppBarTitleVisible) {
                return
            }
            startAlphaAnimation(toolbar_fragment_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
            startColorAnimation(
                toolbar_fragment,
                ALPHA_ANIMATIONS_DURATION.toLong(),
                android.R.color.transparent,
                R.color.red
            )
            isAppBarTitleVisible = true
        } else {
            if (!isAppBarTitleVisible) {
                return
            }
            startAlphaAnimation(toolbar_fragment_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
            startColorAnimation(
                toolbar_fragment,
                ALPHA_ANIMATIONS_DURATION.toLong(),
                R.color.red,
                android.R.color.transparent
            )
            isAppBarTitleVisible = false
        }
    }

    private fun handleAlphaOnTitle(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (isTitleContainerVisible) {
                startAlphaAnimation(appbar_collapsing_header, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
                isTitleContainerVisible = false
            }
        } else {

            if (!isTitleContainerVisible) {
                startAlphaAnimation(appbar_collapsing_header, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
                isTitleContainerVisible = true
            }
        }
    }

    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val alphaAnimation = if (visibility == View.VISIBLE) AlphaAnimation(0f, 1f) else AlphaAnimation(1f, 0f)
        alphaAnimation.duration = duration
        alphaAnimation.fillAfter = true
        v.startAnimation(alphaAnimation)
    }

    @TargetApi(Build.VERSION_CODES.M)
    private fun startColorAnimation(v: View, duration: Long, @ColorRes fromColor: Int, @ColorRes toColor: Int) {
        val from = resources.getColor(fromColor, activity?.theme)
        val to = resources.getColor(toColor, activity?.theme)
        val anim = ValueAnimator.ofArgb(from, to)
        anim.addUpdateListener { animation -> v.setBackgroundColor(animation.animatedValue as Int) }
        anim.duration = duration
        anim.start()
    }

    companion object {
        private const val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.5f
        private const val PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.8f
        private const val ALPHA_ANIMATIONS_DURATION = 200

        fun newInstance() = YellowFragment()
    }
}
