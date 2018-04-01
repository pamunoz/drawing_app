package com.pfariasmunoz.paintapp.data.source.local

import android.support.annotation.VisibleForTesting
import com.pfariasmunoz.paintapp.data.User
import com.pfariasmunoz.paintapp.data.source.LocalDataNotFoundException
import com.pfariasmunoz.paintapp.data.source.Result
import com.pfariasmunoz.paintapp.data.source.UsersDataSource
import com.pfariasmunoz.paintapp.util.AppExecutors
import kotlinx.coroutines.experimental.withContext

class UsersLocalDataSource private constructor(
    val appExecutors: AppExecutors,
    val usersDao: UsersDao
) : UsersDataSource {

    override suspend fun getUsers(): Result<List<User>> = withContext(appExecutors.ioContext) {
        val users = usersDao.getUsers()
        if (users.isNotEmpty()) {
            Result.Success(usersDao.getUsers())
        } else {
            Result.Error(LocalDataNotFoundException())
        }
    }

    override suspend fun getUser(userId: Long): Result<User> = withContext(appExecutors.ioContext) {
        val user = usersDao.getUserById(userId)
        if (user != null) Result.Success(user) else Result.Error(LocalDataNotFoundException())
    }

    override suspend fun saveUser(user: User) = withContext(appExecutors.ioContext) {
        usersDao.insertUser(user)
    }

    override suspend fun refreshUsers() {
        // Not required because the [@link UsersRepository] handles the logic of refreshing the
        // users from all the available data sources.
    }

    override suspend fun deleteAllUsers() = withContext(appExecutors.ioContext) {
        usersDao.deleteUsers()
    }

    override suspend fun deleteUser(userId: Long) {
        withContext(appExecutors.ioContext) {
            usersDao.deleteUserById(userId)
        }
    }

    companion object {
        private var INSTANCE: UsersLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, tasksDao: UsersDao): UsersLocalDataSource {
            if (INSTANCE == null) {
                synchronized(UsersLocalDataSource::javaClass) {
                    INSTANCE = UsersLocalDataSource(appExecutors, tasksDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}