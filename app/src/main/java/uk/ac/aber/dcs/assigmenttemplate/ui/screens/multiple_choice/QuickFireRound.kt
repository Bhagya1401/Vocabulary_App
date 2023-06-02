package uk.ac.aber.dcs.assigmenttemplate.ui.screens.multiple_choice

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.assigmenttemplate.R
import uk.ac.aber.dcs.assigmenttemplate.model.VocabAppViewModel
import uk.ac.aber.dcs.assigmenttemplate.model.Word
import uk.ac.aber.dcs.assigmenttemplate.ui.components.DescriptiveText
import uk.ac.aber.dcs.assigmenttemplate.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.Screen
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.spelling_test.SpellingTestScreen
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.*

@Composable
fun QuickFireTopLevel(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel = viewModel()
) {
    val wordList by vocabViewModel.wordList.observeAsState(listOf())
    TopLevelScaffold(navController, stringResource(R.string.quickFireTest))
    { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            QuickFireScreen(
                navController,
                wordList = wordList,
                vocabViewModel.nativeLanguage
            )
        }
    }
}

@Composable
fun QuickFireScreen(
    navController: NavHostController,
    wordList: List<Word> = listOf(),
    nativeLanguage: String

) {


    //Makes sure list is not empty
    if (wordList.isNotEmpty()) {
        val tries = rememberSaveable { mutableStateOf(0) }
        val score = rememberSaveable { mutableStateOf(0) }
        val resultColor = remember { mutableStateOf( Color.Black) }

        val showResult = rememberSaveable{ mutableStateOf(false) }

        val questions = Questions(wordList)

//        println("============================================================================")
//        println(choices)
//        println("============================================================================")

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                for (question in questions) {
                    DescriptiveText(
                        text = "$nativeLanguage word is: ${question.answer.native}",
                        modifier = Modifier
                            .padding(top = 30.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    for (choice in question.choices) {
                        OutlinedButton(
                            onClick = {
                                if (question.answer.foreign == choice.foreign) {
                                    resultColor.value = Color.Green
                                    score.value++
                                }
                                else{
                                    resultColor.value = Color.Red
                                }
                                if (tries.value == 5){
                                    showResult.value =true
                                    }
                                tries.value++


                                //   navController.navigate(Screen.TestTwo.route)

                            },
                            colors = ButtonDefaults.buttonColors(resultColor.value),
                            border = BorderStroke(10.dp, resultColor.value)
                        ) {
                            Text(choice.foreign)

                        }
                    }
                }
                if (showResult.value) {
                    AlertDialog(
                        text = { Text("Congrats you finished the test and scored ${score.value} out of ${tries.value} ") },
                        onDismissRequest = { showResult.value = false },
                        // in below line we are displaying
                        // our dismiss button.
                        confirmButton =  {
                            // in below line we are displaying
                            // our text button
                            Button(
                                // adding on click listener for this button
                                onClick = {
                                    showResult.value = false
                                    navController.navigate(Screen.TestTwo.route)
                                }
                            ) {
                                // adding text to our button.
                                Text("Dismiss")
                            }
                        },
                    )
                }
            }
//            item {
//                Spacer(modifier = Modifier.height(20.dp))
//                Text(text = "Your score is ${score.value} out of ${tries.value}")
//            }


        }
    }

}

@Composable
fun Questions(
    wordList: List<Word> = listOf(),
): MutableList<Question> {

    val questions = mutableListOf<Question>()
    val choices = mutableListOf<Word>()
    choices.add(wordList.random())
    choices.add(wordList.random())
    choices.add(wordList.random())
    for (i in 0..5) {
        val question = Question(choices, choices.random())
        questions.add(question)
    }


    return questions
}
//@Preview
//@Composable
//fun QuickFireScreenPreview() {
//    AssigmentTemplateTheme {
//        val navController = rememberNavController()
//        QuickFireScreen(navController,)
//    }
//}
