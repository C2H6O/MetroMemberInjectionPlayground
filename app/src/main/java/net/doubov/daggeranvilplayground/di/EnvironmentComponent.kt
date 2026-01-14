package net.doubov.daggeranvilplayground.di

import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
//import dev.zacsweers.metro.GraphExtension
import net.doubov.daggeranvilplayground.LocationConsumerRepository
import net.doubov.daggeranvilplayground.SheetLocationConsumerRepository
import javax.inject.Named

@EnvironmentScope
@MergeSubcomponent(EnvironmentScope::class)
interface EnvironmentComponent {

    val environment: Environment

    val activityFactory: ActivityComponent.Factory

//    @GraphExtension.Factory
    @MergeSubcomponent.Factory
    interface Factory {
        fun create(@BindsInstance environment: Environment): EnvironmentComponent
    }

    @ContributesTo(EnvironmentScope::class)
    @Module
    interface EnvironmentScopeBindings {
        @Binds
        @SheetFilterLbsConsumerRepository
        fun bindSheetFilterLbsRepository(repository: SheetLocationConsumerRepository): LocationConsumerRepository
    }
}
