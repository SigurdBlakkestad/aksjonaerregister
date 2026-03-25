package no.sigurd.aksjonaerregister.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "aksjonaerer")
class Aksjonaer (
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val navn: String,

    @Column(unique = true)
    val foedselsnummer: String,

    @OneToMany(mappedBy = "aksjonaer")
    var transaksjoner: MutableSet<Transaksjon> = mutableSetOf(),
)