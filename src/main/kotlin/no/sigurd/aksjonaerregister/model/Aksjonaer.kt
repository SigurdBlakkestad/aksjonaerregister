package no.sigurd.aksjonaerregister.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import java.util.UUID

@Entity
class Aksjonaer (
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val navn: String,

    @Column(unique = true)
    val foedselsnummer: String
)