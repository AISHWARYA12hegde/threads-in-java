🚀 Multithreaded Socket Project (Java)
📌 Overview

This project is a Java-based client-server socket application that demonstrates multithreading and concurrent request handling. Multiple clients can connect to the server simultaneously, and the server processes each request using separate threads.

It helps understand network programming, concurrency, and performance under load.

⚙️ Features
TCP-based Client-Server communication using Java Sockets
Multithreaded server supporting multiple concurrent clients
Thread pool implementation using ExecutorService
Basic request–response system between client and server
Load testing using Apache JMeter
🏗️ Architecture
Server: Listens for incoming client connections and processes requests concurrently
Client: Connects to server and sends messages
Thread Pool: Manages multiple client requests efficiently without creating excessive threads
▶️ How to Run
1. Compile the files
javac Server.java
javac Client.java
2. Start the Server
java Server
3. Run the Client
java Client

You can open multiple terminals to simulate multiple clients.

🧠 Concepts Used
Java Sockets (TCP Communication)
Multithreading in Java
ExecutorService (Thread Pooling)
Client–Server Architecture
Blocking I/O
Load Testing with Apache JMeter
📊 Load Testing
Simulated 50+ concurrent clients using Apache JMeter
Evaluated system stability under concurrent load
Observed response handling under high traffic conditions
🚧 Challenges Faced & Learnings

During development, I encountered several practical issues:

Initially, the server was not sending responses to clients due to a FileNotFoundException caused by incorrect file paths. This helped me understand the importance of correct file handling and relative paths in Java.
I observed how blocking I/O works in socket programming, where the client waits indefinitely if the server does not respond properly.
To improve scalability, I moved from creating a new thread per request to using ExecutorService thread pools, which significantly improved performance and resource management.
While using Apache JMeter, I initially struggled with configuring virtual users and interpreting metrics. Over time, I learned to analyze throughput, latency, and response time under concurrent load.
📌 Future Improvements
Add GUI or web-based client interface
Implement authentication between client and server
Add message logging system
Extend to chat-room style application
👨‍💻 Tech Stack
Java 8+
Java Sockets
Multithreading (ExecutorService)
Apache JMeter
⭐ Summary

This project demonstrates how a basic socket system can be scaled using multithreading and how real-world issues like blocking I/O, file handling errors, and concurrency challenges are handled in practice.
