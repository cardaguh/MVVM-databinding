package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.R
import co.cyclopsapps.practicemvvmdatabinding.databinding.CharacterRowBinding
import co.cyclopsapps.practicemvvmdatabinding.databinding.ItemRecyclerviewBinding
import co.cyclopsapps.practicemvvmdatabinding.model.CharacterDataModel

class ItemsAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    val resource = R.layout.character_row
    lateinit var context: Context
    var onItemSelected = MutableLiveData<CharacterDataModel>()
    private val itemList = mutableListOf<CharacterDataModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: CharacterRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setItem(itemList[position])

        holder.itemView.setOnClickListener {
            onItemSelected.value = itemList[position]
        }
    }


    fun setItems(list: MutableList<CharacterDataModel>){
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
