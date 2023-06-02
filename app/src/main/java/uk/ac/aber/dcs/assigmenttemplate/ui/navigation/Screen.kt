package uk.ac.aber.dcs.assigmenttemplate.ui.navigation
/**
 * Wraps as objects, singletons for each screen used in
 * navigation. Each has a unique route.
 * @param route To pass through the route string
 * @author Chris Loftus
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object TestTwo : Screen("quick fire test")
    object TestOne : Screen("spelling test")
    object AddVocab : Screen("add")
    object VocabList : Screen("vocabulary")
}

/**
 * List of top-level screens provided as a convenience.
 */
val screens = listOf(
   // Screen.Home,
    Screen.AddVocab,
    Screen.VocabList,
    Screen.TestOne,
    Screen.TestTwo
)