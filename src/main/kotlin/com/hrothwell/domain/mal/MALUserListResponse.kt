package com.hrothwell.domain.mal

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MALUserListResponse(
  val data: List<Data>
)