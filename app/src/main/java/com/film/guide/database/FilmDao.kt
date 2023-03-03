package com.film.guide.database

import androidx.room.*
import com.film.guide.models.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {
    @Query("SELECT * FROM film")
    fun getAll(): Flow<List<FilmEntity>>

    // функция объединяет два действия, добавление, если объект нет в базе и обновление если объект в базе есть
    @Upsert()
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * FROM film WHERE isFavorite = 1")
    fun getFavorite(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(films: List<FilmEntity>)
}