package com.sevenyes.pweek2c.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sevenyes.pweek2c.models.Evento
import com.sevenyes.pweek2c.R

class EventAdapter(
    private var _events: List<Evento> = emptyList(),
    private val onEventClick: (position: Int) -> Unit
    ) : RecyclerView.Adapter<EventViewHolder>() {

    fun updateDateData(events: List<Evento>) {
        _events = events
        notifyItemInserted(itemCount - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventView = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)

        return EventViewHolder(eventView, onEventClick)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(_events[position])

    override fun getItemCount(): Int = _events.size
}

class EventViewHolder(
    itemView: View,
    private val onEventClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val eventTitle: TextView = itemView.findViewById(R.id.event_title)
    private val eventCategory: TextView = itemView.findViewById(R.id.event_category)
    private val eventDate: TextView = itemView.findViewById(R.id.event_date)

   fun bind(event: Evento) {
       eventTitle.text = event.title
       eventCategory.text = event.cat
       eventDate.text = "${event.fecha.month}/${event.fecha.day}/${event.fecha.year}"

       itemView.setOnClickListener {
           onEventClick(adapterPosition)
       }
   }
}