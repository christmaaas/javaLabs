# Wikipedia API Application

This repository contains a simple REST API application that provides wikipedia page info.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)

## Introduction

This is a basic REST API application built using [Spring Boot](https://spring.io/projects/spring-boot) framework. The application allows users to retrieve wikipedia information for a specific request by making HTTP requests to predefined endpoints.

## Features

- Get wikipedia page information.

## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot): Web framework for building the REST API.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Data access framework for interacting with the database.
- [H2 Database](https://www.h2database.com/): Embedded database for local development.
- [Wikipedia API](ru.wikipedia.org/w/api.php/): External API for wikipedia.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java (version 17 or higher)
- Maven
   
The application will start on http://localhost:8080.

## Usage

### Endpoints

- Get Wikipedia page:
  
    GET /search?request={request_name}
  

  Retrieves wikipedia page information for the specified request.

  Example:
    GET /search?request=Cristiano Ronaldo
  

### Configuration

The application uses the [Weatherbit API](https://en.wikipedia.org/w/api.php) to fetch wikipedia data. You need to obtain an API key from Wikipedia and configure it in the application.properties file.

# application.properties

# Wikipedia API 
ru.wikipedia.org/w/api.php

## Contributing

Contributions are welcome! If you find any issues or have improvements to suggest, feel free to open an issue or create a pull request.
