package com.hrothwell.controller

import com.hrothwell.domain.mal.Data
import com.hrothwell.domain.mal.ListStatus
import com.hrothwell.service.MALService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import kotlinx.coroutines.coroutineScope

@Controller("/rat")
class RandomizerController(
  private val malService: MALService
) {

  @Get("/{user}/anime/{listStatus}")
  suspend fun getRandomAnime(
    @PathVariable user: String,
    @PathVariable listStatus: ListStatus
  ): Data = coroutineScope{
    malService.getRandomAnime(user, listStatus)
  }
}