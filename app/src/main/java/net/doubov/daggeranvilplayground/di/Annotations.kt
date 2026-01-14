package net.doubov.daggeranvilplayground.di

import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class EnvironmentScope

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SheetFilterLbsConsumerRepository