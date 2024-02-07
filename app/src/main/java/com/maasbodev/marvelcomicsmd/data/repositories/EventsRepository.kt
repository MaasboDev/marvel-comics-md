package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.Result
import com.maasbodev.marvelcomicsmd.data.network.remote.EventsService
import com.maasbodev.marvelcomicsmd.domain.entities.Event
import javax.inject.Inject

class EventsRepository @Inject constructor(private val service: EventsService) :
    Repository<Event>() {

    suspend fun get(): Result<List<Event>> = super.get {
        service
            .getEvents(0, 100)
            .data
            .results
            .map { it.asEvent() }
    }

    suspend fun find(id: Int): Result<Event> = super.find(
        id,
        findActionRemote = {
            service
                .findEvent(id)
                .data
                .results
                .first()
                .asEvent()
        }
    )
}
