# JavaSpring_NotesApp

This is a Spring MVC controller class that handles HTTP requests for notes-related functionality.

## Photos
![NotesApp1](https://user-images.githubusercontent.com/107481123/235327652-d8b0264b-97d1-4f1a-98f6-89642d24af3b.png)
![SaveNote1](https://user-images.githubusercontent.com/107481123/235327655-4c903972-0402-4a9b-bc64-04a6406039df.png)



## Functionality

This controller provides the following functionality:
- Display a list of notes in a view
- Delete a note
- Save a new note

## Dependencies

This controller depends on the following classes:
- `Notes` class in the `com.works.days2.props` package
- `NoteService` class in the `com.works.days2.services` package
- Spring Framework and Spring MVC

## Endpoints

This controller provides the following endpoints:
- GET `/noteshome`: displays a list of notes in a view
- GET `/noteDelete/{nid}`: deletes a note with the given ID and redirects to `/noteshome`
- GET `/notes`: displays a form to create a new note
- POST `/noteSave`: saves a new note and redirects to `/noteshome`

## Usage

To use this controller, you can create a new instance of `NoteController` and map it to the appropriate HTTP endpoints using a `@RequestMapping` annotation or other means. You will also need to ensure that the necessary dependencies are included in your project, such as Spring Framework and Spring MVC.

