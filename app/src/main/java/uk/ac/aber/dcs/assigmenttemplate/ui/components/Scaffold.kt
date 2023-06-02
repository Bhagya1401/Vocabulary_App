package uk.ac.aber.dcs.assigmenttemplate.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.assigmenttemplate.ui.navigation.MainPageNavigationBar
import kotlin.properties.Delegates

//import uk.ac.aber.dcs.assigmenttemplate.ui.navigation

private const val KEY_ROUTE = "route"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevelScaffold(
    navController: NavHostController,
    title: String,
    pageContent: @Composable (innerPadding: PaddingValues) -> Unit = {}

) {
    //Stores the current route
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = { TopAppBar(title) },

        bottomBar = {

            //the bottom navigation bar should not be shown on the home screen
            //the if statement handles that behaviour
            if (currentRoute != "home"){
                MainPageNavigationBar(navController)}
        },
        content = { innerPadding ->
            pageContent(innerPadding)
        }
    )
}

//@Composable
//public fun currentRoute(navController: NavHostController): String? {
////    val currentRoute: String?
////        get() = navController.currentDestination?.route
////    return currentRoute
//}