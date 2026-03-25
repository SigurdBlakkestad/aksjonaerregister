package no.sigurd.aksjonaerregister.model.dto

import java.beans.ConstructorProperties

data class InnloggingDTO
@ConstructorProperties
constructor(
    val email: String,
    val passord: String,
)