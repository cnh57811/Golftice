package com.cgavlabs.golftice.challenges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cgavlabs.golftice.R
import com.cgavlabs.golftice.challenges.models.Challenge

class ChallengeSelectorItemAdapter(private val challenges: List<Challenge>) :
    RecyclerView.Adapter<ChallengeSelectorItemAdapter.ChallengeSelectorItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeSelectorItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_challenge, parent, false)
        return ChallengeSelectorItemAdapter.ChallengeSelectorItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return challenges.size
    }

    override fun onBindViewHolder(holder: ChallengeSelectorItemViewHolder, position: Int) {
        holder.text.text = challenges[position].name
    }

    class ChallengeSelectorItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.challengeName)
    }

}
