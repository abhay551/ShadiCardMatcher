package com.abhay.shadicardmatcher.data.api

import com.abhay.shadicardmatcher.base.BaseRemoteDataSource
import javax.inject.Inject

class ShadiCardMatcherRemoteDataSource @Inject constructor(private val service: ShadiCardMatcherApiService) :
    BaseRemoteDataSource() {

    suspend fun fetchUsers() = getResult { service.fetchRandomUsers(10) }

}