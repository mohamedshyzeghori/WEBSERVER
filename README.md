# WEBSERVER

## Project Title: Web Server Implementation

### Overview
This project implements a simple web server in Java that can handle client requests using three different threading models: Single-threaded, Multi-threaded, and Thread Pool. The server responds to client requests with a greeting message. The performance of each model can be tested using Apache JMeter.

### Features
- **Single-threaded Server**: Handles one client at a time.
- **Multi-threaded Server**: Creates a new thread for each client connection.
- **Thread Pool Server**: Uses a fixed-size thread pool to manage client connections efficiently.
- **JMeter Integration**: Performance testing capabilities using Apache JMeter.

### Technologies Used
- Java 21
- Apache JMeter
- Maven (for dependency management)

### Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**:
   Ensure you have Java 21 installed. Use Maven to manage dependencies if needed.

3. **Build the Project**:
   Compile the Java files using your IDE or command line:
   ```bash
   javac -d out src/*.java
   ```

### Usage
1. **Run the Server**:
   - For Single-threaded:
     ```bash
     java -cp out Server
     ```
   - For Multi-threaded:
     ```bash
     java -cp out Server
     ```
   - For Thread Pool:
     ```bash
     java -cp out Server
     ```

2. **Run the Client**:
   You can run the client multiple times to test the server:
   ```bash
   java -cp out Client
   ```

### Testing with JMeter
1. **Install Apache JMeter**: Download and install JMeter from the [official website](https://jmeter.apache.org/).

2. **Create a Test Plan**:
   - Open JMeter and create a new test plan.
   - Add a Thread Group to simulate multiple clients.
   - Configure the Thread Group as per your need , here i configure  to send **60,000 requests per minute** using the TCP Sampler.
   - Set the server's IP address to `localhost` and the port to `8010`.

3. **Run the Test**: Execute the test plan to measure the performance of each server implementation.

---
