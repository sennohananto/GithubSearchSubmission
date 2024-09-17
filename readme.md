# Github Search Submission Application

This project is an Android application built to search for GitHub users and display detailed information about them. The app is structured using **Clean Architecture** to separate the business logic, data, and presentation layers. It also utilizes various modern Android libraries to implement best practices in software development.

## Features

- **GitHub User Search**: Search for users on GitHub based on their username.
- **User Details**: Display detailed information about a user such as name, followers, and repositories.
- **Clean Architecture**: Adheres to Clean Architecture principles by separating concerns into distinct layers.
- **Dependency Injection**: Uses Hilt for dependency injection to manage the lifecycle of components and to provide dependency management.
- **Modular Design**: Organizes code into modular components, making the app more maintainable and scalable.

---

## Project Structure

The project follows **Clean Architecture**, divided into three layers:

1. **Domain Layer**: Contains the business logic, including use cases and repository interfaces.
2. **Data Layer**: Responsible for handling data sources (both local and remote) and repository implementations.
3. **Presentation Layer**: Manages UI components, ViewModels, and adapters.

---

## Technologies and Libraries

### 1. **Kotlin**
The project is written entirely in Kotlin, leveraging modern language features and extensions.

### 2. **Android Architecture Components**
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **LiveData**: Observes changes in data and updates the UI accordingly.
- **Room Database**: Provides an abstraction layer over SQLite to allow for more robust database management.

### 3. **Dependency Injection (Hilt)**
- **Hilt**: A dependency injection library for Android that reduces boilerplate code and manages dependencies efficiently.

### 4. **Coroutines**
- **Kotlin Coroutines**: Handles asynchronous programming, allowing for the efficient execution of background tasks, such as making API calls or interacting with databases.

### 5. **Networking**
- **Retrofit**: Used for making network requests to GitHub's API.
- **Moshi**: A modern JSON library for Kotlin used to parse API responses.
- **Chucker**: An HTTP inspector that logs API calls and responses for easier debugging.

### 6. **Jetpack Components**
- **Navigation Component**: Manages in-app navigation between fragments and activities.
- **Paging**: Implements pagination to load large datasets in a RecyclerView efficiently.

### 7. **Local Database**
- **Room Database**: Provides local caching and persistence, used to store user data for offline access.

### 8. **Testing**
- **JUnit**: Unit testing framework for testing business logic in the domain layer.
- **Espresso**: UI testing framework to test user interactions within the app.
- **Mockito**: Used for mocking dependencies while testing.

### 9. **Kapt (Kotlin Annotation Processing)**
- Replaces `ksp` (Kotlin Symbol Processing) for annotation processing in the app, required by libraries like Hilt and Room.

### 10. **Multidex Support**
- **Multidex**: Enables the app to break the method limit imposed by the DEX format, allowing the app to have multiple DEX files.

---

## Project Setup

### Prerequisites

- **Java 18**: This project uses Java 18 for the JVM target.
- **Android Studio**: Latest version is recommended.
