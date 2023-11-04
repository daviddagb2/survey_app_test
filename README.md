# SurveyAppTest - Android Developer Technical Test
Nimbe Survey app - Creation of an application that allows users to browse a list of surveys. Users must log in to the application. 
This repository contains the SurveyAppTest, an Android application developed as part of the technical test for the Android Developer position. The app features a robust login system and a home screen where users can browse through a list of surveys.

## Features

### Authentication
- Login screen with OAuth authentication.
- Secure storage of access tokens and automatic handling of refresh tokens.

### Home Screen
- Display of survey cards with cover image, name, and description.
- Horizontal scrolling through surveys.
- "Take Survey" action button leading to survey detail screen.
- Dynamic navigation indicator list based on API responses.
- Implemented survey preview with customizable viewholders, setting the stage for the final survey functionality, along with prepared use cases for server communication.


### Optional Features Implemented
- Forgot password screen.
- Caching of surveys for offline viewing.

## Technical Requirements
- Kotlin programming language.
- Developed using Android Studio and Gradle.
- Supports Android 5.0 (API 21) and higher.
- Version control with Git.

## Opportunities for Improvement

- **Pull-to-Refresh in Home Screen**: Implement the ability for users to refresh the list of surveys by pulling down on the screen, ensuring that the latest content is always displayed.
- **Caching of Surveys**: Implement the caching system to store the surveys on the device, allowing for offline viewing and reducing the need for constant data fetching.
- **Loading Animations**: Introduce more dynamic and engaging loading animations during data retrieval to enhance the user experience.
- **Survey Detail Implementation**: Finalize the survey detail screens with all the necessary information and interactivity as outlined in the design specifications.
- **User Interface Polishing**: Refine the user interface elements, transitions, and interactions to match the high fidelity designs.
- **Accessibility Improvements**: Ensure that the app is usable by people with various disabilities by implementing accessibility features.
- **Internationalization and Localization**: Prepare the app for a global audience by adding support for multiple languages and region-specific content.
- **Unit and Integration Testing**: Expand the current suite of tests to cover unit testing and integration testing, ensuring robustness and reliability.
- **Documentation and Code Comments**: Update the documentation and inline code comments to reflect the latest changes and make the project easier for new contributors to understand.


## API Integration
The application integrates with an OAuth 2 API using REST endpoints. 

## Design
The UI design follows the specifications provided on Figma, adapting some screens to android UI.

## Setup and Installation
Clone the repository, open it in Android Studio, and run the application on your emulator or device running Android 5.0 (API 21) or higher.

## Download APK
The APK can be downloaded for testing purposes. The link will be provided upon successful build and release.

- [APK DEMO LINK](https://github.com/daviddagb2/survey_app_test/blob/master/apktest/app-debug.apk)

## Tech stack & Open-source libraries
- [Android Kotlin](https://developer.android.com/kotlin)
- [MVVM Architecture](https://developer.android.com/jetpack/guide?gclsrc=aw.ds&gclid=CjwKCAjw_ISWBhBkEiwAdqxb9up3VFjuEbls5467JIVkyOdTgg-z-_NntWqaSFgkJr5qt6EmGsb7vxoCj9kQAvD_BwE)
- [Retrofit](https://square.github.io/retrofit/)
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room?gclsrc=aw.ds&gclid=CjwKCAjw_ISWBhBkEiwAdqxb9r5eN7phvDex2hZ5gGRkm1GckeBjkR8LNm3GwDU_4EC8OdDDtDxt_xoCH8QQAvD_BwE)
- [Dagger Hilt](https://dagger.dev/hilt/)
- [Picasso](https://square.github.io/picasso/)

## Contact me

- [Website](https://gonzalezblanchard.com/)
- [LinkedIn](https://www.linkedin.com/in/davidgb2021/)
- [Github](https://github.com/daviddagb2)
- [Blog](https://blanchardspace.wordpress.com/)
- [Linktree](https://linktr.ee/davidgb77)
- [Youtube](https://www.youtube.com/@developergb)

