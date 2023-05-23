package com.rmarenco.vinotracker.ui.vino.vinolist.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rmarenco.vinotracker.data.model.VinoModel
import com.rmarenco.vinotracker.databinding.VinoItemBinding

class VinoRecyclerViewAdapter(private val clickListener: (VinoModel) -> Unit) :
    RecyclerView.Adapter<VinoRecyclerViewAdapter.VinoRecyclerViewHolder>() {

    private var vinos: List<VinoModel>? = null

    class VinoRecyclerViewHolder(private val binding: VinoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(vino: VinoModel, clickListener: (VinoModel) -> Unit) {
            //Populates card information and click fun
            binding.vinoMarcaDetail.text = vino.marca
            binding.vinoTipoDetail.text = vino.tipo
            binding.VinoCardView.setOnClickListener {
                clickListener(vino)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VinoRecyclerViewHolder {
        val binding = VinoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VinoRecyclerViewHolder(binding)
    }

    //Gets the count of wines in the datadummy
    override fun getItemCount(): Int = vinos?.size ?: 0

    //Calls the fun to bind each card to its info
    override fun onBindViewHolder(holder: VinoRecyclerViewHolder, position: Int) {
        vinos?.let {
            holder.bind(it[position], clickListener)
        }
    }

    //Sets the data for the recycler view
    fun setData(vinos: List<VinoModel>) {
        this.vinos = vinos
    }
}