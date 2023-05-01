package com.example.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learn.model.Topic
import com.example.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun TopicGridItem(topic : Topic, modifier: Modifier = Modifier){


    Card(modifier = modifier
        .padding(8.dp)
        .background(Color.Transparent)){
        Row(modifier = Modifier
            .height(68.dp)) {
                Image(
                    painter = painterResource(id = topic.imageId),
                    contentDescription = stringResource(id = topic.stringId),
                    modifier = Modifier.width(68.dp),
                    contentScale = ContentScale.Crop
                )
                Column{
                    Text(
                        text = stringResource(id = topic.stringId),
                        modifier = Modifier.padding(16.dp,16.dp,16.dp,8.dp),
                        style = MaterialTheme.typography.bodyMedium

                    )
                    Row(modifier = Modifier.padding(16.dp,0.dp)) {
                        Image(painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = "number of topics",
                            modifier = Modifier.height(16.dp)

                        )
                        Text(
                            text = topic.numberOfLessons.toString(),
                            modifier = Modifier.padding(8.dp,0.dp),
                            style = MaterialTheme.typography.bodySmall

                        )
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicGridItemPreview() {
    LearnTheme {
        TopicGridItem(Topic(imageId = R.drawable.architecture,
            stringId = R.string.architecture,
            numberOfLessons = 100))
    }
}