package com.abhay.shadicardmatcher.data.db

import androidx.room.TypeConverter
import com.abhay.shadicardmatcher.data.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    val gson = Gson()

    @TypeConverter
    fun StringToDob(string: String): Dob {
        val type = object : TypeToken<Dob>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun DobToString(dob: Dob): String {
        return gson.toJson(dob)
    }

    @TypeConverter
    fun StringToCoordinates(string: String): Coordinates {
        val type = object : TypeToken<Coordinates?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun CoordinatesToString(coordinates: Coordinates): String {
        return gson.toJson(coordinates)
    }

    @TypeConverter
    fun StringToId(string: String): Id {
        val type = object : TypeToken<Id>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun IdToSting(id: Id): String {
        return gson.toJson(id)
    }

    @TypeConverter
    fun StringToInfo(string: String): Info {
        val type = object : TypeToken<Info>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun InfoToSting(info: Info): String {
        return gson.toJson(info)
    }

    @TypeConverter
    fun StringToLocation(string: String): Location {
        val type = object : TypeToken<Location>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun LocationToSting(location: Location): String {
        return gson.toJson(location)
    }

    @TypeConverter
    fun StringToLogin(string: String): Login {
        val type = object : TypeToken<Login?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun LoginToSting(login: Login): String {
        return gson.toJson(login)
    }

    @TypeConverter
    fun StringToName(string: String): Name {
        val type = object : TypeToken<Name>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun NameToSting(name: Name): String {
        return gson.toJson(name)
    }

    @TypeConverter
    fun StringToPicture(string: String): Picture {
        val type = object : TypeToken<Picture>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun PictureToSting(picture: Picture): String {
        return gson.toJson(picture)
    }

    @TypeConverter
    fun StringToRegistered(string: String): Registered {
        val type = object : TypeToken<Registered?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun RegisteredToSting(picture: Registered): String {
        return gson.toJson(picture)
    }

    @TypeConverter
    fun StringToTimezone(string: String): Timezone {
        val type = object : TypeToken<Timezone>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun TimezoneToSting(timezone: Timezone): String {
        return gson.toJson(timezone)
    }
}