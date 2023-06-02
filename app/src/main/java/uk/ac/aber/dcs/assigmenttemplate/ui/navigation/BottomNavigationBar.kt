package uk.ac.aber.dcs.assigmenttemplate.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.assigmenttemplate.R
import uk.ac.aber.dcs.assigmenttemplate.ui.components.IconGroup
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme

@Composable
fun MainPageNavigationBar(
    navController: NavController
) {
    val icons = mapOf(
//        Screen.Home to IconGroup(
//            filledIcon = Icons.Filled.Home,
//            outlineIcon = Icons.Outlined.Home,
//            label = stringResource(id = R.string.home)
//        ),
        Screen.VocabList to IconGroup(
            filledIcon = Icons.Filled.MenuBook,
            outlineIcon = Icons.Outlined.MenuBook,
            label = stringResource(id = R.string.vocabList)
        ),
        Screen.AddVocab to IconGroup(
            filledIcon = Icons.Filled.AddCircleOutline,
            outlineIcon = Icons.Outlined.AddCircleOutline,
            label = stringResource(id = R.string.addVocab)
        ),
        Screen.TestOne to IconGroup(
            filledIcon = Icons.Filled.Spellcheck,
            outlineIcon = Icons.Outlined.Spellcheck,
            label = stringResource(id = R.string.spellingTest)
        ),
        Screen.TestTwo to IconGroup(
            filledIcon = Icons.Filled.Speed,
            outlineIcon = Icons.Outlined.Speed,
            label = stringResource(id = R.string.quickFireTest)
        ),


    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screens.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            val labelText = icons[screen]!!.label
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = (if (isSelected)
                            icons[screen]!!.filledIcon
                        else
                            icons[screen]!!.outlineIcon),
                        contentDescription = labelText
                    )
                },
                label = { Text(labelText, fontSize = 8.sp) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun MainPageNavigationBarPreview() {
    val navController = rememberNavController()
    AssignmentTemplateTheme(dynamicColor = false) {
        MainPageNavigationBar(navController)
    }
}