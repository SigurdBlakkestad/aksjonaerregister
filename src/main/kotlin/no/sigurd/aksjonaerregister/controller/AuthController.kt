package no.sigurd.aksjonaerregister.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {

    @PostMapping("/registrering")
    fun registrering(): String {
        return "Registrert"
    }
}