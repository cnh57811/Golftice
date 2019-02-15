package com.cgavlabs.golftice

import android.os.Bundle
import android.transition.Fade
import android.view.Window
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.cgavlabs.golftice.challenges.ChallengeActivity
import com.cgavlabs.golftice.common.launch
import com.cgavlabs.golftice.more.MoreActivity
import com.cgavlabs.golftice.routines.RoutinesActivity
import com.cgavlabs.golftice.trends.TrendsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    private val fadeTransition = buildFadeTransition()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_challenges -> launch<ChallengeActivity>()
            R.id.navigation_routines -> launch<RoutinesActivity>()
            R.id.navigation_trends -> launch<TrendsActivity>()
            R.id.navigation_more -> launch<MoreActivity>()
        }
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            window.allowEnterTransitionOverlap
            enterTransition = fadeTransition
            exitTransition = fadeTransition
        }
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        navigation.selectedItemId = selectedBottomNavId()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        setToolbarTitle(this::class.java.simpleName)
    }

    @IdRes
    abstract fun selectedBottomNavId(): Int

    override fun onBackPressed() {
        if (this !is ChallengeActivity) {
            launch<ChallengeActivity>()
        } else {
            super.onBackPressed()
        }
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun buildFadeTransition(): Fade {
        val fadeTransition = Fade()
        fadeTransition.excludeTarget(R.id.navigation, true)
        fadeTransition.excludeTarget(R.id.toolbar_container, true)
        fadeTransition.excludeTarget(android.R.id.statusBarBackground, true)
        fadeTransition.excludeTarget(android.R.id.navigationBarBackground, true)
        return fadeTransition
    }

}
