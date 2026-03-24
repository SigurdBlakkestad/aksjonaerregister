package no.sigurd.aksjonaerregister.controller

import no.sigurd.aksjonaerregister.model.Aksjonaer
import no.sigurd.aksjonaerregister.service.AksjonaerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/aksjonaerer")
class AksjonaerController(private val aksjonaerService: AksjonaerService) {

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
}