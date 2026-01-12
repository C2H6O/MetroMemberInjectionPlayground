package net.doubov.daggeranvilplayground.di

import dagger.BindsInstance
import dagger.Subcomponent
import net.doubov.daggeranvilplayground.MainActivity

@EnvironmentScope
@Subcomponent
interface EnvironmentComponent {

    val environment: Environment

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance environment: Environment): EnvironmentComponent
    }
}