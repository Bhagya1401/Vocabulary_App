package uk.ac.aber.dcs.assigmenttemplate.ui.screens.home

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
import uk.ac.aber.dcs.assigmenttemplate.ui.components.ActionButton
import uk.ac.aber.dcs.assigmenttemplate.ui.components.DescriptiveText
import uk.ac.aber.dcs.assigmenttemplate.ui.components.InputTextField
import uk.ac.aber.dcs.assigmenttemplate.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.Screen
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme


@Composable
fun HomeScreenTopLevel(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel = viewModel()
)
{
    TopLevelScaffold(navController, stringResource(R.string.home)){
            innerPadding ->

        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            HomeScreen(
                navController,
                insertNative = { setNative ->
                    vocabViewModel.setNative(setNative)
                },
                insertForeign = { setForeign ->
                    vocabViewModel.setForeign(setForeign)
                }

            )
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController,insertNative: (String) -> Unit = {}, insertForeign: (String) -> Unit = {}) {

    val nativeLangLabel = stringResource(R.string.native_text_field_label)
    val foreignLangLabel = stringResource(R.string.foreign_text_field_label)


    val foreignLang = rememberSaveable{ mutableStateOf("") }
    val nativeLang = rememberSaveable{ mutableStateOf("") }
    val homePageText = stringResource(R.string.home_page_text)


    LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        item {
            DescriptiveText(
                text = homePageText,
                modifier = Modifier
                    //      .align(Alignment.TopCenter)
                    .padding(top = 30.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
        }



        item {

            Column(
                //  modifier = Modifier.align(Alignment.Center)
            ) {
                InputTextField(
                    textVal = nativeLang.value,
                    languageType = nativeLangLabel,
                    onValueChange = { nativeLang.value = it }
                )

                InputTextField(
                    textVal = foreignLang.value,
                    languageType = foreignLangLabel,
                    onValueChange = { foreignLang.value = it }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

        }
        item{
            ActionButton(
                //    modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    insertNative(nativeLang.value)
                    insertForeign(foreignLang.value)
                    navController.navigate(Screen.AddVocab.route)
                },
                //makes sure button is only clickable if there are values in the text fields
                enabled = nativeLang.value.isNotBlank() && foreignLang.value.isNotBlank(),
                text = stringResource(R.string.home_page_button)
            )

            //Spacer(modifier = Modifier.height(20.dp))
        }

    }

}





@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    AssignmentTemplateTheme(dynamicColor = false) {
        HomeScreenTopLevel(navController)
    }
}

