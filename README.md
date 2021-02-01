# THE MARS ROVER CHALLENGE

Project description is in a file: Technical Test_Backend_GrubTech.pdf

## Build and execute

1. Clone project from the repository;
2. Make sure all prerequisites are installed on your workstation (see section below);
3. You can change initial inputs and outputs by editing appropriate files:
   - src/main/resources/test_inputs.txt;
   - src/main/resources/expected_outputs.txt;
4. Build executable jar file:
```
mvn clean install
```
5. Execute the jar:
```
java -jar target/mars_roller_challenge-1.0-SNAPSHOT.jar
```
Program will print out data from input and output files and processed result in 'Actual Outputs' section.
Processed result contains final co-ordinates of the rovers in sequential order.
In order input data is invalid program will throw appropriate exception:
- GridPositionBusyException
- GridPositionOutOfRangeException
- InputFileReadException
- IllegalArgumentException

Supported error messages are in the file:
- src/main/java/com/grubtech/exception/ErrorMessages.java

```
Test Inputs:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Outputs:
1 3 N
5 1 E
Actual Outputs:
1 3 N
5 1 E
```

### Prerequisites

Before building and running the challenge make sure listed tools are installed on you machine:

```
JRE 8 or later
Apache Maven
```

### Installing

Please follow next steps to install minimal set of tools to build and run the project

Note: for development you will need JDK installed

```
### 1. Install JRE ###
sudo apt install openjdk-8-jre
### 2. Install Maven ###
sudo apt install maven
```

## Running the tests

```
mvn test
```

## Author

* **Yuliia Makarchuk** - [the_mars_roller_challenge](https://github.com/fantagero/the_mars_roller_challenge)