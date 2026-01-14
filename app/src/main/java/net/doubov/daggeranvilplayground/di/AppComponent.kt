package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance

@AppScope
@MergeComponent(AppScope::class)
interface AppComponent {

    val resource: Resources

    val environmentFactory: EnvironmentComponent.Factory

    @MergeComponent.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}