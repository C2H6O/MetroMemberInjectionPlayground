package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dev.zacsweers.metro.DependencyGraph
import net.doubov.daggeranvilplayground.MainActivity

@AppScope
@MergeComponent(AppScope::class)
interface AppComponent {

    val resource: Resources

    fun inject(fragment: MemberInjectionJavaFragment)
    fun inject(fragment: MemberInjectionKotlinFragment)

    @DependencyGraph.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}