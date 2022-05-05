package com.hydroponicglass.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface PersonDao{
    @Query("SELECT * FROM PersonTable")
    fun GetAll(): List<PersonTable>

    @Insert(onConflict = REPLACE)
    fun Insert(personTable: PersonTable)

    @Query("DELETE FROM PersonTable")
    fun DeleteAll()
}