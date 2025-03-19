package com.example.controlsoliditemdp.metier

import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class TestPassword {

    private val complexityTable: Map<Int, Duration> = mapOf(
        5 to 5.toDuration(DurationUnit.SECONDS),
        8 to (24 * 60).toDuration(DurationUnit.SECONDS), // 24 minutes
        12 to (14 * 24 * 60 * 60).toDuration(DurationUnit.SECONDS), // 14 jours en secondes
        16 to (10 * 365 * 24 * 60 * 60).toDuration(DurationUnit.SECONDS) // 10 ans en secondes
    )


    @OptIn(ExperimentalTime::class)
    fun calculateStrength(password: String): Duration? {
        val length = password.length
        return complexityTable.entries.find { it.key <= length }?.value
    }
}