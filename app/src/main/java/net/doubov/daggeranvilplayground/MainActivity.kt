package net.doubov.daggeranvilplayground

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.doubov.daggeranvilplayground.di.DaggerAppComponent
import net.doubov.daggeranvilplayground.ui.theme.DaggerAnvilPlaygroundTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var injectedResources: Resources

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DaggerAppComponent.factory().create(application).inject(this)

        println("LX+++ resources $injectedResources")

        setContent {
            DaggerAnvilPlaygroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerAnvilPlaygroundTheme {
        Greeting("Android")
    }
}