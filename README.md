# Currency Converter Application

This is a Spring Boot application for currency conversion and retrieving exchange rates.

## Features

- Retrieve real-time exchange rates for a given base currency.
- Convert an amount from one currency to another.
- Swagger UI for API documentation and testing.

## Requirements

- Java 21
- Maven

## Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/currency_conver.git
   cd currency_conver
   ```

2. Build the project:

   ```sh
   mvn clean install
   ```

3. Run the application:

   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### Get Exchange Rates

- **URL:** `/api/rates`
- **Method:** `GET`
- **Query Parameters:**
  - `base` (optional, default: `USD`): The base currency code.

### Convert Currency

- **URL:** `/api/convert`
- **Method:** `POST`
- **Query Parameters:**
  - `from`: The currency code to convert from.
  - `to`: The currency code to convert to.
  - `amount`: The amount to convert.

## Swagger UI

The Swagger UI is available at `/swagger-ui.html` for API documentation and testing.

## Running Tests

To run the tests, use the following command:

```sh
mvn test
```

## Configuration

The application can be configured using the application.properties file located in the resources directory.

```properties
spring.application.name=currency_conver
springdoc.api-docs.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
```
