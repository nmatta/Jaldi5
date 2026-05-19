# Jaldi5 Project Summary

## Overview
Jaldi5 is an Android-based random number generator application, specifically designed for games like Tambola or Bingo. The name "Jaldi 5" refers to a common winning pattern in Tambola where a player is the first to mark five numbers on their ticket.

## Features
- **Number Grid**: Displays a table of numbers from 1 to 90.
- **Random Number Generation**: Generates a unique random number between 1 and 90 at the press of a button.
- **Number Highlighting**: When a number is generated, it is highlighted in the grid to keep track of called numbers.
- **Game Management**:
    - **New Game**: Resets the grid and the list of generated numbers to start a fresh session.
    - **Exit**: Closes the application.
- **State Handling**: Prevents duplicate numbers from being generated and disables the generator once all 90 numbers have been called.

## Technical Stack
- **Platform**: Android
- **Language**: Java
- **Build System**: Gradle 8.8
- **Android Gradle Plugin**: 8.1.0
- **Minimum SDK**: 21 (Android 5.0 Lollipop)
- **Target SDK**: 34 (Android 14)
- **UI Framework**: Android XML Layouts with AndroidX support
- **Key Components**:
    - `MainActivity.java`: Contains the main logic for UI initialization, random number generation, and button click handling.
    - `activity_main.xml`: Defines the layout of the application.
    - `LogicUnitTest.java`: Unit tests for verifying the random number generation and uniqueness logic.
