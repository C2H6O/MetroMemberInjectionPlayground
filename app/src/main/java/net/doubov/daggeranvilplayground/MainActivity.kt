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
//import dev.zacsweers.metro.createGraphFactory
import net.doubov.daggeranvilplayground.di.AppComponent
import net.doubov.daggeranvilplayground.di.DaggerAppComponent
import net.doubov.daggeranvilplayground.di.Environment
import net.doubov.daggeranvilplayground.di.FragmentA
import net.doubov.daggeranvilplayground.di.FragmentB
import net.doubov.daggeranvilplayground.di.Greeter
import net.doubov.daggeranvilplayground.di.JavaFragment
import net.doubov.daggeranvilplayground.di.SheetFilterLbsConsumerRepository
import net.doubov.daggeranvilplayground.ui.theme.DaggerAnvilPlaygroundTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var injectedResources: Resources

    @Inject
    lateinit var environment: Environment

    @Inject
    lateinit var fragmentFactory: InjectedFragmentFactory

    @Inject
    lateinit var injectedFragmentFactory: InjectedFragmentFactory

    @Inject
    lateinit var meetingsNavigator: MeetingsNavigator

    @Inject
    @SheetFilterLbsConsumerRepository
    lateinit var sheetFilterLbsRepository: LocationConsumerRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        createGraphFactory<AppComponent.Factory>()
        DaggerAppComponent.factory()
            .create(application)
            .environmentFactory
            .create(Environment("Yuppy!"))
            .activityFactory
            .create()
            .inject(this)

        val fragmentA = fragmentFactory.instantiate(classLoader,FragmentA::class.java.name) as Greeter
        fragmentA.greet()
        val fragmentB = fragmentFactory.instantiate(classLoader,FragmentB::class.java.name) as Greeter
        fragmentB.greet()

        val fragmentJava = fragmentFactory.instantiate(classLoader, JavaFragment::class.java.name) as Greeter
        fragmentJava.greet()

        val fragA = injectedFragmentFactory.instantiate(classLoader, FragmentA::class.java.name)
        println("LX+++ frag A? $fragA")

        println("LX+++ resources $injectedResources $environment")

        meetingsNavigator.openMeetingItemAsReference()

        println("LX+++ ${sheetFilterLbsRepository.getListOfSavedLocations("1337").joinToString()}")

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