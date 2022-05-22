package com.hydroponicglass.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface PersonDao{
    @Query("SELECT * FROM PersonTable")
    fun GetAll(): List<PersonTable>

    @Insert(onConflict = REPLACE)
    fun Insert(personTable: PersonTable)

    @Update
    fun Update(personTable: PersonTable)

    @Delete
    fun Delete(personTable: PersonTable)

    @Query("SELECT COUNT(*) FROM PersonTable")
    fun GetCount(): Int

    @Query("DELETE FROM PersonTable")
    fun DeleteAll()
}