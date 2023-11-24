package com.example.verblearn.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.verblearn.data.local.entities.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Upsert
    suspend fun save(favorite: Favorite)
    @Query(
        """
            SELECT *
            FROM Favorites
            WHERE id=:id
            LIMIT 1
        """
    )
    suspend fun find(id:Int) : Favorite?

    @Delete
    suspend fun delete(favorite: Favorite)

    @Query("SELECT * FROM Favorites")
    fun getAll() : Flow<List<Favorite>>
}