package co.cyclopsapps.practicemvvmdatabinding.withrecyclerview

import android.app.Application
import androidx.lifecycle.*
import co.cyclopsapps.practicemvvmdatabinding.model.CharacterDataModel
import co.cyclopsapps.practicemvvmdatabinding.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecyclerOneViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {

    private val _itemSelected = MutableLiveData<CharacterDataModel>()
    val itemSelected: LiveData<CharacterDataModel> = _itemSelected

    private val _listState = MutableLiveData<MutableList<CharacterDataModel>>()
    val listState: LiveData<MutableList<CharacterDataModel>> = _listState

    private val repository = CharacterRepository()
    lateinit var observerOnCategorySelected: Observer<CharacterDataModel>


    private val viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    init {
        initObserver()
    }

    private fun initObserver() {
        observerOnCategorySelected = Observer { value ->
            value.let {
                _itemSelected.value = it
            }
        }
    }


    fun clearSelection() {
        _itemSelected.value = null
    }

    fun fetchMorthyData(){
        viewModelScope.launch {
            val response = repository.getCharacter2()
            response?.body()?.results?.let{ list ->
                _listState.value = list
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
