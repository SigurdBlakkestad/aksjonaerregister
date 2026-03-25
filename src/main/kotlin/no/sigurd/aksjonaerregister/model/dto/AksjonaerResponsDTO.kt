package no.sigurd.aksjonaerregister.model.dto

import java.util.UUID

data class AksjonaerResponsDTO(
    val id: UUID?,
    val navn: String,
    val foedselsnummer: String
)