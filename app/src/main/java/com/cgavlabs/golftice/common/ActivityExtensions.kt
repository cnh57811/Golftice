package com.cgavlabs.golftice.common

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent

inline fun <reified A : Activity> Activity.launch() {
    val intent = Intent(this, A::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
    startActivity(intent, bundle)
}
