package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    val resource: Resources

    val environmentFactory: EnvironmentComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}