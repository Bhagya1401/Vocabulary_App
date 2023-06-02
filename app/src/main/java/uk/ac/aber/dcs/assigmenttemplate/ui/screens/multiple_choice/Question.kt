package uk.ac.aber.dcs.assigmenttemplate.ui.screens.multiple_choice

import uk.ac.aber.dcs.assigmenttemplate.model.Word

data class Question(
    val choices: List<Word> = listOf(),
    val answer: Word) {
}