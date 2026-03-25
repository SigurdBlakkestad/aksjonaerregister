package no.sigurd.aksjonaerregister.model.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import java.math.BigDecimal
import java.time.LocalDate

data class TransaksjonsRequestDTO(
    val aksjenavn: String,
    val transaksjonType: TransaksjonType,

    @field:NotNull(message = "Antall trenger et gyldig tall ")
    @field:Min(0)
    val antall: Int,
    val prisPerAksje: BigDecimal,
    val dato: LocalDate
)
