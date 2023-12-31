[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/MYVtI0hB)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=11359519)
# Todo List

## Description
- This was a weekly challenge to create a ToDo application, with tests in Junit and a CI using GitHub Actions.
- The application is a simple ToDo list, where you can add, remove and mark tasks as done.
- The application lets several users use the same list, and each user can see their own tasks.
- The tests let us check that the application works without using the SQLite database.
- The CI lets us check that the tests works, before merging the code to the main branch.

## Table of Contents (Optional)

- [Installation](#installation)
- [Packages used](#packages-used)
- [Usage](#usage)
- [Feedback](#feedback)
- [Credits](#credits)
- [License](#license)
- [Tests](#tests)

## Installation
Clone the repository to your local machine and run the application in your IDE.
you must have Java 20 installed on your machine.

## Packages used
JUnit Jupiter API  5.9.3 <br>
Mockito Core  5.3.1 <br>
SQLite JDBC  3.42.0.0

## Usage
#### When the application is running, you will get the following choice:
- User
- TODO
- Exit


#### If you choose User, you will get the following choice:
- Create new user
- Show all users 
- Show all Todos for a user
- Update a user
- Delete a user
- Back to main

If you choose Create new user, you will be asked to enter a name and an age.<br>
The application will then create a new user with the given name and age.

If you choose Show all users, you will get a list of all users.

If you choose Show all Todos for a user, you will be asked to enter a user-id.
The application will then show all Todos for the given user.

If you choose Update a user, you will be asked to enter a user-id.
Then you will get a choice to update that users name or age.  
You will be asked to enter the new information, and the application will then update the user with the given information.

if you choose Delete a user, you will be asked to enter a user-id.
The application will then delete the user with the given user-id.

if you choose back to main, you will get the main menu.

#### If you choose TODO, you will get the following choice:
- Create new Todo
- Show all Todos
- Show one todo and its info
- Update a Todo
- Delete a Todo
- Back to main

If you choose Create new Todo, you will be asked to enter a use-id.
Then you will be asked to enter a title and a description.
The application will then create a new Todo with the given information.

If you choose Show all Todos, you will get a list of all Todos for all users.

If you choose Show one todo and its info, you will be asked to enter a todo-id.
The application will then show the Todo with all its information.

If you choose Update a Todo, you will be asked to enter a todo-id.
Then you will get a choice to update that Todos description och if it's done or not.
You will be asked to enter the new information, and the application will then update the Todo with the given information.

if you choose Delete a Todo, you will be asked to enter a todo-id.
The application will then delete the Todo with the given todo-id.

if you choose back to main, you will get the main menu.


#### If you choose exit, the application will stop.

### Feedback
This project has been tested and checked by: <br>
Wakana Sugihara in an early stage. <br>
Johan Romeo in final stage. <br>

Both has given me feedback on what to improve and what to change and approved it afterwards.



## Credits
Co-pilot was present during the making of this application.<br>
ChatGPT was used to generate some of the more complex tests. <br>

Tutorials used:
* [Complete JUnit & Mockito Tutorial Course: From Zero to Hero 2022](https://www.youtube.com/watch?v=0ZtU3X9n6tI&list=WL&index=19&t=329s)

## License
MIT License

## Tests
I have tried for maximum coverage, but some Exception-cases I did not know how to test.
There is also a few public methods that I did not test, that my teacher said was ok not to test.
these methods are:
- CreateTables in SQLite class
- The constructors in several classes
- The Input class, since it contains a scanner, I therefor used my teachers technic to test FakeInput class instead.

## CI on GitHub Actions
The CI is set up to run the tests on every push to the main branch.
The CI will also run the tests on every pull request to the main branch.
the integration uses a workflow file that is located in the .gitHub/workflows folder, written in YAML.
what actions the CI takes also depends on the information in the pom.xml file.
