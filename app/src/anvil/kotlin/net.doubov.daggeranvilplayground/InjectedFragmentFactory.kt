package net.doubov.daggeranvilplayground

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.collections.get
//import dev.zacsweers.metro.Inject
//import dev.zacsweers.metro.MapKey
//import dev.zacsweers.metro.Provider
import kotlin.reflect.KClass


@MapKey
annotation class FragmentKey(val clazz: KClass<out Fragment>)

class InjectedFragmentFactory @Inject constructor(
    private val fragmentProviderMap: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val clazz = classLoader.loadClass(className)
        return fragmentProviderMap[clazz]!!.get()
    }
}