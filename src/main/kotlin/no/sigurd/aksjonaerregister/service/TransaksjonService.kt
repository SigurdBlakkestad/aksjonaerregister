package no.sigurd.aksjonaerregister.service

import jakarta.transaction.Transactional
import no.sigurd.aksjonaerregister.model.dto.TransaksjonsRequestDTO
import no.sigurd.aksjonaerregister.model.entity.Transaksjon
import no.sigurd.aksjonaerregister.repository.AksjonaerRepository
import no.sigurd.aksjonaerregister.repository.TransaksjonRepository
import org.springframework.stereotype.Service

@Service
class TransaksjonService(
    private val transaksjonRepository: TransaksjonRepository,
    private val aksjonaerRepository: AksjonaerRepository,
    ) {
        @Transactional
    fun registrerTransakjson(foedselsnummer: String, request: TransaksjonsRequestDTO): Transaksjon {
        val aksjonaer = aksjonaerRepository.findByFoedselsnummer(foedselsnummer).orElseThrow { Exception("Fant ikke aksjonær med $foedselsnummer") }

        val transaksjon = Transaksjon(
            aksjonaer = aksjonaer,
            aksjenavn = request.aksjenavn,
            transaksjonType = request.transaksjonType,
            antall = request.antall,
            prisPerAksje = request.prisPerAksje,
            dato = request.dato,
        )
        return transaksjonRepository.save(transaksjon)
    }
    fun hentTransaksjonerForAksjonaer(foedselsnummer: String): List<Transaksjon> {
        return transaksjonRepository.findByAksjonaerFoedselsnummer(foedselsnummer)
    }
}