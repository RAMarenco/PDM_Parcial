package com.rmarenco.vinotracker.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rmarenco.vinotracker.VinoTrackerApplication
import com.rmarenco.vinotracker.data.model.VinoModel
import com.rmarenco.vinotracker.repositories.VinoRepository

class VinoViewModel (private val vinoRepository: VinoRepository): ViewModel() {
    var marca = MutableLiveData("")
    var tipo = MutableLiveData("")
    var status = MutableLiveData("")

    fun getVinos() = vinoRepository.getVinos()

    fun addVino(vino: VinoModel) = vinoRepository.addVino(vino)

    fun createVino() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val vino = VinoModel(
            marca.value!!,
            tipo.value!!
        )

        addVino(vino)
        clearData()

        status.value = VINO_CREATED
    }

    private fun validateData(): Boolean {
        when {
            marca.value.isNullOrEmpty() -> return false
            tipo.value.isNullOrEmpty() -> return false
        }

        return true
    }

    fun clearData() {
        marca.value = ""
        tipo.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedVino(vino: VinoModel) {
        marca.value = vino.marca
        tipo.value = vino.tipo
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as VinoTrackerApplication
                VinoViewModel(app.vinoRepository)
            }
        }

        const val VINO_CREATED = "Vino creado"
        const val WRONG_INFORMATION = "Informacion incorrecta"
        const val INACTIVE = ""
    }
}