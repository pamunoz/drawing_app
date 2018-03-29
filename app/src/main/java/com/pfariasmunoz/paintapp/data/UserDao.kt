package com.pfariasmunoz.paintapp.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun loadUsersWithDrawings(): List<UserWithDrawings>
}