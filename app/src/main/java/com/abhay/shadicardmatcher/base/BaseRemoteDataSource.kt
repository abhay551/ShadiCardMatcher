package com.abhay.shadicardmatcher.base

import com.abhay.shadicardmatcher.utils.RepositoryResult
import retrofit2.Response

abstract class BaseRemoteDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): RepositoryResult<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return RepositoryResult.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): RepositoryResult<T> {
        return RepositoryResult.error("Network call has failed for a following reason: $message")
    }

}