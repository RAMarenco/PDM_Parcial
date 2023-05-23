package com.rmarenco.vinotracker.ui.vino.addvino

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rmarenco.vinotracker.R
import com.rmarenco.vinotracker.databinding.FragmentAddVinoBinding
import com.rmarenco.vinotracker.viewmodel.VinoViewModel

class AddVinoFragment : Fragment() {
    private lateinit var binding: FragmentAddVinoBinding
    private val vinoViewModel: VinoViewModel by activityViewModels {
        VinoViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddVinoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.vinoViewModel = vinoViewModel
    }

    private fun observeStatus() {


        vinoViewModel.status.observe(viewLifecycleOwner) { status ->
            //If the information added in the inputs is incomplete
            //a error message is displayed
            when {
                status.equals(VinoViewModel.WRONG_INFORMATION) -> {
                    vinoViewModel.clearStatus()
                    Toast.makeText(requireContext(), status, Toast.LENGTH_LONG).show()
                }
            }
            //If the information added in the inputs is correct
            //a ok message is displayed and the wine wine added
            when {
                status.equals(VinoViewModel.VINO_CREATED) -> {
                    Toast.makeText(requireContext(), status, Toast.LENGTH_LONG).show()
                    vinoViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}