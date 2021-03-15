package co.cyclopsapps.practicemvvmdatabinding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Carlos Daniel Agudelo on 14/03/2021.
 */
class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val _openHome = MutableLiveData<Boolean>()
    val openHome: LiveData<Boolean> = _openHome

    private val _openRecyclerView = MutableLiveData<Boolean>()
    val openRecyclerView: LiveData<Boolean> = _openRecyclerView

    fun onHomeClick() {
        _openHome.value = true
    }

    fun homeOpened() {
        _openHome.value = null
    }

    fun onRecyclerViewButtonClick() {
        _openRecyclerView.value = true
    }

    fun recyclerViewOpened() {
        _openRecyclerView.value = null
    }
}