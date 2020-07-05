package com.abhay.shadicardmatcher.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.abhay.shadicardmatcher.data.db.Converters

@Entity(tableName = "shadi_card_matcher")
data class ShadiCardMatcherModel(
    val uid:Int,
    val gender: String,
    @TypeConverters(Converters::class) val name: Name,
    @TypeConverters(Converters::class) val location: Location,
    @PrimaryKey val email: String,
    @TypeConverters(Converters::class) val login: Login,
    @TypeConverters(Converters::class) val dob: Dob,
    @TypeConverters(Converters::class) val registered: Registered,
    val phone: String,
    val cell: String,
    @TypeConverters(Converters::class) val id: Id,
    @TypeConverters(Converters::class) val picture: Picture,
    val nat: String,
    val isAccept: Boolean,
    val isReject:Boolean
)