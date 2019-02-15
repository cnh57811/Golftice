package com.cgavlabs.golftice.challenges

import android.os.Bundle
import com.cgavlabs.golftice.BaseActivity
import com.cgavlabs.golftice.R
import com.cgavlabs.golftice.common.instanceOf


class ChallengeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.content_container, instanceOf<ChallengeSelectorFragment>())
            .commit()
    }

    override fun selectedBottomNavId(): Int {
        return R.id.navigation_challenges
    }
}