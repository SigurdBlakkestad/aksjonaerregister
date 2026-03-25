package no.sigurd.aksjonaerregister.model.dto

import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class TransaksjonResponsDTO(
    val id: UUID?,
    val aksjenavn: String,
    val transaksjonType: TransaksjonType,
    val antall: Int,
    val prisPerAksje: BigDecimal,
    val dato: LocalDate,
    val aksjonaer: AksjonaerResponsDTO
)