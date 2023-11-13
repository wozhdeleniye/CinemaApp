package com.example.filmushits.view.custom_function

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.filmushits.R


fun textColor(
    selected:Boolean
): Color{
    if(selected) return Color(0xFF404040)
    else return Color(0xFF909499)
}

@Composable
fun CustomRadioButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(Modifier.padding(2.dp)
        .clickable(onClick = onClick)
        .fillMaxWidth(if (text == "Мужчина") 0.5f
        else 1f)
        .background(
            if (selected) Color(0xFFFFFFFF)
            else Color.Transparent,
            shape = RoundedCornerShape(size = 7.dp)
        ),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 8.dp, top = 11.dp, end = 8.dp, bottom = 11.dp),

            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                color = textColor(selected),
                textAlign = TextAlign.Center,
            )
        )
    }
}



@Composable
fun CustomRadioGroup(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)

    ) {
        options.forEach { option ->
            CustomRadioButton(
                text = option,
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}


@Composable
fun RadioButtonWithoutCircle() {
    var selectedOption by remember { mutableStateOf<String?>("Мужчина") }
    val options = listOf("Мужчина", "Женщина")

    CustomRadioGroup(
        options = options,
        selectedOption = selectedOption,
        onOptionSelected = { option -> selectedOption = option }
    )
}


@Composable
fun MyScreen() {
    RadioButtonWithoutCircle()
}
