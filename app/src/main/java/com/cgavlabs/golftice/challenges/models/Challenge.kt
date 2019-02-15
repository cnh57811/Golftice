package com.cgavlabs.golftice.challenges.models


data class Challenge(var name: String,
                     val type: ChallengeType)

enum class ChallengeType {
    PUTTING, CHIPPING, PITCHING, BUNKERS, IRONS, DRIVER, GAME
}
