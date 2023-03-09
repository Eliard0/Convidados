package com.example.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = GuestRepository(application.applicationContext)
    private val listAllGuest = MutableLiveData<List<GuestModel>>()

    val guests: LiveData<List<GuestModel>> = listAllGuest

    fun getAll() {
        listAllGuest.value = repository.getAll()
    }

    fun getPresent() {
        listAllGuest.value = repository.getPresent()
    }

    fun getAbsent() {
        listAllGuest.value = repository.getAbsent()
    }

    fun delete(id: Int) {
        repository.delete(id)
    }
}