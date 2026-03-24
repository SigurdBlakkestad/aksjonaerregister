package no.sigurd.aksjonaerregister.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class Transaksjon(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "aksjonaer_id", nullable = false)
    val aksjonaer: Aksjonaer,
    val aksjenavn: String,

    @Enumerated(EnumType.STRING)
    val type: TransaksjonType,
    val antall: Int,
    val prisPerAksje: BigDecimal,
    val dato: LocalDate,
)
