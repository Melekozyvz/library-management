# Library Management Application

This is a simple Spring Boot application developed to practice
clean service-layer design and unit testing.

The main focus of this project is:
- validating business rules before persistence
- keeping the service layer testable and clean
- writing meaningful unit tests with Mockito

## Features

- Add a new book to the system
- Prevent saving books with the same content
- ISBN is treated as a unique identifier
- Business rules are separated from the service logic

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- JUnit 5
- Mockito

## Design Approach

- Service layer contains only orchestration logic
- Validation rules are defined via a common interface
- Rules can be extended without modifying the service
- Repository layer is mocked in unit tests

## Testing

- Unit tests are written for the service layer
- Mockito is used to mock dependencies
- ArgumentCaptor is used to verify passed objects
- Tests are silent when successful, as expected in JUnit

## Notes

This project is created mainly for learning and self-improvement purposes.
