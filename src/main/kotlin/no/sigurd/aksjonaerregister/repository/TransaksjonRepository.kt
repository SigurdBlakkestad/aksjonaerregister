package no.sigurd.aksjonaerregister.repository

import no.sigurd.aksjonaerregister.model.entity.Transaksjon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransaksjonRepository : JpaRepository<Transaksjon, UUID> {
    fun findByAksjonaerFoedselsnummer(foedselsnummer: String): List<Transaksjon>
}