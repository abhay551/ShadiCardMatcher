package com.abhay.shadicardmatcher.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abhay.shadicardmatcher.data.model.ShadiCardMatcherModel

@Database(entities = [ShadiCardMatcherModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getShadiCardMatcherDao(): ShadiCardMatcherDao


}