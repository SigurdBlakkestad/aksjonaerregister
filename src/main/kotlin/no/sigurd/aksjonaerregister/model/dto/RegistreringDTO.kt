package no.sigurd.aksjonaerregister.model.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class RegistreringDTO
constructor(
    @field:NotBlank(message = "Fornavn kan ikke være null")
    @field:NotEmpty("Fornavn kan ikke være tomt")
    var fornavn: String?,
    @field:NotBlank(message = "Etternavn kan ikke være null")
    @field:NotEmpty("Etternavn kan ikke være tomt")
    var ettervnavn: String?,
    @field:NotBlank(message = "Fødselsnummer kan ikke være null")
    @field:NotEmpty("Fødsnlsnummer kan ikke være tomt")
    val fnr: String,
    @field:NotBlank(message = "Email kan ikke være null")
    @field:NotEmpty("Email kan ikke være tomt")
    var email: String?,
    @field:NotBlank(message = "Passord kan ikke være null")
    @field:Size(min = 4, max = 64, message = "Passord må være mellom 4 og 64 karakterer")
    @field:NotEmpty("Passord kan ikke være tomt")
    var passord: String?,
    @field:NotBlank(message = "Alder kan ikke være null og må være lengre enn 0")
    @field:Min(13, message = "Du må være minst 13 for å kunne lage bruker")
    @field:Max(120, message = "Bruh")
    @field:NotEmpty("Alder kan ikke være tomt")
    var alder: Int,
)