package net.doubov.daggeranvilplayground.di

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
object AppModule{

    @Provides
    fun provideResources(application: Application): Resources = application.resources

}