package com.pfariasmunoz.paintapp.data.source.local

import android.arch.persistence.room.*
import com.pfariasmunoz.paintapp.data.User

/**
 * Data Access Object for the users table.
 */
@Dao interface UsersDao {
    /**
     * Select all users from the users table.
     *
     * @return all users.
     */
    @Query("SELECT * FROM users") fun getUsers(): List<User>

    /**
     * Select a user by id.
     *
     * @param userId the user id.
     * @return the user with userId.
     */
    @Query("SELECT * FROM users WHERE entryId = :userId") fun getUserById(userId: Long): User?

    /**
     * Insert a user in the database. If the user already exists, replace it.
     *
     * @param user the task to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertUser(user: User)

    /**
     * Update a user.
     *
     * @param user user to be updated
     * @return the number of users updated. This should always be 1.
     */
    @Update
    fun updateUser(user: User): Int

    /**
     * Delete a user by id.
     *
     * @return the number of users deleted. This should always be 1.
     */
    @Query("DELETE FROM users WHERE entryid = :userId") fun deleteUserById(userId: Long): Int

    /**
     * Delete all users.
     */
    @Query("DELETE FROM users") fun deleteUsers()
}