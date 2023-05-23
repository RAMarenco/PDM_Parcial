package com.rmarenco.vinotracker

import android.app.Application
import com.rmarenco.vinotracker.data.vinos
import com.rmarenco.vinotracker.repositories.VinoRepository

class VinoTrackerApplication: Application() {
    val vinoRepository: VinoRepository by lazy {
        VinoRepository(vinos)
    }
}