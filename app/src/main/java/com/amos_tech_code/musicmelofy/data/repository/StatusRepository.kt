package com.amos_tech_code.musicmelofy.data.repository

import com.amos_tech_code.musicmelofy.data.network.ApiService
import com.amos_tech_code.musicmelofy.data.network.Resource
import com.amos_tech_code.musicmelofy.data.network.safeApiCall
import org.koin.core.annotation.Single

@Single
class StatusRepository(
    private val apiService: ApiService
) {
//    suspend fun getStatus() : String {
//        return apiService.getSomething().body()?.get("status") ?: "Failed"
//    }

    suspend fun getStatus(): Resource<String> {
        return try {
            val response = apiService.getSomething()
            if (response.isSuccessful) {
                Resource.Success(response.body()?.get("status") ?: "Failed")
            } else {
                Resource.Error("Failed to fetch status")
            }
        } catch (e: Exception) {
            Resource.Error("Network Error: ${e.message}")
        }
    }
}