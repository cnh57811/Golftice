package com.cgavlabs.golftice.common

import android.app.Activity
import android.content.Intent
import com.cgavlabs.golftice.R

inline fun <reified A : Activity> Activity.launch() {
    val intent = Intent(this, A::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    startActivity(intent)
}
