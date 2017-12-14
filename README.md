# FlashMe - Server

### Server

This is the Spring Boot server system we created to act as our SQL database management app. With Spring, Tomcat, and Derby we've built out a robust data management system to offer realtime updates to the deck and card creation, and user profile updates. Information stored on the server can be shared in the future to a web app to allow syncronized accounts across all platforms of _Flash Me_.

### Technology Used

* Java JVM 1.8.0_152
* Spring Boot 1.5.9
* Jackson Faster XML 2.8.10
* Hibernate 5.0.12
* Derby 10.13.1.1
* Tomcat 8.5.23
* Linux server 2.6.32-042stab120.19 #1 SMP

### Background ###
_Flash me_ is a a flash card generation and studying app 
that allows users to save time by optimizing the card creation process and
utilizing the power of our visual memories. It includes an implementation of the
[Leitner System](https://en.wikipedia.org/wiki/Leitner_system), 
which is a way of enhancing retention using the concept of the
Spaced Repetition. 

### Why build this app? ###
We built this app for the sole purpose of saving time while creating flashcards.
We love using [Anki](https://apps.ankiweb.net/) as a way to create and study flash cards, but we disliked
the fact that we could not automatically search for images and use
them as memory aid from within Anki. 

We believe that any app that allows one to save time is a useful tool.
The Flash Me app falls into this category. At the same time, Flash Me
does not diminish or neglect to preserve a user's ability to interact
with the topic he or she is trying to master. A user is still
able to manually search for images and create the content, which
is essential in helping a user retain information.

### Current State ###
The time saving aspect of _Flash me_ lies in its built in functionality 
of automatically searching for images based on the user specified 
keyword/s. In addition, the deck and card creation process follows a specific order, which
add to the time saving capacity of _Flash me_. Currently, we use a a scaled down implementation 
of the Leitner System with a three "box" system and a "graduated" box. This system's framework is built out but we need to implement the "review session" and tie it into the user profile loadout. 

We have Google OAuth implemented for sign-in and after sign-in you are loaded into the user profile fragment which is where you can view your current active study decks. In addition, the decks display the study subject and current configurations. The user profile fragment currently links you to both the configuration settings and deck/card creation. A user can create new decks, create cards within that deck and assign images to the cards by searching keywords. Users can also delete cards from a deck and delete a deck but currently only a deck that has zero cards can be properly deleted. 

All data generated in the app currently is stored in our server and updated in realtime.

### Team Members ###

1. [Ejerson Balabas](https://github.com/ejerson)
2. [Ana Kissler](https://github.com/anakissler)
3. [Caryl Stuart](https://github.com/carylstuart77)
4. [Izaac Tajan](https://github.com/itajan)

### Hardware and Software Specifications and Testing

<b>Emulators |</b> Nexus 5X API 22

<b>Device |</b> Samsung S7 Edge API 24
 
<b>Orientation Restrictions |</b> The ImageActivity is restricted to Portrait orientation to solve
an issue with the Google Custom Search API disappearing on layout change. 
In addition, this decision is made to preserve the aesthetic feel of 
the search functionality. 

### Necessary Aesthetic Improvements
* Check buttons should have a white background with a line on top.
* The Review button and Level up button should only appear when 
  the user checks each cards.
* When user is reviewing cards, to go to the previous or next card, user can swipe right
  or left instead of just clicking the REVIEW button.
  
### Action Items
* Instead of a user being able to delete a deck by clicking the delete button once,
  the user should receive a warning dialog instead that asks them if they really want 
  to delete a given deck.
* Ability to update the review pool in displayed in the list of currently created decks. As of now,
  it can can only be updated when a user reviews cards. This should be updated on
  card addition, card edit, and card delete.
* The Leitner System implementation is at its initial stage. I can promote cards to Level 2.
  * Create a graduated card pool, which will contain cards that have reached the
    highest level (7).
  * Demote cards if the user fails to remember the back of the card within 1 minute.
  * Promote card if the user remembers the back of the card within 1 minute and clicking
    the LEVEL UP button.
* Implement a daily limit on how many cards are being reviewed (30)
    * Each day a card pool will be populated with a specific amount of cards 
    from each card level 
      * 15 - Level 1
      * 10 - Level 2
      * 5 - Level 3
    * If a user fails to remember a card, demote card to level 1
    * If a user succeeds to remember a card, promote card to a higher level
    
### Stretch Goals
* Build a website to allow users to create cards and migrate Flash Me to be  
  used as a way to review cards. The card creation functionality will still 
  be functional. The web app version would allow users to share created decks with other users in the _Flash Me_ ecosystem. 
* A user can promote cards up to Level 7.
* A user can select multiple cards to edit sequentially, instead of the current 
functionality of users only able to select one card to edit at a time.
* App will have a way for users to see how many cards are in each level. (We have this functionality framed but not wired into the app.)
* A user will be able to specify a specific number of cards to review daily. (Again this functionality is framed but still working on wiring it in to the app.)
* A user will be able to get a check mark for a given day if all card within
the daily limit pool are reviewed. (The number of sessions for each deck can be assigned and viewed but the checkmark is not being assigned.)
* Auto demote a card if a user fails to remember them at a given set of time.
* A user will be able to swipe left or right instead of having to click the review button
to review a new card.
* Implement Firebase instead of a Spring Boot server to store user data and provide realtime adjustments to the data.


  [FlashMe Server JavaDocs](https://ejerson.github.io/FlashMe/docs/)





Server side for capstone project.
