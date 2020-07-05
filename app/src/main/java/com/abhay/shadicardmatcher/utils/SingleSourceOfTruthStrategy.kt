package com.abhay.shadicardmatcher.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun <T, A> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> RepositoryResult<A>,
    saveCallResult: suspend (A) -> Unit
): LiveData<RepositoryResult<T>> =
    liveData(Dispatchers.IO) {
        emit(RepositoryResult.loading<T>())
        val source = databaseQuery.invoke().map {
            RepositoryResult.success(
                it
            )
        }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == RepositoryResult.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)
        } else if (responseStatus.status == RepositoryResult.Status.ERROR) {
            emit(
                RepositoryResult.error<T>(
                    responseStatus.message!!
                )
            )
            emitSource(source)
        }
    }