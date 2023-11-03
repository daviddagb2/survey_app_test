package com.gonzalez.blanchard.localdatasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gonzalez.blanchard.localdatasource.entity.SettingsEntity
@Dao
interface SettingsDao {
    @Query("SELECT * FROM settings ORDER BY keyVal ASC")
    suspend fun getAll(): List<SettingsEntity>

    @Query("SELECT * FROM settings WHERE keyVal = :key")
    suspend fun getDetail(key: String): List<SettingsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tags: List<SettingsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tag: SettingsEntity)

    @Query("DELETE FROM settings")
    suspend fun deleteAll()
}
