package net.doubov.daggeranvilplayground

import com.squareup.anvil.annotations.ContributesBinding
import net.doubov.daggeranvilplayground.di.ActivityScope
import net.doubov.daggeranvilplayground.di.EnvironmentScope
import net.doubov.daggeranvilplayground.di.SheetFilterLbsConsumerRepository
import javax.inject.Inject

interface LocationConsumerRepository {

    fun getListOfSavedLocations(entityUid: String): List<String>

}

class SheetLocationConsumerRepository @Inject constructor() : LocationConsumerRepository {
    override fun getListOfSavedLocations(entityUid: String): List<String> {
        return listOf("LX+++", "HELLO", "WORLD", entityUid)
    }
}