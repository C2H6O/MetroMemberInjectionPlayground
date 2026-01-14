package net.doubov.daggeranvilplayground

import com.squareup.anvil.annotations.ContributesBinding
import net.doubov.daggeranvilplayground.di.ActivityScope
import javax.inject.Inject

@ContributesBinding(ActivityScope::class)
class MeetingsNavigatorImpl @Inject constructor() : MeetingsNavigator {

    override fun openMeetingItemAsReference() {
        println("LX+++ openMeetingItemAsReference!")
    }
}