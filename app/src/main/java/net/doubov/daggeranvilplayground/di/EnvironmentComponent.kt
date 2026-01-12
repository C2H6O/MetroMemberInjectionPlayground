package net.doubov.daggeranvilplayground.di

import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent
import net.doubov.daggeranvilplayground.MainActivity

@EnvironmentScope
@MergeSubcomponent(EnvironmentScope::class)
interface EnvironmentComponent {

    val environment: Environment

    fun inject(activity: MainActivity)

    @MergeSubcomponent.Factory
    interface Factory {
        fun create(@BindsInstance environment: Environment): EnvironmentComponent
    }
}