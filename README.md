
# Online Voting System

Welcome to the **Online Voting System** project! This application is designed to provide a secure and user-friendly platform for conducting elections online. Built with Java and JDBC for database connectivity, it features a comprehensive administrative interface, secure login mechanisms, and real-time vote tracking.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
  - [User Interface](#user-interface)
  - [Admin Interface](#admin-interface)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Features

- **User Authentication**: Secure login for administrators and voters.
- **Admin Dashboard**: Manage elections, candidates, and view real-time voting statistics.
- **Voting Interface**: Simple and intuitive voting process for users.
- **Database Connectivity**: Uses JDBC for robust database interactions.
- **Face Detection**: Integrated face detection for admin login security(not done yet).

## Technologies Used

- **Java**
- **JDBC**
- **Swing (Java GUI)**
- **MySQL** (or any other preferred database)

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [MySQL Database](https://www.mysql.com/downloads/)
- [Eclipse IDE](https://www.eclipse.org/downloads/) (or any preferred Java IDE)

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AminNeji/online-voting-system.git
   cd online-voting-system
   ```

2. ### Set Up the Database

2.1. **Create a Database**:
   - Create a database named `ovs`.
   - Import the provided SQL script to set up the necessary tables and data.
   For the complete SQL setup script, please refer to [sql/setup.sql](Online_Voting_System/ovs.sql).

2.2**Import SQL Script**:
   - Using phpMyAdmin:
     - Open phpMyAdmin and connect to your database.
     - Select the `ovs` database.
     - Click on the `Import` tab.
     - Choose the SQL file (`sql/setup.sql`) from your computer.
     - Click on `Go` to start the import process.

3. **Configure Database Connection**:
   - Update the database connection details in the file that uses the DataBase.
   ```java
   // Example configuration
   private static final String URL = "jdbc:mysql://localhost:3306/ovs";
   private static final String USER = "root";
   private static final String PASSWORD = "yourpassword";
   ```

### Running the Application

1. **Open the Project**:
   - Open the project in your preferred Java IDE (e.g., Eclipse).
   
2. **Build and Run**:
   - Build the project and run the `Main` class.
   - The admin login interface will appear first.

## Usage

### User Interface

- **Login Screen**: Users can log in using their credentials.
- **Voting Screen**: Users can view available elections and vote for their preferred candidates.

### Admin Interface

- **Dashboard**: View and manage elections, candidates, and users.
- **Add/Edit/Delete**: Create new elections, add candidates, and manage user data.
- **Statistics**: Real-time display of voting statistics and results ( not done yet ).

  ## Project Screenshots

![Login Screen](Online_Voting_System/src/icons/userlogin.png)
*Login Screen*

![Admin Dashboard](Online_Voting_System/src/icons/admindinterface.png)
*Admin Dashboard*

![User Dashboard](Online_Voting_System/src/icons/userinterface.png)
*User Interface*


## Contributing

We welcome contributions to enhance the Online Voting System! To contribute:

1. Fork the repository.
2. Create a new branch.
   ```bash
   git checkout -b feature-branch
   ```
3. Make your changes and commit them.
   ```bash
   git commit -m "Description of the changes"
   ```
4. Push to your forked repository.
   ```bash
   git push origin feature-branch
   ```
5. Create a pull request detailing your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to all contributors and collaborators for their valuable input and suggestions.
