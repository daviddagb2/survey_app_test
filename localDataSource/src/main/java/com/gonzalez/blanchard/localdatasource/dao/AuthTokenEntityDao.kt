package com.gonzalez.blanchard.localdatasource.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gonzalez.blanchard.localdatasource.entity.AuthTokenEntity
import io.reactivex.Flowable

@Dao
interface AuthTokenEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthToken(user: AuthTokenEntity)

    @Query("SELECT * FROM AuthTokenEntity")
    suspend fun getAuthToken(): AuthTokenEntity?

    @Query("SELECT * FROM AuthTokenEntity")
    fun getAuthTokenFlowable(): Flowable<AuthTokenEntity?>

    @Update
    suspend fun updateAuthToken(updateUser: AuthTokenEntity)

    @Delete
    suspend fun deleteAuthToken(userToDelete: AuthTokenEntity)

    @Query("DELETE FROM AuthTokenEntity")
    suspend fun nukeTable()
}
