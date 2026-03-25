package no.sigurd.aksjonaerregister.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.Date


@Entity
@Table(name = "brukere")
class Bruker {

    @Id
    @GeneratedValue
    var id: Long? = null
    @field:NotBlank(message = "Fornavn er påkrevd")
    @field:NotEmpty(message = "Fornavn kan ikke være tomt")
    var fornavn: String = ""
    @field:NotBlank(message = "Etternavn er påkrevd")
    @field:NotEmpty(message = "Etternavn kan ikke være tomt")
    var etternavn: String = ""
    var email: String = ""
    var passord: String = ""
    var alder : Int = 0

    @CreationTimestamp
    val opprettet: Date? = null

    @UpdateTimestamp
    var oppdatert: Date? = null
}