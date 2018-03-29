package com.pfariasmunoz.paintapp.data

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

class UserWithDrawings {
    @Embedded
    lateinit var user: User

    @Relation(parentColumn = "id", entityColumn = "userId", entity = User::class)
    lateinit var drawings: List<Drawing>

}