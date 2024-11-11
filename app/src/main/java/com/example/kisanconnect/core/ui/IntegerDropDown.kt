package com.example.kisanconnect.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IntegerRangeDropdown(
    initialText:String,
    start: Int,
    end: Int,
    onItemSelected: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
        // TextField with dropdown icon
        OutlinedTextField(
            value = selectedValue?.toString() ?: "",
            onValueChange = { /* TextField is read-only */ },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            readOnly = true,
            label = { Text(initialText) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            colors = OutlinedTextFieldDefaults. colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            )
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (i in start..end) {
                DropdownMenuItem(
                    text = { Text(text = i.toString()) },
                    onClick = {
                        selectedValue = i
                        expanded = false
                        onItemSelected(i)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun IntegerRangeDropdownPreview() {
    IntegerRangeDropdown(
        initialText = "Choose Quantity",
        start = 1,
        end = 10
    ) { selectedValue ->
        println("Selected integer: $selectedValue")
    }
}
