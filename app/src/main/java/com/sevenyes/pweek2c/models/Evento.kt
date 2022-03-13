package com.sevenyes.pweek2c.models

data class Evento ( val title: String, val cat: String, val fecha: Fecha)
data class Fecha(var year: Int, var month: Int, var day: Int)