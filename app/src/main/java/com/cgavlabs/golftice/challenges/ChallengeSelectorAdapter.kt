package com.cgavlabs.golftice.challenges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cgavlabs.golftice.R
import com.cgavlabs.golftice.challenges.models.Challenge
import com.cgavlabs.golftice.challenges.models.ChallengeType

internal class ChallengeSelectorAdapter : RecyclerView.Adapter<ChallengeSelectorAdapter.ChallengeSelectorViewHolder>() {

    private lateinit var challenges: List<Challenge>
    private lateinit var distinctChallengeTypes: List<ChallengeType>

    fun setChallenges(challenges: List<Challenge>) {
        this.challenges = challenges
        getDistinctChallengeTypes()
        notifyDataSetChanged()
    }

    private fun getDistinctChallengeTypes() {
        val distinctChallengeTypes = mutableListOf<ChallengeType>()
        for (challenge in challenges) {
            if (challenge.type !in distinctChallengeTypes) {
                distinctChallengeTypes.add(challenge.type)
            }
        }
        this.distinctChallengeTypes = distinctChallengeTypes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeSelectorViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_challenge_selector_type_group, parent, false)
        return ChallengeSelectorViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return distinctChallengeTypes.size
    }

    override fun onBindViewHolder(holder: ChallengeSelectorViewHolder, position: Int) {
        holder.title.text = distinctChallengeTypes[position].name
//        holder.recyclerView.ada
    }

    internal class ChallengeSelectorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.challengeTypeTitle)
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)
    }

}
