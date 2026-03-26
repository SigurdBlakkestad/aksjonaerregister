package no.sigurd.aksjonaerregister.model.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import java.math.BigDecimal
import java.time.LocalDate

data class TransaksjonsRequestDTO(
    @field:NotBlank(message = "Aksjenavn kan ikke være tomt")
    val aksjenavn: String,
    val transaksjonType: TransaksjonType,

    @field:Min(value = 1, message = "Antall må være minst 1")
    val antall: Int,
    val prisPerAksje: BigDecimal,
    val dato: LocalDate
)
