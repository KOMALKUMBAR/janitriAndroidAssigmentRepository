Color Palette App

A modern Android application built with Jetpack Compose that allows users to manage and sync color palettes between local storage and cloud database.
Features

* Display color palettes in a responsive grid layout
* Offline-first architecture with local storage using Room DB
* Cloud synchronization with Firebase Realtime Database
* Generate random colors with timestamp
* Material 3 Design implementation
* MVVM Architecture pattern
* Automatic background synchronization
* Pending sync counter
Tech Stack

* Language: Kotlin
* UI Framework: Jetpack Compose
* Architecture: MVVM
* Local Database: Room DB
* Cloud Database: Firebase Realtime Database
* Dependency Injection: Hilt
* Concurrency: Kotlin Coroutines & LiveData
* Android Architecture Components:
    * ViewModel
    * LiveData
    * Room
    * WorkManager

Getting Started

Prerequisites

* Android Studio Hedgehog | 2023.1.1 or newer
* JDK 17
* Android SDK 34
* Firebase account for cloud database
Installation

1. Clone the repository
git clone[ https://github.com/yourusername/color-palette-app.git](https://github.com/KOMALKUMBAR/janitriAndroidAssigmentRepository.git)]

1. Open project in Android Studio
2. Create a Firebase project and add the google-services.json file to the app directory
3. Build and run the project
Architecture

This app follows the MVVM (Model-View-ViewModel) architecture pattern and Clean Architecture principles:
* UI Layer: Composable functions and ViewModels
* Data Layer: Repository pattern with Room and Firebase implementations
Data Flow

1. UI layer observes ViewModels
2. ViewModels interact with UseCases
3. Repository manages data from Room DB and Firebase
Features in Detail

Offline Support

* App works fully offline using Room DB
* Automatically syncs when internet connection is available
* Keeps track of pending sync items
Color Generation

* Generates random colors in hex format
* Automatically adds timestamp
* Stores in local database immediately
Acknowledgments

* Material Design 3 Guidelines
* Android Jetpack Documentation
* Firebase Documentation

* Screen Short
* Firebase
<img width="1440" alt="Screenshot 2024-12-27 at 6 50 40 AM" src="https://github.com/user-attachments/assets/86d4ddc0-d898-45dc-83f4-bf89c8c0efca" />
Application Photo
<img width="1440" alt="Screenshot 2024-12-27 at 6 49 13 AM" src="https://github.com/user-attachments/assets/9f5f9e24-fddf-46bc-8892-32cdc868d8f7" />

<img width="1440" alt="Screenshot 2024-12-27 at 6 59 20 AM" src="https://github.com/user-attachments/assets/c7650efb-0b02-49fd-a45e-028db6ae24c3" />
