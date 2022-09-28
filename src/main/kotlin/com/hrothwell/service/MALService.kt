package com.hrothwell.service

import com.hrothwell.client.MALClient
import com.hrothwell.domain.mal.Data
import com.hrothwell.domain.mal.ListStatus
import com.hrothwell.domain.mal.MALUserListResponse
import com.hrothwell.domain.mal.Node
import jakarta.inject.Singleton

@Singleton
class MALService(
  private val malClient: MALClient
) {

  suspend fun getUserList(user: String): MALUserListResponse {
    return malClient.getList(user)
  }
  
  suspend fun getRandomAnime(user: String, listStatus: ListStatus): Data {
    val anime = malClient.getList(user, listStatus.malValue)
    return anime.data.randomOrNull() ?: defaultData
  }

  private val defaultData = Data(
    Node(
      id = 16498,
      title = "Shingeki no Kyojin"
    )
  )
}