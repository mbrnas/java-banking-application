Simple Java Banking App

This repository contains a simple Java banking application implemented using the Model-View-Controller (MVC) architectural pattern. The application allows users to register, login, and perform basic banking operations such as depositing and withdrawing money.
Features

    User Registration: Users can create an account by providing their personal information, such as name, email, and password. The registration data is securely stored in a connected database.

    User Login: Registered users can log in using their email and password. The login credentials are verified against the stored data in the database.

    Account Dashboard: After successful login, users are presented with an account dashboard that displays their account information, including balance and transaction history.

    Deposit Money: Users can deposit money into their account by entering the desired amount. The deposited amount is added to their account balance and recorded in the transaction history.


    Withdraw Money: Users can withdraw money from their account by entering the desired amount. The withdrawn amount is subtracted from their account balance, provided sufficient funds are available, and the transaction is recorded.


Installation

To run the banking application locally, follow these steps:

    Clone the repository to your local machine:

    git clone https://github.com/your-username/banking-app.git

    Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ IDEA).

    Build and compile the project to generate the executable Java bytecode.

    Ensure that you have a compatible database management system (DBMS) installed and running (e.g., MySQL, PostgreSQL).

    Configure the database connection details in the application's configuration file (e.g., src/main/resources/application.properties). Update the database.url, database.username, and database.password properties with your database credentials.

    Run the application.

Dependencies

The following dependencies are used in this banking application:

    Java 8 or higher
    JDBC (Java Database Connectivity) library
    MySQL Connector/J (or any other compatible database driver)
    Maven (for dependency management)

All the necessary dependencies are included in the project's pom.xml file and will be automatically downloaded by Maven during the build process.
Usage

Once the application is up and running, you can access it through a web browser or by sending HTTP requests to the appropriate endpoints. The application follows a server-client architecture, where the server handles the requests and responds with the corresponding views or JSON data.

To interact with the application, follow these steps:

    Open your web browser and navigate to http://localhost:8080 (assuming the application is running locally on the default port).

    Register a new account by providing your personal information.

    Log in using the registered email and password.

    Explore the account dashboard to view your balance and transaction history.

    Deposit or withdraw money using the respective buttons or forms.

Limitations

Please note that this banking application is a simple demonstration and should not be used in a production environment. It has the following limitations:

    Lack of authentication and authorization mechanisms: The application does not implement advanced security features, such as encryption, secure token-based authentication, or role-based access control. It is recommended to enhance the security aspects before deploying the application to a live environment.

    Limited error handling: The application may lack comprehensive error handling, especially when it comes to database connectivity issues, input validation, or unexpected errors. Additional error handling mechanisms can be implemented to provide a more robust user experience.

Contributing

Contributions to this banking application are welcome. If you would like to contribute, please follow these steps:

    Fork the repository.

    Create a new branch for your feature or bug fix.

    Make your changes and commit them to your branch.

    Push the changes to your forked repository.

    Submit a pull request to the main repository.

Please ensure that your contributions align with the goals and scope of this project.

Contact

If you have any questions or suggestions regarding this banking application, please feel free to reach out to the project maintainer at matija.brnas@gmail.com.

Thank you for using this simple Java banking app!
