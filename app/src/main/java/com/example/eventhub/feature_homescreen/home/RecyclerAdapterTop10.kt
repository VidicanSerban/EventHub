package com.example.eventhub.feature_homescreen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventhub.R

class RecyclerAdapterTop10(): RecyclerView.Adapter<RecyclerAdapterTop10.ViewHolder>() {

    private var title = arrayOf("Vincent Van Gogh: \n" +
            "O experiență imersivă", "Trivia Quiz Urban Place", "N O S T A L G I A Imaginarium", "Concurs costume - tema Merry Xmas")

    private var eventdate = arrayOf("15 DEC", "16 DEC", "17 DEC", "18 DEC")

    private var eventtime = arrayOf("18:00", "23:00", "09:00", "19:00")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterTop10.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list_event_top10, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterTop10.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDate.text = eventdate[position]
        holder.itemTime.text = eventtime[position]
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDate: TextView
        var itemTime: TextView

        init {
            itemTitle = itemView.findViewById(R.id.tvCardTop10)
            itemDate = itemView.findViewById(R.id.tvDateTop10)
            itemTime = itemView.findViewById(R.id.tvTimeTop10)
        }
    }
}