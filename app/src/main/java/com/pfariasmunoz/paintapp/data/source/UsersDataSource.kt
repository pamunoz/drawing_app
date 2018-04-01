package com.pfariasmunoz.paintapp.data.source

import com.pfariasmunoz.paintapp.data.User

interface UsersDataSource {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUser(userId: Long): Result<User>
    suspend fun saveUser(user: User)
    suspend fun refreshUsers()
    suspend fun deleteAllUsers()
    suspend fun deleteUser(userId: Long)
}
