package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.R
import co.cyclopsapps.practicemvvmdatabinding.databinding.ItemRecyclerviewBinding

class ItemsAdapter(var itemList: ArrayList<String>) : RecyclerView.Adapter<ItemViewHolder>() {
    val resource = R.layout.item_recyclerview
    lateinit var context: Context
    var onItemSelected = MutableLiveData<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRecyclerviewBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setItem(itemList[position])
        holder.itemView.setOnClickListener {
            onItemSelected.value = itemList[position]
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
