package com.example.verblearn.data.local

import com.example.verblearn.data.local.dao.FavoriteDao
import com.example.verblearn.data.local.entities.Favorite
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val favoriteDao: FavoriteDao) {

    suspend fun save(favorite: Favorite) = favoriteDao.save(favorite)
    suspend fun delete(favorite: Favorite) = favoriteDao.delete(favorite)
    suspend fun find(id: Int) = favoriteDao.find(id)
    fun getAll() = favoriteDao.getAll()

}