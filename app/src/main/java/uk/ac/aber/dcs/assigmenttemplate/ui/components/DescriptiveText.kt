package uk.ac.aber.dcs.assigmenttemplate.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptiveText(
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(90.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = modifier.padding(start = 8.dp, end = 8.dp, top = 20.dp)
    ) {
        Text(text, Modifier.padding(all = 20.dp), textAlign = TextAlign.Center, fontSize = 25.sp)
    }
}