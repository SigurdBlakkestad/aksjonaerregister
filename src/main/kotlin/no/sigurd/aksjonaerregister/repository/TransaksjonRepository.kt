package no.sigurd.aksjonaerregister.repository

import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import no.sigurd.aksjonaerregister.model.entity.Transaksjon
import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.List
import java.util.UUID

@Repository
interface TransaksjonRepository : JpaRepository<Transaksjon, UUID> {
    fun findByAksjonerFoedselsnuummer(foedselsnummer: String): List<Transaksjon>
    fun findByAksjonaerFoedselsnummer(aksjonaerFoedselsnummer: String): MutableList<Transaksjon>
}