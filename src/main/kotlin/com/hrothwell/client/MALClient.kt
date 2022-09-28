package com.hrothwell.client

import com.hrothwell.domain.mal.MALUserListResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("\${backends.mal.base-url}")
@Headers(
  Header(name = "X-MAL-CLIENT-ID", value = "\${backends.mal.client-id}")
)
interface MALClient {

  @Get("\${backends.mal.user-list}")
  suspend fun getList(
    user: String,
    @QueryValue status: String? = null,
    @QueryValue limit: Int? = 1000,
    @QueryValue fields: List<String>? = null
  ): MALUserListResponse
}