package com.rmarenco.vinotracker.repositories

import com.rmarenco.vinotracker.data.model.VinoModel

class VinoRepository (private val vinos: MutableList<VinoModel>) {
    fun getVinos() = vinos

    fun addVino(vino: VinoModel) = vinos.add(vino)
}