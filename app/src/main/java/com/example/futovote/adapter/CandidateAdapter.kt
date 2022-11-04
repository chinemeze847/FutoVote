package com.example.futovote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.futovote.model.Candidate

class CandidateAdapter( private val candidates : List<Candidate>? )
    : RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>()
{
    class CandidateViewHolder(private val view : View) : RecyclerView.ViewHolder(view)
    {

        fun bind(student: Candidate)
        {
            val textView : TextView = view.findViewById(R.id.candidate_title)
            textView.text = student.firstname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_candidate, parent, false)
        return CandidateViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int)
    {
        val student = candidates?.get(position)
        if (student != null) {
            holder.bind(student)
        }
    }

    override fun getItemCount(): Int {
        if (candidates != null) {
            return candidates.size
        }
        return 0;
    }
}