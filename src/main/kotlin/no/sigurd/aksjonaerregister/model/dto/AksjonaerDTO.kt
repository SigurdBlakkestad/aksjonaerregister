package no.sigurd.aksjonaerregister.model.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AksjonaerDTO(
    @field:NotBlank(message = "Navn kan ikke være tomt")
    val navn: String,

    @field:NotBlank(message = "Fødselsnummer kan ikke være tomt")
    @field:Size(min = 11, max = 11, message = "Fødselsnummer må være 11 tegn")
    val foedselsnummer: String,
)