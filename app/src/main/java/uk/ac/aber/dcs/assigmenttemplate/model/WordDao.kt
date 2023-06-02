package uk.ac.aber.dcs.assigmenttemplate.model

import androidx.lifecycle.LiveData
import androidx.room.*
import java.lang.annotation.Native

@Dao
interface WordDao {



    @Insert
    suspend fun insertWord(word: Word)
//    {
//        println(word.native)
//        println(word.foreign)
//        println("----------------------------------------")
//    }

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("DELETE FROM word_database")
    suspend fun deleteAll()

    @Query("SELECT * FROM word_database")
    fun getAllWords(): LiveData<List<Word>>


}

