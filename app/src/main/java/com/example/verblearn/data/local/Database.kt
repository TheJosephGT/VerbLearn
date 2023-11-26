package com.example.verblearn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.verblearn.data.local.dao.FavoriteDao
import com.example.verblearn.data.local.entities.Favorite



@Database(
    entities = [Favorite::class],
    version = 8
)
abstract class Database : RoomDatabase() {
    abstract fun FavoriteDao() : FavoriteDao
}