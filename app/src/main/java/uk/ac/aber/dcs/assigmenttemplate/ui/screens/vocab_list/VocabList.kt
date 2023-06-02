package uk.ac.aber.dcs.assigmenttemplate.ui.screens.vocab_list


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.assigmenttemplate.R
import uk.ac.aber.dcs.assigmenttemplate.model.VocabAppViewModel
import uk.ac.aber.dcs.assigmenttemplate.model.Word
import uk.ac.aber.dcs.assigmenttemplate.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme


@Composable
fun VocabListScreenTopLevel(
    navController: NavHostController,
    vocabViewModel: VocabAppViewModel = viewModel()
) {

    val wordList by vocabViewModel.wordList.observeAsState(listOf())

    TopLevelScaffold(navController, stringResource(R.string.vocabList))
    { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            VocabListScreen(
                navController,
                wordList = wordList,
                vocabViewModel.nativeLanguage,
                vocabViewModel.foreignLanguage
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VocabListScreen(navController: NavHostController,
                    wordList: List<Word> = listOf(),
                    nativeLanguage: String,
                    foreignLanguage: String
) {


    //remembers positioning of list
    val state = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state //remembers position in list


    ) {

        stickyHeader {
            Card(
                shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onTertiary)


            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = nativeLanguage,
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .weight(.5f),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center

                    )

                    Text(
                        text = foreignLanguage,
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .weight(.5f),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }


        items(wordList) { word ->
            //               println(word.native)
            //             println("----------")
//                println(word.foreign)
            WordItemCard(word.native, word.foreign)
        }
    }


}


@Composable
fun WordItemCard(native: String, foreign: String) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 10.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = native,
                modifier = Modifier
                    .padding(all = 8.dp)
                    .weight(.5f),
                textAlign = TextAlign.Center
            )


            Text(
                text = foreign,
                modifier = Modifier
                    .padding(all = 8.dp)
                    .weight(.5f),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview
@Composable
fun WordItemCardPreview() {
    AssignmentTemplateTheme {
        WordItemCard("Native", "Foreign")
    }
}

@Preview(showBackground = true)
@Composable
fun AddVocabScreenPreview() {
    val navController = rememberNavController()
    AssignmentTemplateTheme(dynamicColor = false) {
        VocabListScreenTopLevel(navController)
    }
}
/*
Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(30.dp),
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 10.dp, bottom = 10.dp)
                .align(Alignment.Center)
        ) {
            Row (){

                LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                    item { Text(text = "Hi", modifier = Modifier.padding(top = 10.dp, start = 8.dp))}
                    items(100) { index ->
                        Text(text = "First List items : $index", modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp))
                    }
                }

   //            Spacer(modifier = Modifier.width(20.dp).fillMaxHeight())
                Divider(color = Color.Black, modifier = Modifier.width(2.dp).fillMaxHeight())
                LazyColumn( horizontalAlignment = Alignment.CenterHorizontally) {
                    item { Text(text = "Hi", modifier = Modifier.padding(top = 10.dp,start = 8.dp)) }
                    items(100) { index ->
                        Text(text = "First List items : $index",  modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp))
                    }
                }

            }

        }
 */