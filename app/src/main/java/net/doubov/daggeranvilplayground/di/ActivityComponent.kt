package net.doubov.daggeranvilplayground.di

import android.content.res.Resources
import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dev.zacsweers.metro.GraphExtension
import net.doubov.daggeranvilplayground.FragmentKey
import net.doubov.daggeranvilplayground.MainActivity

@ActivityScope
@MergeSubcomponent(ActivityScope::class)
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @GraphExtension.Factory
    @MergeSubcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    @Module
    @ContributesTo(ActivityScope::class)
    object ActivityModule {
        @Provides
        fun provideJavaFragment(resources: Resources): JavaFragment {
            return JavaFragment(resources)
        }
    }

    @Module
    @ContributesTo(ActivityScope::class)
    interface JavaFragmentBindings {
        @Binds
        @IntoMap
        @FragmentKey(JavaFragment::class)
        fun bindJavaFragment(javaFragment: JavaFragment): Fragment
    }

}