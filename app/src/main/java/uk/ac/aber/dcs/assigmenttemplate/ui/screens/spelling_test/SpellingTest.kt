package uk.ac.aber.dcs.assigmenttemplate.ui.screens.spelling_test

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.assigmenttemplate.R
import uk.ac.aber.dcs.assigmenttemplate.model.VocabAppViewModel
import uk.ac.aber.dcs.assigmenttemplate.model.Word
import uk.ac.aber.dcs.assigmenttemplate.ui.components.ActionButton
import uk.ac.aber.dcs.assigmenttemplate.ui.components.DescriptiveText
import uk.ac.aber.dcs.assigmenttemplate.ui.components.InputTextField
import uk.ac.aber.dcs.assigmenttemplate.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.Screen
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme

@Composable
fun SpellingTestTopLevel(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel = viewModel()
) {
    val wordList by vocabViewModel.wordList.observeAsState(listOf())

    TopLevelScaffold(navController, stringResource(R.string.spellingTest))
    { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            println(wordList.size)
            SpellingTestScreen(
                navController,
                wordList = wordList,
                vocabViewModel.nativeLanguage
            )
        }
    }
}

@Composable
fun SpellingTestScreen(navController: NavHostController,
                       wordList: List<Word> = listOf(),
                       nativeLanguage: String) {

//    val nativeLangLabel = stringResource(R.string.spelling_label)

    if (wordList.isNotEmpty()) {



        val randomWord = remember {
            wordList.random()
        }

        val showResult = rememberSaveable { mutableStateOf(false) }

        val result = rememberSaveable { mutableStateOf("") }

        val foreignWord = rememberSaveable { mutableStateOf("") }
        val foreignLangLabel = stringResource(R.string.foreign_text_field_label)
        // val nativeLangWord = rememberSaveable { mutableStateOf(wordList[Random.nextInt(wordList.size)]) }
//        val homePageText = stringResource(R.string.home_page_text)


        LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
        {

            item {
                DescriptiveText(
                    text = "In $nativeLanguage: ${randomWord.native}",
                    modifier = Modifier
//                    .align(Alignment.TopCenter)
                        .padding(top = 30.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Column(
                    //    modifier = Modifier.align(Alignment.Center)
                ) {

                    //Text field to enter spelling of foreign language
                    InputTextField(
                        textVal = foreignWord.value,
                        languageType = foreignLangLabel,
                        onValueChange = { foreignWord.value = it }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }


            item {
                ActionButton(
                    // modifier = Modifier.align(Alignment.BottomCenter),
                    onClick = {
                        //navController.navigate(Screen.AddVocab.route)
                        println("----------------------------------------------------------------------------")
                        println(foreignWord.value.lowercase())
                        println(randomWord.foreign.lowercase())
                        println(foreignWord.value.lowercase() == randomWord.foreign.lowercase())
                        println("----------------------------------------------------------------------------")
                        if (foreignWord.value.lowercase() == randomWord.foreign.lowercase()) {
                            result.value = "Congratulations"
                        } else {
                            result.value = "Ooo too bad"
                        }
                        showResult.value = true
                    },
                    //makes sure button is only clickable if there are values in the text fields
                    enabled = foreignWord.value.isNotBlank(),
                    text = stringResource(R.string.submit_button)

                )

                if (showResult.value) {
                    AlertDialog(
                        text = { Text(result.value) },
                        onDismissRequest = { showResult.value = false },
                        // in below line we are displaying
                        // our dismiss button.
                        confirmButton =  {
                            // in below line we are displaying
                            // our text button
                            Button(
                                // adding on click listener for this button
                                onClick = {
                             //       randomWord = wordList.random().
                                 //   randomWord = mutableStateOf( wordList.random())

                                    showResult.value = false
                                    navController.navigate(Screen.TestOne.route)
                                }
                            ) {
                                // adding text to our button.
                                Text("Dismiss")
                            }
                        },
                    )
                }
            }
        }
    }
}


//Text box with Native Word, get word from list of words
//
//if word right on button click show box, alert dialog
//


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    AssignmentTemplateTheme(dynamicColor = false) {
        SpellingTestTopLevel(navController)
    }
}