package no.sigurd.aksjonaerregister.service

import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import org.springframework.stereotype.Service
import no.sigurd.aksjonaerregister.repository.AksjonaerRepository

@Service
class AksjonaerService( private val aksjonaerRepository: AksjonaerRepository ) {
    fun nyAksjonaer(aksjonaer: Aksjonaer): Aksjonaer {
        return aksjonaerRepository.save(aksjonaer)
    }
    fun hentAksjonaer(foedselsnummer: String): Aksjonaer? {
        return aksjonaerRepository.findByFoedselsnummer(foedselsnummer).orElseThrow { Exception("Fant ikke aksjonær med fødselsnummer: $foedselsnummer") }
    }
}