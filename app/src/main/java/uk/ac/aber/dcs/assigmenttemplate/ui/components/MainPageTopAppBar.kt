package uk.ac.aber.dcs.assigmenttemplate.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uk.ac.aber.dcs.assigmenttemplate.ui.theme.AssignmentTemplateTheme


/**
 * Represents a top app bar component using M3 CenterAlignedTopAppBar.
 * Has a menu button icon and the app name.
 * @param onClick: provides the behaviour for the menu icon or
 * an empty lambda if not provided.
 * @author Chris Loftus
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,

){
    CenterAlignedTopAppBar(
        title = { Text(title, fontSize = 30.sp) },
        // An example of changing the default colours
        /*colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),*/

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MainPageTopAppBarPreview() {
    AssignmentTemplateTheme(dynamicColor = false) {
        TopAppBar("Top App Bar")
    }
}