package com.rmarenco.vinotracker.ui.vino.vinolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rmarenco.vinotracker.R
import com.rmarenco.vinotracker.data.model.VinoModel
import com.rmarenco.vinotracker.databinding.FragmentVinoListBinding
import com.rmarenco.vinotracker.viewmodel.VinoViewModel

class VinoListFragment : Fragment() {
    private lateinit var binding: FragmentVinoListBinding
    private val vinoViewModel: VinoViewModel by activityViewModels {
        VinoViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVinoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Adds a click event for the floating button to the addwine view
        binding.addVinoFloatingButton.setOnClickListener {
            vinoViewModel.clearData()
            findNavController().navigate(R.id.action_vinoListFragment_to_addVinoFragment)
        }
    }

    private fun showSelectedItem(vino: VinoModel) {
        //Add the selected wine information to variables in the viewmodel that the
        //detail layout then presents
        vinoViewModel.setSelectedVino(vino)
        findNavController().navigate(R.id.action_vinoListFragment_to_vinoDetailsFragment)
    }

    private fun displayVinos() {

    }

    private fun setRecyclerView(view: View) {

    }
}