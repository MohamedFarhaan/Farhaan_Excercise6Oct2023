package com.example.excercise6oct2023.screens

import ActionModel
import ActionModelFactory
import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.excercise6oct2023.ui.theme.Excercise6Oct2023Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(actionModel: ActionModel) {
    Column (modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        var videoView by remember { mutableStateOf<VideoView>(VideoView(context)) }
        var videoView2 by remember { mutableStateOf<VideoView>(VideoView(context)) }

        if(actionModel.isOnlinePlayback.value) {
            AndroidView(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f),
                factory = {
                    videoView2.apply {
                        setVideoURI(Uri.parse(actionModel.onlineVideoUri.value))
                        start()
                        setOnPreparedListener { mp ->
                            mp.isLooping = true // You can set looping or other configurations here
                        }
                    }
                },
                update = {
                    videoView2 = it
                }
            )
        } else {
            AndroidView(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f),
                factory = {
                    videoView.apply {
                        setVideoPath(actionModel.localVideoPath)
                        start()
                        setOnPreparedListener { mp ->
                            mp.isLooping = true // You can set looping or other configurations here
                        }
                    }
                },
                update = {
                    videoView = it
                }
            )
        }
        Button(onClick = {  videoView2.suspend(); actionModel.isOnlinePlayback.value = false }) {
            Text(text = "Play video from RAW source")
        }
        TextField(value = actionModel.onlineVideoUri.value, onValueChange = {
            actionModel.onlineVideoUri.value = it
        })
        Button(onClick = { videoView.suspend(); actionModel.isOnlinePlayback.value = true }) {
            Text(text = "Play video from URi source")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Excercise6Oct2023Theme {
        val context = LocalContext.current
        HomeScreen(viewModel(factory = ActionModelFactory(rememberNavController(), context)))
    }
}