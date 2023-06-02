package uk.ac.aber.dcs.assigmenttemplate.datasource

import android.app.Application
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import uk.ac.aber.dcs.assigmenttemplate.model.Word

class WordRepository(application: Application){

    private val wordDao = WordDatabase.getDatabase(application).wordDao()


    suspend fun insert(word: Word){
        wordDao.insertWord(word)
    }

    suspend fun deleteWord(word: Word){
        wordDao.deleteWord(word)
    }

    suspend fun deleteAll(){
        wordDao.deleteAll()
    }


    fun getAllWords() = wordDao.getAllWords()





}


//    fun getRandomWord(): LiveData<Word> {
//        val shuffledList: LiveData<List<Word>> = wordDao.getAllWords().map { words ->
//            words.shuffled()
//        }
//        return Transformations.map(shuffledList) { it.first() }
//    }