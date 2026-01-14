package net.doubov.daggeranvilplayground.di

import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesMultibinding
import net.doubov.daggeranvilplayground.FragmentKey
import net.doubov.daggeranvilplayground.MeetingsNavigator
import javax.inject.Inject

//@ContributesIntoMap(scope = ActivityScope::class, binding = binding<Fragment>())
@FragmentKey(FragmentA::class)
@ContributesMultibinding(ActivityScope::class, Fragment::class)
class FragmentA @Inject constructor(
    private val meetingsNavigator: MeetingsNavigator,
) : Fragment(), Greeter {
    override fun greet() {
        println("LX+++ FRAG A $meetingsNavigator")
    }
}