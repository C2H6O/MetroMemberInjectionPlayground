package net.doubov.daggeranvilplayground

import javax.inject.Inject

interface LocationConsumerRepository {

    fun getListOfSavedLocations(entityUid: String): List<String>

}

class SheetLocationConsumerRepository @Inject constructor() : LocationConsumerRepository {
    override fun getListOfSavedLocations(entityUid: String): List<String> {
        return listOf("LX+++", "HELLO", "WORLD", entityUid)
    }
}