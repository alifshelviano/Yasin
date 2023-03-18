package com.example.yasin


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.example.yasin.databinding.ActivityDoaBinding
import com.example.yasin.databinding.ListItemDoaBinding


import java.util.*



class AdapterDoa(private val modelBacaan: MutableList<ModelDoa>) :

    RecyclerView.Adapter<AdapterDoa.ListViewHolder>(), Filterable {

    private lateinit var modelBacaanListFull: List<ModelDoa>
    private lateinit var adaBinding: ListItemDoaBinding




    override fun getFilter(): Filter {
        return modelBacaanFilter
    }

    private val modelBacaanFilter: Filter = object : Filter() {

        override fun performFiltering(constraint: CharSequence): FilterResults {

            val filteredList: MutableList<ModelDoa> = ArrayList()

            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(modelBacaanListFull)
            } else {
                val filterPattern = constraint.toString().toLowerCase()
                for (modelDoaFilter in modelBacaanListFull) {
                    if (modelDoaFilter.strTitle?.toLowerCase(Locale.getDefault())?.contains(filterPattern) == true) {
                        filteredList.add(modelDoaFilter)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            modelBacaan.clear()
            modelBacaan.addAll(results.values as List<ModelDoa>)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
       adaBinding = ListItemDoaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(adaBinding.root)
    }

    override fun onBindViewHolder(listViewHolder: ListViewHolder, i: Int) {
        val dataModel = modelBacaan[i]
        listViewHolder.tvId.text = dataModel.strId
        listViewHolder.tvTitle.text = dataModel.strTitle
        listViewHolder.tvArabic.text = dataModel.strArabic
        listViewHolder.tvLatin.text = dataModel.strLatin
        listViewHolder.tvTerjemahan.text = dataModel.strTranslation
    }

    override fun getItemCount(): Int {
        return modelBacaan.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvId: TextView =adaBinding.tvId
        var tvTitle: TextView =adaBinding.tvTitle
        var tvArabic: TextView =adaBinding.tvArabic
        var tvLatin: TextView =adaBinding.tvLatin
        var tvTerjemahan: TextView = adaBinding.tvTerjemahan


    }

    init {
        modelBacaanListFull = ArrayList(modelBacaan)
    }

}