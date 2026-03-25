package no.sigurd.aksjonaerregister.controller

import no.sigurd.aksjonaerregister.model.dto.AksjonaerDTO
import no.sigurd.aksjonaerregister.model.dto.TransaksjonsRequestDTO
import no.sigurd.aksjonaerregister.model.entity.Aksjonaer
import no.sigurd.aksjonaerregister.model.entity.Transaksjon
import no.sigurd.aksjonaerregister.model.enums.TransaksjonType
import no.sigurd.aksjonaerregister.service.AksjonaerService
import no.sigurd.aksjonaerregister.service.TransaksjonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import no.sigurd.aksjonaerregister.model.dto.AksjonaerResponsDTO
import no.sigurd.aksjonaerregister.model.dto.TransaksjonResponsDTO
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@RestController
@RequestMapping("/api/aksjonaerer")
class AksjonaerController(private val aksjonaerService: AksjonaerService,
                          private val transaksjonService: TransaksjonService
) {

    @PostMapping
    fun nyAksjonaer(@RequestBody aksjonaer: AksjonaerDTO) : ResponseEntity<AksjonaerResponsDTO> {
        val opprettet = aksjonaerService.nyAksjonaer(aksjonaer)
        return ResponseEntity.ok(opprettet.toResponsDTO())
    }

    @GetMapping("/{fnr}")
    fun hentAksjonaer(@PathVariable fnr: String): ResponseEntity<AksjonaerResponsDTO> {
        val aksjonaer = aksjonaerService.hentAksjonaer(fnr)
        return aksjonaer?.let { ResponseEntity.ok(it.toResponsDTO()) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/{fnr}/transaksjoner")
        fun registrerTransaksjon(@PathVariable fnr: String, @RequestBody request: TransaksjonsRequestDTO): ResponseEntity<TransaksjonResponsDTO>{
            val nyTransaksjon = transaksjonService.registrerTransakjson(fnr, request)
            return ResponseEntity.ok(nyTransaksjon.toResponsDTO())
        }
//            val opprettet = transaksjonService.registrerTransaksjonForAksjonaer(fnr, request)
//            return ResponseEntity
//                .created(URI("/api/aksjonaerer/$fnr/transaksjoner/${opprettet.id}"))
//                .body(opprettet)

    @GetMapping("/{fnr}/transaksjoner")
    fun hentTransaksjoner(@PathVariable fnr: String): ResponseEntity<List<TransaksjonResponsDTO>> {
        val transaksjoner = transaksjonService.hentTransaksjonerForAksjonaer(fnr)
        return ResponseEntity.ok(transaksjoner.map { it.toResponsDTO() })
    }

    private fun Aksjonaer.toResponsDTO(): AksjonaerResponsDTO {
        return AksjonaerResponsDTO(
            id = this.id,
            navn = this.navn,
            foedselsnummer = this.foedselsnummer
        )
    }

    private fun Transaksjon.toResponsDTO(): TransaksjonResponsDTO {
        return TransaksjonResponsDTO(
            id = this.id,
            aksjenavn = this.aksjenavn,
            transaksjonType = this.transaksjonType,
            antall = this.antall,
            prisPerAksje = this.prisPerAksje,
            dato = this.dato,
            aksjonaer = this.aksjonaer.toResponsDTO()
        )
    }
}