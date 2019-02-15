package com.cgavlabs.golftice.common

import android.app.Activity
import android.content.Intent
import android.transition.Fade
import androidx.core.app.ActivityOptionsCompat
import com.cgavlabs.golftice.R

inline fun <reified A : Activity> Activity.launch() {
    val intent = Intent(this, A::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

    var fadeTransition = Fade()
    fadeTransition.excludeTarget(R.id.navigation, true)
    fadeTransition.excludeTarget(R.id.toolbar_container, true)
    fadeTransition.excludeTarget(android.R.id.statusBarBackground, true)
    fadeTransition.excludeTarget(android.R.id.navigationBarBackground, true)
    window.enterTransition = fadeTransition
    window.exitTransition = fadeTransition

    val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
    startActivity(intent, bundle)
}
