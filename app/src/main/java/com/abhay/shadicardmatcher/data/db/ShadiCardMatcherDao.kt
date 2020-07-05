package com.abhay.shadicardmatcher.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abhay.shadicardmatcher.data.model.ShadiCardMatcherModel

@Dao
interface ShadiCardMatcherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(batchModels: List<ShadiCardMatcherModel>)

    @Query("SELECT * from shadi_card_matcher")
    fun getAllList(): LiveData<List<ShadiCardMatcherModel>>

    @Query("UPDATE shadi_card_matcher SET isAccept = :selection WHERE email =:emailId")
    fun updateOnAccept(selection: Int, emailId: String)

    @Query("UPDATE shadi_card_matcher SET isReject = :selection WHERE email =:emailId")
    fun updateOnReject(selection: Int, emailId: String)

}