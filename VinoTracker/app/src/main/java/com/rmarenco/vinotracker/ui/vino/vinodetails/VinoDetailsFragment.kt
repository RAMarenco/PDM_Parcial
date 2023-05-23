package com.rmarenco.vinotracker.ui.vino.vinodetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rmarenco.vinotracker.R
import com.rmarenco.vinotracker.databinding.FragmentVinoDetailsBinding
import com.rmarenco.vinotracker.viewmodel.VinoViewModel

class VinoDetailsFragment : Fragment() {
    private lateinit var binding: FragmentVinoDetailsBinding
    private val vinoViewModel: VinoViewModel by activityViewModels {
        VinoViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVinoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Binds the variable viewmodel in the layout to the information
        //in the viewmodel class
        binding.vinoViewModel = vinoViewModel
    }
}