# MayFlower Test Project

## About
The stack of test-project is:
- Java 17
- Maven
- TestNG
- Selenium with ChromeDriver
- Rest-Assured
- Allure-report

## Pulling the Docker Image
To pull the Docker image of this project, run:

```bash
docker pull nastasvetik/test-project:latest
```

## Running the Docker Image
To run the Docker image, execute:

```bash
docker run -it -p 8003:8003 -e "baseUserLogin=LOGIN"  -e "baseUserPassword=PASSWORD"  --name CONTAINER_NAME nastasvetik/test-project:latest
```
On container start the tests will run.
After tests run the Allure report will be generated and Allure server started.
The report will be available on the localhost:8003 or 127.0.0.1:8003

Note 1: It supposed that the GUI of the host will be used (Tests will run not in the headless mode)
Note 2: Do not attempt to run it on Windows Subsystem for Linux (WSL). Your will regret.

## Cloning the Project
To clone this project locally, use the following command:

```bash
git clone git@github.com:nastaSvetik/MayFlower.git
```

## Adding config.test.properties File
To set up the configuration file, follow these steps:
1. Make a copy file of `config.example.properties` that is in ./src/main/resources in the same directory
2. Rename the copied file to `config.test.properties`.
3. Fill in the necessary values in `config.test.properties`. 
## Running project locally
Make sure that your already have:
- jdk 17
- appropriate maven
- appropriate system envs are set correctly

To run tests, run:

```bash
mvn clean test
```
To get allure-report, run:
```bash
mvn allure:serve
```
Click the link provided in the output to open the page wih report in browser