package com.cgavlabs.golftice.challenges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cgavlabs.golftice.BaseActivity
import com.cgavlabs.golftice.R
import com.cgavlabs.golftice.challenges.models.Challenge
import com.cgavlabs.golftice.challenges.models.ChallengeType
import kotlinx.android.synthetic.main.fragment_challenge_selector.*

class ChallengeSelectorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_challenge_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = ChallengeSelectorAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        setChallenges(buildTestChallenges())
    }

    override fun onStart() {
        super.onStart()
        (activity as BaseActivity).setToolbarTitle("Challenge Selector")
    }

    private fun buildTestChallenges(): List<Challenge> {
        val challenges: MutableList<Challenge> = mutableListOf()
        for (i in 1..35) {
            when {
                i <= 5 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.PUTTING)
                    challenges.add(challenge)
                }
                i <= 10 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.CHIPPING)
                    challenges.add(challenge)
                }
                i <= 15 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.PITCHING)
                    challenges.add(challenge)
                }
                i <= 20 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.BUNKERS)
                    challenges.add(challenge)
                }
                i <= 25 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.IRONS)
                    challenges.add(challenge)
                }
                i <= 30 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.DRIVER)
                    challenges.add(challenge)
                }
                i <= 35 -> {
                    val challenge = Challenge("Challenge Name #$i", ChallengeType.GAME)
                    challenges.add(challenge)
                }
            }
        }
        return challenges
    }

    private fun setChallenges(challenges: List<Challenge>) {
        (recyclerView.adapter as ChallengeSelectorAdapter).setChallenges(challenges)
    }
}
