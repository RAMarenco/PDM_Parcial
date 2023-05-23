package com.rmarenco.vinotracker.data

import com.rmarenco.vinotracker.data.model.VinoModel

val vino1 = VinoModel("Catena","rosado")
val vino2 = VinoModel("Penfolds","Tinto")
val vino3 = VinoModel("Torres","Espumoso")
val vino4 = VinoModel("Concha y Toro","Generoso")

var vinos = mutableListOf(vino1, vino2, vino3, vino4)