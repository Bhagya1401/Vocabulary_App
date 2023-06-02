package uk.ac.aber.dcs.assigmenttemplate.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "word_database")

data class Word(
    var native :String,
    var foreign:String,

    @PrimaryKey(autoGenerate = true)
    var id :Long = 0
){
    // empty constructor required by Room
    constructor() : this("", "")

}
