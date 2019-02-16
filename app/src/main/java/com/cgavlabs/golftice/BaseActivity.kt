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
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        navigation.selectedItemId = selectedBottomNavId()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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

}
