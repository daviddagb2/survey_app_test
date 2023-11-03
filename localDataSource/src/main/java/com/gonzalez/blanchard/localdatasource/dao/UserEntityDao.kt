package com.gonzalez.blanchard.localdatasource.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gonzalez.blanchard.localdatasource.entity.UserEntity
import io.reactivex.Flowable

@Dao
interface UserEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    suspend fun getUser(): UserEntity?

    @Query("SELECT * FROM UserEntity")
    fun getUserFlowable(): Flowable<UserEntity?>

    @Update
    suspend fun updateUser(updateUser: UserEntity)

    @Delete
    suspend fun deleteUser(userToDelete: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun nukeTable()
}
