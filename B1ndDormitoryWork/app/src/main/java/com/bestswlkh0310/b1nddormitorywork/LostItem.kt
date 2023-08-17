package com.bestswlkh0310.b1nddormitorywork

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class LostItem(
    val idx: Long,
    val thumbnail: Int,
    val title: String,
    val content: String,
    val author: String,
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val createdTime: LocalDateTime,
)

@Serializer(forClass = LocalDateTime::class)
object LocalDateTimeIso8601Serializer : KSerializer<LocalDateTime> {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString(), formatter)
    }
}