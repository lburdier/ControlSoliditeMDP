## **🔐 ControlSoliditeMDP**  
**Application Android de vérification de solidité des mots de passe avec un design inspiré de ChatGPT.**  

### 📌 **Fonctionnalités**  
✔ **Analyse de la solidité des mots de passe** en fonction de leur longueur et complexité.  
✔ **Affichage du temps estimé pour le casser** (en secondes, minutes, heures, jours).  
✔ **Prise en compte des caractères spéciaux, majuscules, minuscules et chiffres** pour évaluer la force du mot de passe.  
✔ **Interface moderne et intuitive**, basée sur **Material Design** et inspirée du **style ChatGPT**.  
✔ **Bouton pour afficher/masquer le mot de passe**.  
✔ **Mode sombre natif** pour une meilleure lisibilité.  

---

### 🚀 **Installation**  

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/lburdier/ControlSoliditeMDP.git
   cd ControlSoliditeMDP
   ```

2. **Ouvrir le projet dans Android Studio** :
   - **Android Studio 2022+** est recommandé.
   - Assure-toi d'avoir le SDK **Android 7.0+ (API 24 ou supérieur)** installé.

3. **Lancer l'application** :
   - Exécute sur un **émulateur** ou un **appareil physique** sous Android 7.0+.

---

### 📂 **Architecture du projet**  

```
ControlSoliditeMDP/
│── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/controlsoliditemdp/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── PasswordStrengthCalculator.kt
│   │   │   │   ├── utils/  # (Dossier pour des fonctions utilitaires)
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── fragment_dashboard.xml
│   │   │   │   │   ├── fragment_home.xml
│   │   │   │   │   ├── fragment_notifications.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_visibility.xml
│   │   │   │   │   ├── ic_visibility_off.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── themes.xml
│   │   │   ├── AndroidManifest.xml
│   ├── test/
│   │   ├── java/com/example/controlsoliditemdp/
│   │   │   ├── ExampleUnitTest.kt
│   ├── androidTest/
│   │   ├── java/com/example/controlsoliditemdp/
│   │   │   ├── ExampleInstrumentedTest.kt
```

---

### 🎨 **Design inspiré de ChatGPT**  
L’interface a été **optimisée pour une expérience fluide** avec :  
- **Mode sombre par défaut**.  
- **Couleurs et boutons inspirés du design de ChatGPT**.  
- **TextInput avec `MaterialComponents`** pour un look moderne.  

---

### ⚙️ **Technologies utilisées**  
- **Kotlin** 🟣  
- **Android SDK (API 33)** 📱  
- **Material Design Components** 🎨  
- **ConstraintLayout** 📏  

---

### 📌 **Améliorations futures**  
🔜 **Ajout d'une API de génération de mots de passe sécurisés**.  
🔜 **Possibilité d'enregistrer et gérer plusieurs mots de passe**.  
🔜 **Ajout d’un mode analyse avancée pour proposer des recommandations**.  

---

### 🛠 **Contribuer au projet**  
Si tu veux contribuer :  
1. **Fork le projet**  
2. **Crée une branche (`feature-nouvelle-fonctionnalité`)**  
3. **Fais un Pull Request**  

---

### 📄 **Licence**  
MIT © 2025 - **BURDIER Lucas**  

🚀 **Développé avec passion et sécurité !**
