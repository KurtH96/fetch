## Purpose  
This diary is aimed to keep track of personal thoughts while working through
this exercise. Additionally, this serves as a reminder of in-progress work as
it is returned to.  
  
## Starting Out  
At first glance, this exercise seems straightforward, but the Android
ecosystem is quite mature with a wide selection of libraries to implement
a plethora of application requirements.  
  
The initial approach in mind is to implement requirements in the following
order:  
- Project setup, intiate a basic application
- Data persistence, database implementation, and entity definition
- HTTP(S) request and data parsing
- User interface and "backend for frontend"
- Application architecture

Typically, application architecture *should* be considered in the beginning to
avoid costly refactors later. In this scenario, there are very little
requirements that are small. The application will generally follow the Android
Developer's guide for architecture, a layered architecture with emphasis on
domain driven design. 

An "Agile" approach is used as the development process. Each component, listed
above, will be explored in "spikes" to meet individual requirements. Once
satisfied with each component, all will be tied together with a cohesive
architecture.  
  
**A note on testing:**  
Little emphasis will be made for testing. Some tests will be implemented to
ensure specified sorting is implemented properly. Most components implement are
trivial,need minimal configuration, and best tested with instrumentation.
Furthermore,this exercise is not an enterprise endeavor mandating a strict level
quality. Extensive abstractions, requiring tests, could be made to future to
allow flexibility in component implementation and choice of libraries.  
  
## Project Setup  
Repository creation is trivial and gives little grief. Setting up a developer
environment proved to be less straightforward since a machine with Windows Home
edition is used nor was a physical Android device available. Android Studio
provides a device emulation tool that requires virtualization features not
available for Windows Home. Fortunately, a tool is available for Intel
processors which the development machine uses. Some library dependencies are
tricky as well, and related issues are easily resolved by using library versions
compatible with each other.  
  
## Data Definition and Persistence  
Data models are defined in the same structure as provided from the data source.
An offline-first model is chosen, and the Jetpack Room framework is recommended
for database management for Android. Jetpack Room allows for a database to be
quickly implemented. Only minimal configuration, a basic entity definition, and
a couple stored procedures are needed.  
  
## HTTPS Request  
Several solutions are available to make network requests. The HTTP(s) APIs
included with the Android SDK are enough for this exercise. Given the returned
data is a list of JSON objects, a JSON parsing library is chosen to manage data
need to be query. KotlinX Serialization is the de facto serialization library
for Kotlin. This library converts JSON strings to Kotlin data classes, and the
data can be converted to the very same data class required for defining Room
entities.  

## User Interface
No design specification is given, so a very basic theme and layout is used. The
layout consists of a title and table of items. The user interface is implemented
with the Jetpack Compose framework.
  
