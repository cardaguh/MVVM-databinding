package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.databinding.ItemRecyclerviewBinding

class ItemViewHolder(binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    private var binding: ItemRecyclerviewBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(name: String) {
        binding?.name = name
        binding?.executePendingBindings()
    }

}
