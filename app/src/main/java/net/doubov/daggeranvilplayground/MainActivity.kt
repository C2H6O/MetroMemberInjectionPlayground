package net.doubov.daggeranvilplayground

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
import dev.zacsweers.metro.createGraphFactory
import net.doubov.daggeranvilplayground.di.AppComponent
import net.doubov.daggeranvilplayground.di.MemberInjectionJavaFragment
import net.doubov.daggeranvilplayground.di.MemberInjectionKotlinFragment
import net.doubov.daggeranvilplayground.ui.theme.DaggerAnvilPlaygroundTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appComponent = createGraphFactory<AppComponent.Factory>()
            .create(application)

        val memberInjectionKotlinFragment = MemberInjectionKotlinFragment()
        appComponent.inject(memberInjectionKotlinFragment)
        memberInjectionKotlinFragment.ensureResourcesNonNull()

        val memberInjectionJavaFragment = MemberInjectionJavaFragment()
        appComponent.inject(memberInjectionJavaFragment)
        memberInjectionJavaFragment.ensureResourcesNotNull()

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