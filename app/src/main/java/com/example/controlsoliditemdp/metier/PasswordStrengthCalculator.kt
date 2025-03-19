package com.example.controlsoliditemdp.metier

class PasswordStrengthCalculator {

    private val complexityTable = mapOf(
        4 to 0,
        5 to 1,
        6 to 5,
        7 to 10,
        8 to 30,
        9 to 60,
        10 to 300,
        11 to 1800,  // 30 minutes
        12 to 3600,  // 1 heure
        13 to 10800, // 3 heures
        14 to 86400, // 1 jour
        15 to 1209600, // 2 semaines
        16 to 94608000, // 3 ans
        17 to 1672531200, // 53 ans
        18 to 94608000000 // 3 000 ans
    )

    fun calculatePasswordStrength(password: String): Long {
        val length = password.length

        var baseTime = complexityTable[length] ?: 0  // Temps de base selon la longueur

        // Vérification des caractères spéciaux, majuscules et chiffres
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { "!@#$%^&*(),.?\":{}|<>".contains(it) }

        // Ajout de bonus de complexité
        if (hasUpperCase) baseTime *= 2  // Majuscule double la durée
        if (hasDigit) baseTime *= 2      // Nombre double la durée
        if (hasSpecialChar) baseTime *= 3 // Caractères spéciaux triplent la durée

        return baseTime
    }
}