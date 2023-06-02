package uk.ac.aber.dcs.assigmenttemplate

//Screen.ktimport android.os.Bundle
//import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.assigmenttemplate.model.VocabAppViewModel
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.add_vocab.AddVocabScreenTopLevel
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.home.HomeScreenTopLevel
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.multiple_choice.QuickFireTopLevel
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.Screen
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.spelling_test.SpellingTestTopLevel
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme
import uk.ac.aber.dcs.assigmenttemplate.ui.screens.vocab_list.VocabListScreenTopLevel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildNavigationGraph()
                }
            }
        }
    }
}


@Composable
fun BuildNavigationGraph(
    vocabViewModel: VocabAppViewModel = viewModel())
{
    val navController = rememberNavController()

    val startDestination = remember {Screen.Home.route}

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) { HomeScreenTopLevel(navController,vocabViewModel) }
        composable(Screen.AddVocab.route) { AddVocabScreenTopLevel(navController,vocabViewModel) }
        composable(Screen.VocabList.route) { VocabListScreenTopLevel(navController,vocabViewModel) }
        composable(Screen.TestOne.route) { SpellingTestTopLevel(navController,vocabViewModel) }
        composable(Screen.TestTwo.route) { QuickFireTopLevel(navController,vocabViewModel) }

        //need a scaffold for posistioning
        //page navigation bar, main page navigation in faa
        //add top app bar using scaffold
        //

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AssignmentTemplateTheme(dynamicColor = false) {
        BuildNavigationGraph()
    }
}

