# Password Generator GUI
The Password Generator GUI is a Java application designed to generate random passwords based on user-defined criteria. It provides a graphical interface where users can specify the length of the password and choose its difficulty level (Easy, Medium, or Hard). Depending on the difficulty level selected, the generated password may include letters (both uppercase and lowercase), digits, and special characters.


## Features
 - User Input: Allows users to specify the length of the password.
 - Difficulty Levels: Offers three levels (Easy, Medium, Hard) which influence the composition of the generated password.
 - Random Generation: Utilizes Java's Random class to generate passwords randomly based on selected criteria.
 - Graphical Interface: Provides a simple and intuitive GUI using Swing components (JFrame, JLabel, JTextField, JTextArea, JComboBox, JButton).
 - Error Handling: Validates user input to ensure correct formatting of password length and provides feedback in case of errors.
## Technology Stack
- Programming Language: Java
- Graphical User Interface (GUI) Toolkit: Swing

## Usage
 - Enter the desired length of the password.
 - Select a difficulty level (Easy, Medium, or Hard).
 - Click on the "Generate" button to create a password based on your selections.
 - The generated password will be displayed in the text area.
 - Close the application using the "Close" button when finished.
## How to Run

1. Clone the repository to your local machine.
2. Open a terminal window and navigate to the project directory.
3. Compile the Java file (passwordGeneratorGUI.java) and execute the generated class file to launch the Password Generator GUI.:

```bash
  javac passwordGeneratorGUI.java
  java passwordGeneratorGUI
```

