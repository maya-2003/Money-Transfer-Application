# 💸 Money Transfer Application

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=android&logoColor=white)

A secure, fully-featured Android mobile banking application built with **Kotlin** and **Jetpack Compose**. Designed with a focus on modern UI/UX and security, this app allows users to seamlessly manage their finances, execute real-time money transfers, and track their transaction history.

## ✨ Features

### 🔐 Security & Account Management
* **Secure Onboarding & Authentication:** Strict password policies (uppercase, lowercase, special characters) and comprehensive login flows.
* **Auto-Logout / Inactivity Alert:** Automatically prompts users to re-authenticate after 2 minutes of inactivity to protect sensitive financial data.
* **Profile Management:** Complete and update profile details (Country, DOB, Email, Password).

### 💳 Core Banking
* **Real-time Balance & History:** Instantly view account balances and a detailed log of past transactions (date, recipient, amount).
* **Send Money:** Transfer funds effortlessly using recipient name and account number.
* **API Recipient Verification:** Automatically verifies recipient details via an API call *before* finalizing transactions to prevent errors.

### 📱 User Experience
* **Favorites System:** Save, edit, delete, and quickly access frequent transfer recipients. Includes an innovative "call-to-copy" feature for quick info retrieval.
* **Robust Error Handling:** Clear UI feedback for insufficient funds, invalid recipients, server errors, and connectivity drops.
* **Integrated Support:** Quick access to customer support via phone or email directly from the app.

## 🛠️ Tech Stack
* **Language:** Kotlin (100%)
* **UI Framework:** Jetpack Compose
* **Platform:** Android SDK
* **Architecture:** MVVM (Model-View-ViewModel)
* **Build System:** Gradle (Kotlin DSL)

## 🚀 Getting Started

### Prerequisites
* [Android Studio](https://developer.android.com/studio) (Latest Version recommended)
* Android SDK 30+ 
* An Android Emulator or physical device for testing

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/maya-2003/Money-Transfer-Application.git
   ```
2. **Open in Android Studio:**
   * Open Android Studio and select **File > Open**.
   * Navigate to the cloned directory and select it.
3. **Sync Gradle:**
   * Wait for Android Studio to sync the project dependencies.
4. **Run the App:**
   * Click the **Run** ▶️ button in the toolbar to build and install the app on your emulator or connected device.

## 📌 Recent Updates (Patch 1.2v)
* Fixed SignIn retention from the Home Screen.
* Fixed favorite card view rendering in ModalSheet.
* Added `logout_view_model` for cleaner authentication state management.
