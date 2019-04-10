package tech.ajsf.instrutune.common.model

import tech.ajsf.instrutune.features.tuner.SelectedInstrumentInfo

data class InstrumentNote(
    val numberedName: String,
    val freq: Int
)

data class Instrument(
    val category: InstrumentCategory,
    val tuningName: String,
    val notes: List<InstrumentNote>,
    val id: Int?
)

fun Instrument.toInstrumentInfo(middleA: Int = 440): SelectedInstrumentInfo {
    val name = "$category ($tuningName)"
    val noteNames = notes.map { note -> note.numberedName }
    return SelectedInstrumentInfo(name, noteNames, "A4=${middleA}Hz", category.toString())
}

enum class InstrumentCategory {
    Guitar, Bass, Ukulele, Tres, Strings, Custom
}