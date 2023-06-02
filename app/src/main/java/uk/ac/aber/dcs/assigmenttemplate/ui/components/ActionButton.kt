package uk.ac.aber.dcs.assigmenttemplate.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean,
    text:String
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(bottom = 10.dp),
        enabled = enabled
    ) {

        Text(text, fontSize = 22.sp)
    }

}