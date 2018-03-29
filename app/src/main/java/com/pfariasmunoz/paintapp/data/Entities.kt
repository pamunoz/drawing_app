package com.pfariasmunoz.paintapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,
        @ColumnInfo(name = "password") val password: String = "",
        @ColumnInfo(name = "login") var login: String = "")

@Entity
data class Drawing(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "userId")var userId: String,
        @ColumnInfo(name= "location") var url: String)

