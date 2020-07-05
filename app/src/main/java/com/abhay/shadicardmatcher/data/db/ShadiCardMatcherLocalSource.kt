package com.abhay.shadicardmatcher.data.db

import androidx.lifecycle.LiveData
import com.abhay.shadicardmatcher.utils.CoroutinesDispatcherProvider
import com.abhay.shadicardmatcher.data.model.ShadiCardMatcherModel
import kotlinx.coroutines.withContext

class ShadiCardMatcherLocalSource(
    val reposDao: ShadiCardMatcherDao,
    val dispatcherProvider: CoroutinesDispatcherProvider
) {

    suspend fun insertAll(shadiCardMatcherModels: List<ShadiCardMatcherModel>) =
        withContext(dispatcherProvider.ioDispatcher) {
            reposDao.insertAll(shadiCardMatcherModels)
        }

    suspend fun updateOnAccept(selection: Int, emailId: String) {
        withContext(dispatcherProvider.ioDispatcher) {
            reposDao.updateOnAccept(selection, emailId)
        }
    }

    suspend fun updateOnReject(selection: Int, emailId: String) {
        withContext(dispatcherProvider.ioDispatcher) {
            reposDao.updateOnReject(selection, emailId)
        }
    }

    fun getAllList(): LiveData<List<ShadiCardMatcherModel>> {
        return reposDao.getAllList()
    }
}