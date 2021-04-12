package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.practicemvvmdatabinding.databinding.CharacterRowBinding
import co.cyclopsapps.practicemvvmdatabinding.model.CharacterDataModel
import com.bumptech.glide.Glide

class ItemViewHolder(binding: CharacterRowBinding) : RecyclerView.ViewHolder(binding.root) {
    private var binding: CharacterRowBinding? = null

    init {
        this.binding = binding
    }

    fun setItem(model: CharacterDataModel) {
        binding?.let { view ->
            view.name = model.name
           // view.executePendingBindings()

            Glide.with(view.root.context).load(model.image).into(view.imgCharacter)
        }
    }


}
