package com.example.controlsoliditemdp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.controlsoliditemdp.metier.PasswordStrengthCalculator
import com.example.controlsoliditemdp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var passwordStrengthCalculator: PasswordStrengthCalculator
    private lateinit var mdpField: EditText
    private lateinit var checkAfficherMdp: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation du binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialisation du calculateur de force de mot de passe
        passwordStrengthCalculator = PasswordStrengthCalculator()

        // Récupération des éléments de l'interface
        mdpField = findViewById(R.id.mdpATester)
        checkAfficherMdp = findViewById(R.id.checkAfficherMdp)
        val btnTest: Button = findViewById(R.id.btnTester)

        // Ajout du listener pour tester le mot de passe
        btnTest.setOnClickListener { testPassword() }

        // Ajout du listener pour afficher/masquer le mot de passe
        checkAfficherMdp.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mdpField.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                mdpField.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            // Place le curseur à la fin du texte
            mdpField.setSelection(mdpField.text.length)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun testPassword() {
        val resultatView: TextView = findViewById(R.id.affichageResultat)
        val strengthTextView: TextView = findViewById(R.id.tvPasswordStrength)

        val password = mdpField.text.toString().trim()

        if (password.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un mot de passe.", Toast.LENGTH_SHORT).show()
            return
        }

        // Calculer la force du mot de passe
        val result = passwordStrengthCalculator.calculatePasswordStrength(password)

        // Déterminer les critères manquants
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { "!@#$%^&*(),.?\":{}|<>".contains(it) }

        // Messages d'avertissement
        val missingCriteria = mutableListOf<String>()
        if (!hasUpperCase) missingCriteria.add("🔴 Ajoutez une majuscule")
        if (!hasLowerCase) missingCriteria.add("🔴 Ajoutez une minuscule")
        if (!hasDigit) missingCriteria.add("🔴 Ajoutez un chiffre")
        if (!hasSpecialChar) missingCriteria.add("🔴 Ajoutez un caractère spécial")

        // Affichage du temps estimé pour casser le mot de passe
        val resultText = if (result.toInt() == 0) "Inconnu" else formatTime(result)
        resultatView.text = "Durée estimée pour casser le mot de passe : $resultText"

        // Détermination de la solidité du mot de passe
        val strength = when {
            result < 10 -> "Très faible 🔴"
            result in 10..60 -> "Faible 🟠"
            result in 61..3600 -> "Moyen 🟡"
            result in 3601..86400 -> "Fort 🟢"
            result > 86400 -> "Très Fort 🔵"
            else -> "Inconnu ❔"
        }

        // Affichage de la solidité + recommandations
        strengthTextView.text =
            "Solidité du mot de passe : $strength\n" + missingCriteria.joinToString("\n")
    }

    /**
     * Convertit un temps donné en secondes en une chaîne lisible (minutes, heures, jours)
     */
    private fun formatTime(seconds: Long): String {
        return when {
            seconds < 60 -> "$seconds secondes"
            seconds < 3600 -> "${seconds / 60} minutes"
            seconds < 86400 -> "${seconds / 3600} heures ${seconds % 3600 / 60} minutes"
            else -> "${seconds / 86400} jours ${seconds % 86400 / 3600} heures ${seconds % 3600 / 60} minutes"
        }
    }
}