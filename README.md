# Movie Android App

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Overview

The Movie Android App is a user-friendly mobile application that allows users to explore a vast collection of movies and get information about their details, such as title, release year, synopsis, cast, and more. The app is designed for movie enthusiasts who want to discover new movies, keep track of their favorites, and read reviews.

![App Screenshots](/screenshots/screenshot.png)

## Features

- Browse and search for movies by title, genre, or release year.
- View detailed information about each movie, including plot summaries, cast, and crew.
- Watch movie trailers directly within the app.
- Bookmark favorite movies for easy access.
- Read and write reviews for movies.
- Share movie details with friends on social media platforms.
- Dark mode for improved visibility in low-light conditions.
- User-friendly interface with intuitive navigation.

## Installation

### Requirements

- Android 6.0 (Marshmallow) or above.
- Internet connectivity to fetch movie data.

### Instructions


1. Clone the repository: `git clone https://github.com/RedVelvet-Team/IMovie`
2. Open the project in Android Studio.
3. Build and run the app on your Android device or emulator.

## Usage

- On app launch, the user will be presented with a list of trending movies.
- Use the search bar to find specific movies by title or filter movies by genre, release year, or other criteria.
- Tap on a movie to view its detailed information, including a synopsis, cast, and crew.
- Add movies to your favorites list by tapping the heart icon.
- Watch movie trailers by clicking on the "Play" button within the movie details page.
- Write reviews for movies and read reviews submitted by other users.
- Toggle dark mode by accessing the settings menu.

## Technologies Used

- Android SDK
- Kotlin
- Jetpack Compose
- Kotlin DSL
- kotlin coroutine
- Clean Architecture by component.
- Jetpack Room Database
- Firebase firestore
- Retrofit
- Gson
- Dagger Hilt
- Jetpack navigation with compose
- work Manager
- Pagination

## API Integration

The app integrates with the [Movie Database API](https://www.themoviedb.org/documentation/api) to fetch movie information. To use the app, you'll need to obtain an API key from themoviedb.org and add it to the app's code.

1. Go to [themoviedb.org](https://www.themoviedb.org/) and sign up for an account (if you don't have one).
2. Follow the API documentation to obtain your API key.
3. Open the `local.properties` file and replace `api_key` with your actual API key.
4. Use it through BuildConfig.API_KEY
5. if property `api_key` not showing, just add it `api_key=YOUR_KEY`

```kotlin
fun getApiKey(){
  val key = BuildConfig.API_KEY
}
