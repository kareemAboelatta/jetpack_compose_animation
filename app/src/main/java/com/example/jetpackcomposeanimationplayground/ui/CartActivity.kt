package com.example.jetpackcomposeanimationplayground.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeanimationplayground.R
import com.example.jetpackcomposeanimationplayground.ui.theme.accentColor
import com.example.jetpackcomposeanimationplayground.ui.theme.textColor

class CartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.surface) {
                CartComponent()
            }
        }
    }

    companion object {
        fun intent(context: Context) = Intent(context, CartActivity::class.java)
    }

}

@Composable
fun CartComponent() {

    val context = LocalContext.current
    Box {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .padding(16.dp)
                    .rotate(180f)
                    .size(24.dp)
                    .clickable {
                        (context as Activity).finish()
                    }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "My Bag",
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    color = textColor
                )
                Text(
                    text = "Total 3 items",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray.copy(alpha = 0.5f))
            )

            LazyColumn(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                items(CartDataModel.list) {
                    CartItem(it)
                }
                item { Spacer(modifier = Modifier.height(100.dp)) }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.surface)
                .height(120.dp)
        ) {

            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray.copy(alpha = 0.5f))
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "Total",
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "₹1234.00",
                    color = textColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    Toast.makeText(context, "Opening Checkout", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = accentColor)
            ) {
                Text(text = "Go To Checkout", modifier = Modifier.padding(8.dp))
            }
        }
    }

}

@Composable
fun CartItem(cartDataModel: CartDataModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 8.dp, top = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        color = Color.LightGray.copy(alpha = .4f),
                        shape = RoundedCornerShape(30.dp)
                    )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 8.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = cartDataModel.name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = textColor,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = cartDataModel.price,
                    color = textColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_remove),
                        contentDescription = "right arrow",
                        modifier = Modifier
                            .width(40.dp)
                            .height(30.dp)
                            .background(
                                color = Color.LightGray.copy(alpha = .2f),
                                shape = RoundedCornerShape(2.dp)
                            )
                            .padding(4.dp),
                        colorFilter = ColorFilter.tint(textColor.copy(alpha = .8f))
                    )
                    Text(
                        text = "1",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "right arrow",
                        modifier = Modifier
                            .width(40.dp)
                            .height(30.dp)
                            .background(
                                color = Color.LightGray.copy(alpha = .2f),
                                shape = RoundedCornerShape(2.dp)
                            )
                            .padding(4.dp),
                        colorFilter = ColorFilter.tint(textColor.copy(alpha = .8f))
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = cartDataModel.image),
            contentDescription = "bag",
            modifier = Modifier
                .size(150.dp)
                .rotate(20f)
                .offset(x = (-25).dp, y = (-15).dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview_CartActivity() {
    CartComponent()
}