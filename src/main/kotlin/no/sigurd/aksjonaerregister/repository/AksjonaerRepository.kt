package no.sigurd.aksjonaerregister.repository

import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface AksjonaerRepository : JpaRepository<Aksjonaer, UUID> {
    fun findByFoedselsnummer(foedselsnummer: String): Optional<Aksjonaer>
}