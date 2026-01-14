package net.doubov.daggeranvilplayground.di

import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesMultibinding
import net.doubov.daggeranvilplayground.FragmentKey
import javax.inject.Inject

//import dev.zacsweers.metro.Inject

//@ContributesIntoMap(scope = ActivityScope::class, binding = binding<Fragment>())
@FragmentKey(FragmentB::class)
@ContributesMultibinding(ActivityScope::class, Fragment::class)
class FragmentB @Inject constructor() : Fragment(), Greeter {
    override fun greet() {
        println("LX+++ FRAG B")
    }
}