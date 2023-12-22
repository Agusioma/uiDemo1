package com.tcreatesllc.uidemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tcreatesllc.uidemo1.ui.theme.UiDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiDemo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)
                            .background(color = MaterialTheme.colorScheme.background),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        topButtonsRow()
                        titleRow()
                        shoeImageRow()
                        priceOptionsRow()
                        chipRow()
                    }

                }
            }
        }
    }
}

@Composable
fun topButtonsRow() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        topButton(drawableIconInt = R.drawable.round_arrow_back_24)
        Spacer(modifier = Modifier.weight(3F))
        topButton(drawableIconInt = R.drawable.heart_shape_svgrepo_com)
    }
}

@Composable
fun titleRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        Column {
            Text(
                text = "Runfalcon",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "sneakers",
                fontSize = 30.sp
            )
        }

    }
}

@Composable
fun shoeImageRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.shoe),
            contentDescription = "Shoe"
        )
    }
}

@Composable
fun chipRow() {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        var basePrice = 38.5
        items(6) {index ->
            AssistChip(
                onClick = { /* Do something! */ },
                modifier = Modifier.padding(end = 5.dp),
                label = { Text("${basePrice + (index*2)}") },
                )
        }

    }
}
@Composable
fun priceOptionsRow() {
    var state by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    ) {
        Column {
            Text(
                text = "PRICE:",
                fontSize = 10.sp
            )
            Text(
                text = "$276",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Spacer(modifier = Modifier.weight(3F))

        Column {
            Text(
                text = "COLORS:",
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                IconToggleButton(checked = state,
                    colors =
                        if (state) {
                            IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.White)
                        } else {
                            IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.Transparent)
                        }
                    ,
                    modifier = Modifier.size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description"
                    )
                }

                IconToggleButton(checked = !state,
                    colors =
                    if (state) {
                        IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.White)
                    } else {
                        IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.Transparent)
                    }
                    ,
                    modifier = Modifier.size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description"
                    )
                }

                IconToggleButton(checked = !state,
                    colors =
                    if (state) {
                        IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.White)
                    } else {
                        IconButtonDefaults.iconToggleButtonColors( checkedContainerColor = Color.Transparent)
                    }
                    ,
                    modifier = Modifier.size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description"
                    )
                }
            }

        }

    }
}

@Composable
fun topButton(drawableIconInt: Int) {
    FloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = RoundedCornerShape(percent = 45)
            )
            .width(30.dp)
            .height(45.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Icon(
            painter = painterResource(drawableIconInt),
            contentDescription = "Top icon"
        )
    }
}
