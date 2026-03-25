package no.sigurd.aksjonaerregister.controller

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
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@RestController
@RequestMapping("/api/aksjonaerer")
class AksjonaerController(private val aksjonaerService: AksjonaerService,
                          private val transaksjonService: TransaksjonService
) {

    @PostMapping
    fun nyAksjonaer(@RequestBody aksjonaer: Aksjonaer) : ResponseEntity<Aksjonaer> {
        val opprettet = aksjonaerService.nyAksjonaer(aksjonaer)
        return ResponseEntity.ok(opprettet)
    }

    @GetMapping("/{fnr}")
    fun hentAksjonaer(@PathVariable fnr: String): ResponseEntity<Aksjonaer> {
        val aksjonaer = aksjonaerService.hentAksjonaer(fnr)
        return aksjonaer?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/{fnr}/transaksjoner")
        fun registrerTransaksjon(@PathVariable fnr: String, @RequestBody request: TransaksjonsRequestDTO): ResponseEntity<Transaksjon>{
            val nyTransaksjon = transaksjonService.registrerTransakjson(fnr, request)
            return ResponseEntity.ok(nyTransaksjon)
        }
//            val opprettet = transaksjonService.registrerTransaksjonForAksjonaer(fnr, request)
//            return ResponseEntity
//                .created(URI("/api/aksjonaerer/$fnr/transaksjoner/${opprettet.id}"))
//                .body(opprettet)

    @GetMapping("/{fnr}/transaksjoner")
    fun hentTransaksjoner(@PathVariable fnr: String): ResponseEntity<List<Transaksjon>> {
        return ResponseEntity.ok(transaksjonService.hentTransaksjonerForAksjonaer(fnr))
    }

    private fun dummyTransaksjon(fnr: String): Transaksjon {
        val dummyAksjonaer = Aksjonaer(
            id = UUID.randomUUID(),
            navn = "Ola Nordmann",
            foedselsnummer = fnr
        )

        return Transaksjon(
            id = UUID.randomUUID(),
            aksjonaer = dummyAksjonaer,
            aksjenavn = "Equinor",
            transaksjonType = TransaksjonType.KJOEP,
            antall = 100,
            prisPerAksje = BigDecimal("250.50"),
            dato = LocalDate.now()
        )
    }
}