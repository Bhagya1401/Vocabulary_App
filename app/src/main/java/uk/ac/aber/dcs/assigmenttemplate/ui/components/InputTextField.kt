package uk.ac.aber.dcs.assigmenttemplate.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(modifier: Modifier = Modifier,
                   textVal: String = "",
                   onValueChange : (String) -> Unit = {},
                   languageType : String
){
    //  val textVal = rememberSaveable{mutableStateOf("")}

    OutlinedTextField(
        value = textVal,
        label = {
            Text(languageType, fontSize = 18.sp,textAlign = TextAlign.Center)
        },
        onValueChange = onValueChange,
        modifier = modifier
    )
}