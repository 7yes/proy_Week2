package com.sevenyes.pweek2c.models

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sevenyes.pweek2c.Evento

object EventsData {
    private var eventos : MutableList<Evento> = mutableListOf()

    fun add(event: Evento) {
        eventos.add(event)
    }

    fun getDataFromFile(jsonEvents: String): List<Evento> {
        eventos = Gson().fromJson(jsonEvents, object: TypeToken<List<Evento?>?>() {}.type)
      return eventos
    }

    fun getAllEvents(): List<Evento> {
        return eventos
    }

    fun getEvent(position: Int): Evento = eventos[position]
}