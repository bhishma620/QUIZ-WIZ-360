
# Quiz Application

This Quiz Application is a comprehensive platform designed for creating, managing, and taking quizzes. Built with Spring Boot, JPA (Java Persistence API), REST API, and MySQL, it provides a seamless experience for both administrators and users.

## Features

- **Quiz Creation:** Administrators can create quizzes by specifying the category, number of questions, and title.
- **Question Management:** Manage questions by adding, editing, and deleting them. Categorize questions for easy organization.
- **Quiz Taking:** Users can take quizzes in a user-friendly interface. Submit responses for instant evaluation.
- **Result Calculation:** Automatically calculate and display quiz results based on user responses.

## Getting Started

To get started with the Quiz Application, follow these steps:

1. Clone the repository to your local machine:

    ```
    git clone <repository_url>
    ```

2. Configure the database connection settings in `src/main/resources/application.properties`. Update the `url`, `username`, and `password` properties according to your MySQL database configuration.

3. Build the application using Maven:

    ```
    mvn clean package
    ```

4. Run the application:

    ```
    java -jar target/quiz-application.jar
    ```

5. Once the application is running, access the API endpoints using a web browser or API testing tool. The base URL is `http://localhost:8080/`.


## API Reference

### Questions

#### Get All Questions

- **Endpoint:** `GET /question/allQuestions`
- **Description:** Retrieve all questions.
- **Response:** `ResponseEntity<List<Question>>`

#### Get Questions by Category

- **Endpoint:** `GET /question/category/{category}`
- **Description:** Retrieve questions by category.
- **Path Parameter:** `category` (String)
- **Response:** `ResponseEntity<List<Question>>`

#### Add Question

- **Endpoint:** `POST /question/add`
- **Description:** Add a new question.
- **Request Body:** `Question`
- **Response:** `ResponseEntity<String>`

### Quiz

#### Create Quiz

- **Endpoint:** `POST /quiz/create`
- **Description:** Create a new quiz.
- **Request Params:**
  - `category` (String): Category of the quiz.
  - `noQ` (Integer): Number of questions.
  - `title` (String): Title of the quiz.
- **Response:** `ResponseEntity<String>`

#### Get Quiz Questions

- **Endpoint:** `GET /quiz/get/{id}`
- **Description:** Get quiz questions by ID.
- **Path Param:** `id` (Integer)
- **Response:** `ResponseEntity<List<QuestionWrapper>>`

#### Submit Quiz

- **Endpoint:** `POST /quiz/submit/{id}`
- **Description:** Submit a quiz with responses.
- **Path Param:** `id` (Integer)
- **Request Body:** List of `Response` objects.
- **Response:** `ResponseEntity<Integer>`


## Response Format

Responses are returned in JSON format following a consistent structure throughout the API. HTTP status codes are utilized to convey the outcome of each request.

## Error Handling

The API handles errors gracefully, providing appropriate HTTP status codes and error messages to aid in troubleshooting and debugging.

---

**Note:** Replace placeholders (e.g., `{Id}`, `{category}`) with actual values when making API requests.
