package com.gonzalez.blanchard.localdatasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class SettingsEntity(
    @PrimaryKey
    @ColumnInfo(name = "keyVal")
    val keyVal: String,
    @ColumnInfo(name = "value") val value: String,
)
