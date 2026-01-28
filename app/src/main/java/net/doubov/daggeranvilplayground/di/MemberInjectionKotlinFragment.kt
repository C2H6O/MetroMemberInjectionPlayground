package net.doubov.daggeranvilplayground.di

import android.content.res.Resources
import javax.inject.Inject

class MemberInjectionKotlinFragment {

    @Inject
    lateinit var resources: Resources

    fun ensureResourcesNonNull() {
        System.out.println("LX+++ resources asset manager: " + resources.getAssets())

    }

}