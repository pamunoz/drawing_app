package com.pfariasmunoz.paintapp.data.source

import com.pfariasmunoz.paintapp.data.User

interface UserDataSource {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUser(userId: String): Result<User>
    suspend fun saveUser(user: User)
    suspend fun refreshUsers()
    suspend fun deleteAllUsers()
    suspend fun deleteuser(userId: String)
}
