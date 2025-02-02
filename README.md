
# Culinary Cache

Welcome to **Culinary Cache**, a Java-based recipe management application featuring a user-friendly GUI (JavaFX) and file-based data storage. This project 
highlights my ability to build a functional, data-driven application with a clean, intuitive interface, demonstrating my proficiency in Java development and file handling for persistent data management.

## Table of contents
* [Project Overview](#project-overview)
* [Key Features](#key-features)
* [Technologies & Tools](#technologies-and-tools)
* [Installation & Setup](#installation-and-setup)
* [Application Walkthrough](#application-walkthrough)
* [Demo](#demo)
* [Why This Project?](#why-this-project)
* [Contributing](#contributing)
* [License](#license)

## Project Overview
**Culinary Cache** is an application that allows users to manage their recipes efficiently. It provides key features like adding, editing, deleting, and searching recipes, along with a simple yet elegant design using JavaFX. The recipes are stored in a local file (recipes.dat), ensuring data persistence without relying on complex databases. This project showcases my ability to create a user-centric application, manage data efficiently, and deliver high-quality, maintainable code.

## Key Features
- **Recipe Management:** Easily add, edit, or delete recipes wit a simple user interface.
- **Search & Filter:** Users can search for recipes by name with dynamic filtering capabilities.
- **Persistent Data Storage:** All recipe data is stored in a recipes.dat file, providing a lightweight and reliable method for data persistence. 
- **Clean & Intuitive:** A responsive JavaFX-based GUI, with thoughtful design and user-friendly navigation, making the application easy to use.
- **Confirmation & Validation:** Built-in confirmation dialogs ensure safety when exiting application windows. 

## Technologies & Tools
This project demonstrates my proficiency in Java, JavaFX, and file handling for persistent storage. Below is a breakdown of the key technologies used:
- **Java SE 21:** The core programming language used to build the application login.
- **JavaFX:** A modern framework used to build the graphical user interface (GUI), providing a smooth user experience.
- **File-based Data Storage:** Instead of using a database like MySQL, I've implemented a file-based approach using a simple .dat file for persistent data management, demonstrating my understanding of handling file I/O in Java.
- **Maven:** Managed project dependencies using Maven for streamlined builds and dependency management.

## Installation & Setup
### 1. Prerequisites
Before installing Culinary Cache, ensure you have the following installed:
- **Apache Maven**
- **Git**

### 2. Clone repository
```
git clone https://github.com/megrivh/Culinary-Cache.git
```

### 3. Navigate to project Folder
```
cd Culinary-Cache
```

### 4. Build the application
```
mvn clean install
```
This will download all dependencies and compile the application. If successful, you will see BUILD SUCCESS.

### 5. Run the application
```
mvn javafx:run
```
This will launch the Culinary Cache with the GUI interface.

## Application Walkthrough
![Window upon launching Culinary Cache for the first time.](../images/open-screen.png)
**Culinary Cache** is designed with a focus on simplicity and usability. Below are some key interactions:

- **Adding a Recipe:**
    - Click the **Add Recipe** button to open a form where you can enter a new recipe name, category, ingredients, and instructions.
    - After filling out the form, you can save the recipe, which will be added to the list and stored in the recipes.dat file.
    ![Adding a recipe form.](../images/add-recipe1.png)
    ![Table shows the recipe was added.](../images/add-recipe2.png)
- **Editing a Recipe:**
    - Select any recipe from the list and click the **Edit Recipe** button. The form will open pre-filled with the recipe's data, allowing you to make modifications and save them.
- **Deleting a Recipe:**
    - A simple **Delete Recipe** button allows you to remove recipes.
- **Searching and Filtering Recipes:**
    - You can quickly search for a recipe by name using the search bar. The results will update dynamically as you type!
    ![Dynamic filtering as the user types.](../images/search-recipe.png)

Data Persistence:
- All recipes are stored in the recipes.dat file, located in the project directory. The data is read when the appliction starts and saved back to the file when a recipe is added, edited, or deleted. This approach allows for a lightweight yet effective method for persisting user data without the overhead of database management systems.

## Demo
Video coming soon!

## Why This Project?
This project serves as a reflection of my skills in the following areas:
- **Java & JavaFX:** I used Java and JavaFX to create a fully functional desktop application with a modern user interface.
- **File Handling:** Rather than relying on a database, I implemented file-based data persistence, demonstrating my ability to manage data in an efficient and lightweight manner.
- **UI/UX Design:** I've focused on creating an intuitive and user-friendly interface, ensuring a seamless experience for anyone using the app.

## Contributing
If you'd like to contribute to this project, feel free to fork the repository, make your changes, and submit a pull request. I appreciate any feedback and improvements!





