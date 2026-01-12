package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import net.doubov.daggeranvilplayground.MainActivity

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    val resource: Resources

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

@Module
object AppModule{

    @Provides
    fun provideResources(application: Application): Resources = application.resources

}