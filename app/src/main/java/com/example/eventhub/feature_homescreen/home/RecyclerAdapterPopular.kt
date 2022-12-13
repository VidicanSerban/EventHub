package com.example.eventhub.feature_homescreen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventhub.R

class RecyclerAdapterPopular: RecyclerView.Adapter<RecyclerAdapterPopular.ViewHolder>() {

    private var title = arrayOf("Vincent Van Gogh: \n" +
            "O experiență imersivă", "Petrecere costumată de Halloween", "N O S T A L G I A Imaginarium", "Petrecere de Craciun")

    private var eventdate = arrayOf("27 OCT", "31 OCT", "15 NOI", "25 DEC")

    private var eventtime = arrayOf("17:00", "23:00", "09:00", "19:00")

    private var eventlocation = arrayOf("Oradea, Romania", "Oradea, Romania", "Oradea, Romania", "Oradea, Romania")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterPopular.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list_event_popular, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterPopular.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDate.text = eventdate[position]
        holder.itemTime.text = eventtime[position]
        holder.itemLocation.text = eventlocation[position]
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemDate: TextView
        var itemTime: TextView
        var itemLocation: TextView

        init {
            itemTitle = itemView.findViewById(R.id.tvCardPopular)
            itemDate = itemView.findViewById(R.id.tvDatePopular)
            itemTime = itemView.findViewById(R.id.tvTimePopular)
            itemLocation = itemView.findViewById(R.id.tvLocationPopular)
        }
    }
}