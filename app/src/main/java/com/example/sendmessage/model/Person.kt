package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Representa a una persona en la aplicación.
 * 
 * Implementa Parcelable mediante `@Parcelize` para permitir
 * que los objetos de esta clase sean empaquetados y transportados entre actividades.
 *
 * @property dni Documento Nacional de Identidad o identificador único de la persona.
 * @property name Nombre de pila de la persona.
 * @property surname Apellidos de la persona.
 */
@Parcelize
data class Person(
    val dni: String,
    val name: String,
    val surname: String
) : Parcelable
