package com.example.mycodeweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.mycodeweek1.ui.theme.MyCodeWeek1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCodeWeek1Theme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World", "Compose")) {
//    Column {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(/* TODO */)
    } else {
        Greetings()
    }
}

// 화면B
@Composable
private fun Greetings(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCodeWeek1Theme {
        MyApp()
    }
}

// 화면A
@Composable
fun OnboardingScreen() {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { shouldShowOnboarding = false }
            ) {
                Text("Continue")
            }
        }
    }
}


data class Message(val author: String, val body: String)

//@PreviewParameter(Message::class)
@Composable
fun MessageCard(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}
@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f).padding(extraPadding)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }

        }
    }
}
