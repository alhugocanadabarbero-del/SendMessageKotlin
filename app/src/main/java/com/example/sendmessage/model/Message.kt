package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Representa un mensaje enviado entre dos personas en la aplicación.
 * 
 * Implementa mediante la anotación `@Parcelize` para permitir su
 * paso seguro entre actividades a través de `Intent` y `Bundle`.
 *
 * @property id Identificador único del mensaje.
 * @property content Texto o cuerpo del mensaje.
 * @property sender Remitente del mensaje.
 * @property reciver Destinatario del mensaje.
 */
@Parcelize
data class Message(
    val id: Int,
    val content: String,
    val sender: Person,
    val reciver: Person
) : Parcelable {
}
