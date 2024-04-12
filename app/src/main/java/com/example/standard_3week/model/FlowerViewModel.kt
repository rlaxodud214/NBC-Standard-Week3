package com.example.standard_3week.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standard_3week.data.Flower

class FlowerViewModel : ViewModel() {
    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers: LiveData<List<Flower>> = _flowers

    fun setDescription(info: String) {
        _description.value = info
    }

    fun setFlowers(flower: List<Flower>) {
        _flowers.value = flower
    }
}