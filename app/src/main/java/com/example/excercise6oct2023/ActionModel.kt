import android.content.Context
import android.net.Uri
import android.widget.VideoView
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.example.excercise6oct2023.R

class ActionModel(private val navController: NavHostController, private val context: Context): ViewModel() {
    val localVideoPath = "android.resource://${context.packageName}/${R.raw.leo_trailer}"
    var onlineVideoUri = mutableStateOf("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
    var isOnlinePlayback = mutableStateOf<Boolean>(false)
}

//http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4



class ActionModelFactory(private val navController: NavHostController, private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActionModel::class.java)) {
            return ActionModel(navController, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}