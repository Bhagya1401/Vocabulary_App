package uk.ac.aber.dcs.assigmenttemplate.ui.screens.add_vocab


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import uk.ac.aber.dcs.assigmenttemplate.ui.components.*
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.Screen
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme


@Composable
fun AddVocabScreenTopLevel(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel = viewModel()
) {

    TopLevelScaffold(navController, stringResource(R.string.addVocab))
    { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AddVocabScreen(navController,
//                insertWord = { newWord ->
//                    vocabViewModel.insertWord(newWord)
//                },
//                vocabViewModel.nativeLanguage,
//                vocabViewModel.foreignLanguage,
                vocabViewModel
            )

        }
    }
}

@Composable
fun AddVocabScreen(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel // passes in view model so that delete all function can be called directly
) {
    val nativeLang = rememberSaveable { mutableStateOf("") }
    val foreignLang = rememberSaveable { mutableStateOf("") }


    //Pop up to switch languages
    val showPopUp = rememberSaveable { mutableStateOf(false) }

    //Text for the car on the screen
    val addVocabPageText = stringResource(R.string.addvocab_page_text)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        item {
            DescriptiveText(
                text = addVocabPageText,
                modifier = Modifier
                    //  .align(Alignment.TopCenter)
                    .padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            Column(
                //     modifier = Modifier.align(Alignment.Center)
            ) {

                InputTextField(
                    textVal = nativeLang.value,
                    languageType = vocabViewModel.nativeLanguage,
                    onValueChange = { nativeLang.value = it }
                )

                InputTextField(
                    textVal = foreignLang.value,
                    languageType = vocabViewModel.foreignLanguage,
                    onValueChange = { foreignLang.value = it }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            ActionButton(
                //  modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    ///native isnt being added
                    //native and forieng values are ok

                    val temp = Word(nativeLang.value, foreignLang.value)
                    // println(nativeLang.value)
                    // println(foreignLang.value)
                    vocabViewModel.insertWord(temp)
                    //   println(temp.native)


                },
                //makes sure button is only clickable if there are values in the text fields
                enabled = nativeLang.value.isNotBlank() && foreignLang.value.isNotBlank(),
                text = stringResource(R.string.addvocab_page_button)
            )
        }


        item {

            Spacer(modifier = Modifier.height(10.dp))

            ActionButton(
                // modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    //navController.navigate(Screen.AddVocab.route)
                    showPopUp.value = true
                },
                enabled = true,
                text = stringResource(R.string.change_language_button)

            )

            //If showPopUp is true an alert will be displayed
            if (showPopUp.value) {
                AlertDialog(
                    text = { Text(stringResource(R.string.confirmation)) },
                    onDismissRequest = { showPopUp.value = false },
                    confirmButton = {
                        Button(

                            //When button is pressed database will be deleted
                            //and the user will be directed to home screen
                            onClick = {
                                showPopUp.value = false
                                vocabViewModel.deleteAll()
                                navController.navigate(Screen.Home.route)
                            }
                        ) {
                            //Text for the button

                                Text("Confirm")
                        }
                    },
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun AddVocabScreenPreview() {
    val navController = rememberNavController()
    AssignmentTemplateTheme(dynamicColor = false) {
        AddVocabScreenTopLevel(navController)
    }
}
