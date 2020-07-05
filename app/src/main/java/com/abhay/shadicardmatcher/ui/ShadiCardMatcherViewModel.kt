package com.abhay.shadicardmatcher.ui

import androidx.lifecycle.ViewModel
import com.abhay.shadicardmatcher.data.ShadiCardMatcherRepository
import com.abhay.shadicardmatcher.data.model.ShadiCardMatcherModel
import javax.inject.Inject

class ShadiCardMatcherViewModel @Inject constructor(
    private val shadiCardMatcherRepository: ShadiCardMatcherRepository
) : ViewModel() {

    val users = shadiCardMatcherRepository.users


    fun onAccept(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherRepository.onAccept(shadiCardMatcherModel)
    }

    fun onReject(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherRepository.onReject(shadiCardMatcherModel)
    }

    override fun onCleared() {
        super.onCleared()
        shadiCardMatcherRepository.cancelAllRequests()
    }
}