package com.sevenyes.pweek2c

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.gson.Gson
import com.sevenyes.pweek2c.models.EventsData
import java.util.*


fun navegarFrac (fragmentManager: FragmentManager, fragment: Fragment) {
    fragmentManager.beginTransaction()
        .replace(R.id.nav_host_fragment_content_main,fragment)
        .addToBackStack(null)
        .commit()
}

fun getDate( date: Long) : Fecha {
    val cal = Calendar.getInstance()
    cal.timeInMillis = date
    var fecha = Fecha(1900,0,1)
    fecha.month = cal.get(Calendar.MONTH)
    fecha.day = cal.get(Calendar.DAY_OF_MONTH)
    fecha.year = cal.get(Calendar.YEAR)
    return fecha

}

fun putDate(fecha: Fecha) : Long {
    val cal = Calendar.getInstance()
    cal.set(fecha.year, fecha.month, fecha.day)
    return cal.timeInMillis
}

fun saveEvent(context : Context, event : Evento ){

    EventsData.add(event)
    val eventos = EventsData.getAllEvents()
    val gson = Gson()
    val jsonString = gson.toJson(eventos)

    val preference = context.getSharedPreferences("even_list", Context.MODE_PRIVATE)

    preference.apply {
        val editor = edit()

        editor.putString("SEY",jsonString).apply()
    }

}

fun readEvents(context: Context): String {
    val preference = context.getSharedPreferences("even_list", Context.MODE_PRIVATE)
    return preference.getString("SEY", null) ?: ""
}

