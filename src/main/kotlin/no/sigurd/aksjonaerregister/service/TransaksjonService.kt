package no.sigurd.aksjonaerregister.service

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import no.sigurd.aksjonaerregister.model.dto.TransaksjonsRequestDTO
import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import no.sigurd.aksjonaerregister.model.entity.Transaksjon
import no.sigurd.aksjonaerregister.repository.AksjonaerRepository
import no.sigurd.aksjonaerregister.repository.TransaksjonRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TransaksjonService(
    private val transaksjonRepository: TransaksjonRepository,
    private val aksjonaerRepository: AksjonaerRepository,
    ) {
    fun registrerTransakjson(foedselsnummer: String, request: TransaksjonsRequestDTO): Transaksjon {
        val aksjonaer = aksjonaerRepository.findByFoedselsnummer(foedselsnummer)
            ?: throw IllegalArgumentException("Fant ikke aksjonær med fødselsnummer: $foedselsnummer")

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