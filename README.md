# News App

A project that helps user to see the list of top headlines in the US and can read the detail news. 
This app has offline support which helps user to go through headlines when the user is not connected
to the network.

## Description

* Get latest news headlines using News API
* Only first 20 result will be displayed
* Tap any news card to open the article

## Instructions
You need an Api Key from News API. Go to Constants class and replace the api key for your key.

## Libraries and Tools used

* AndroidX Libraries
* LiveData
* ViewModel
* RxJava
* RxAndroid
* Dagger
* Picasso
* Retrofit

## Architecture

The application is made in MVVM architecture using architecture components introduced by google.

In this application the data is fetched from the retrofit service and simultaneously stored in the Room Database.
The list is shown to the user depeding upon the network availability. If network is available it is fetched from API otherwise in case of no network the last loaded data is fetched from Room Database. 

The Repository is responsible for managing the connection between view model and the data source, so the view model doesn't know any thing about the data source it's only consume data from the repository whatever that data source is.The Activity will only consume the data so it's pretty lightweight and change can be easily configured.

Databinding is used to bind the data to views to avoid boilerplate code and add more layer of abstraction.

RxJava is used to get the data from API and can do network call or any database operation in different thread and give the final data source to main thread to show the user list of news.

Dagger is used for dependency injection of course to make the code more testable and robust

![alt text](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
