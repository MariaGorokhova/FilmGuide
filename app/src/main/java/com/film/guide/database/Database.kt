package com.film.guide.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.film.guide.models.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}