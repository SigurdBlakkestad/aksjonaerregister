package no.sigurd.aksjonaerregister.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "transaksjoner")
class Transaksjon(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "aksjonaer_id", nullable = false)
    var aksjonaer: Aksjonaer,
    val aksjenavn: String,

    @Enumerated(EnumType.STRING)
    val transaksjonType: TransaksjonType,

    @Min(0)
    val antall: Int,
    val prisPerAksje: BigDecimal,
    val dato: LocalDate,
)