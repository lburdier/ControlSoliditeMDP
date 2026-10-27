**English** · [Français](README.fr.md)

# ControlSoliditeMDP

**Android app that checks how strong a password is, with a ChatGPT-inspired design.**

## Features

- **Password strength analysis** based on length and complexity.
- **Estimated time to crack it** (seconds, minutes, hours, days).
- **Takes special characters, uppercase, lowercase and digits into account** to rate the password.
- **Modern, intuitive interface** built on **Material Design**, inspired by **ChatGPT's style**.
- **Show / hide password** button.
- **Native dark mode** for better readability.

---

## Installation

1. **Clone the project**:
   ```bash
   git clone https://github.com/lburdier/ControlSoliditeMDP.git
   cd ControlSoliditeMDP
   ```

2. **Open it in Android Studio**:
   - **Android Studio 2022+** is recommended.
   - Make sure the **Android 7.0+ (API 24 or higher)** SDK is installed.

3. **Run the app**:
   - On an **emulator** or a **physical device** running Android 7.0+.

---

## Project structure

```
ControlSoliditeMDP/
│── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/controlsoliditemdp/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── PasswordStrengthCalculator.kt
│   │   │   │   ├── utils/  # (helper functions)
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

## ChatGPT-inspired design

The interface is **tuned for a smooth experience**:
- **Dark mode by default**.
- **Colours and buttons inspired by ChatGPT's design**.
- **`MaterialComponents` text inputs** for a modern look.

---

## Tech stack

- **Kotlin**
- **Android SDK (API 33)**
- **Material Design Components**
- **ConstraintLayout**

---

## Roadmap

- An **API to generate secure passwords**.
- **Save and manage several passwords**.
- An **advanced analysis mode** with recommendations.

---

## Contributing

1. **Fork the project**.
2. **Create a branch** (`feature-my-feature`).
3. **Open a pull request**.

---

## License

MIT © 2025 **BURDIER Lucas**
