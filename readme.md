# University Management System

The University Management System is a Java application that allows users to interact with a MySQL database to manage information about university departments and courses. This application provides functionalities for retrieving department information, adding new courses, and deleting existing courses. It uses JDBC (Java Database Connectivity) to connect to a MySQL database.

## Features

1. **Retrieve Department Information:** Users can retrieve information about university departments, including department name and building. This information is displayed in alphabetical order.

2. **Add New Courses:** Users can add new courses to the database. To do this, they need to provide the course ID, course title, department name, and the number of credits for the course.

3. **Delete Existing Courses:** Users can delete courses from the database by specifying the course ID they want to remove.

## Prerequisites

Before using the University Management System, you need to ensure that you have the following prerequisites:

- Java Development Kit (JDK)
- MySQL Server
- MySQL JDBC Driver (included in the project)

## Setup

1. **Database Configuration:** Make sure you have a MySQL database set up where you want to store the department and course information.

2. **MySQL JDBC Driver:** Ensure that the MySQL JDBC driver JAR file is included in your project.

3. **Modify Database Connection Information:** In the Java code, you will need to modify the following line to provide your MySQL database connection details:
   
   ```java
   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?serverTimezone=UTC", username, password);
   ```

   Replace `"jdbc:mysql://localhost:3306/university?serverTimezone=UTC"` with the URL of your MySQL database. You can also modify the database connection parameters, such as the username and password.

## Usage

1. **Retrieve Department Information:**
   - Run the application.
   - Enter your MySQL username and password when prompted.
   - The application will display a list of departments with their names and buildings.

2. **Add New Courses:**
   - Follow the steps for retrieving department information.
   - Enter course details when prompted.
   - The new course will be added to the database.

3. **Delete Existing Courses:**
   - Follow the steps for retrieving department information.
   - Enter the course ID that you want to delete.
   - The specified course will be deleted from the database.

## Notes

- The application uses the MySQL JDBC driver to connect to your database. Ensure that you have it included in your project's classpath.

- Error handling and input validation are minimal in this example and can be enhanced for production use.

## Contributing

Feel free to contribute to this project by improving error handling, adding features, or creating a more user-friendly interface. Pull requests are welcome.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to [contact us](mailto:Markow2010@yahoo.com).

---

**Disclaimer:** This project is for educational and demonstration purposes. Use it responsibly and in compliance with any relevant university or database management policies.
