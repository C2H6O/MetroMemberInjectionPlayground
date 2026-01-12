package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object AppModule{

    @Provides
    fun provideResources(application: Application): Resources = application.resources

}