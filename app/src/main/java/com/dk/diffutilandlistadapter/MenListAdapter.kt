package com.dk.diffutilandlistadapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MenListAdapter : ListAdapter<MenDataModel, MenListAdapter.MenViewHolder>(DiffCallback) {


    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<MenDataModel>(){
            // 고유값을 비교한다.
            override fun areItemsTheSame(oldItem: MenDataModel, newItem: MenDataModel): Boolean {
               return oldItem.menId == newItem.menId
            }

            // 내용 비교
            override fun areContentsTheSame(oldItem: MenDataModel, newItem: MenDataModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MenViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val menId = view.findViewById<TextView>(R.id.menId)
        val menAge = view.findViewById<TextView>(R.id.menAge)
        val menName = view.findViewById<TextView>(R.id.menName)

        fun bind(item : MenDataModel){
            menId.text = item.menId.toString()
            menAge.text = item.menAge.toString()
            menName.text = item.menName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.men_item, parent, false)
        return MenViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}