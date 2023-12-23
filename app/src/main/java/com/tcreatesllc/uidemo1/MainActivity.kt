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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                            .padding(40.dp)
                            .background(color = MaterialTheme.colorScheme.background),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        topButtonsRow()
                        titleRow()
                        shoeImageRow()
                        priceOptionsRow()
                        chipRow()
                        bottomRow()
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
                color = Color.Black,
                text = "Runfalcon",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                color = Color.Black,
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
        var baseSize = 38.5
        items(6) { index ->

            OutlinedButton(

                onClick = {},
                modifier = Modifier.padding(end = 10.dp).wrapContentWidth(),
                border = BorderStroke(width = 1.dp, color = btnBorderColor(index)),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = btnContainerColor(index),
                    contentColor = Color.Black
                )
            ) {
                Text(
                color = Color.Black,text = "${baseSize + (index * 2)}")
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, bottom = 10.dp)
    ) {
        Card(
            shape = RoundedCornerShape(50),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = "Add to cart",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.weight(3F))
                IconButton(onClick = { /* doSomething() */ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.background,
                        contentColor = Color.Black)
                    ) {
                    Icon(painter = painterResource(id = R.drawable.shopping_bag_5_1_svgrepo_com), contentDescription = "Localized description")
                }
            }
        }
    }
}

fun btnBorderColor(index: Int): Color {

    if (index == 1) {
        return Color.Black
    } else {
        return Color.Transparent
    }
}

fun btnContainerColor(index: Int): Color {

    if (index == 1) {
        return Color.Transparent
    } else {
        return Color.White
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
                color = Color.Black,
                text = "PRICE:",
                fontSize = 12.sp
            )
            Text(
                color = Color.Black,
                text = "$276",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Spacer(modifier = Modifier.weight(2F))

        Column {
            Text(
                color = Color.Black,
                text = "COLORS:",
                fontSize = 12.sp
            )
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                IconToggleButton(checked = state,
                    colors =
                    if (state) {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.White)
                    } else {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.Transparent)
                    },
                    modifier = Modifier
                        .size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description",
                        tint = Color(0xFFea5d5d)
                    )
                }

                IconToggleButton(checked = !state,
                    colors =
                    if (state) {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.White)
                    } else {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.Transparent)
                    },
                    modifier = Modifier.size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description",
                        tint = Color(0xFF000000)
                    )
                }

                IconToggleButton(checked = !state,
                    colors =
                    if (state) {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.White)
                    } else {
                        IconButtonDefaults.iconToggleButtonColors(checkedContainerColor = Color.Transparent)
                    },
                    modifier = Modifier.size(20.dp),
                    onCheckedChange = { state = it }) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_svgrepo_com__1_),
                        contentDescription = "Localized description",
                        tint = Color(0xFFffffff)
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
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color.Black
    ) {
        Icon(
            painter = painterResource(drawableIconInt),
            contentDescription = "Top icon"
        )
    }
}
