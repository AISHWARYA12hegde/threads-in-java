**Java Multithreaded Socket Project**

🚀 *Overview*



A simple Java client-server socket program using multithreading where multiple clients connect to a server and receive a response.

⚙️ Features
TCP Socket communication
Multithreaded server (handles multiple clients)
Multi-threaded client simulation
Basic request-response system

*How to Run*
*Server*

javac Server.java
java Server
*Client*
javac Client.java
java Client
🧠 Concepts Used
Java Sockets
Multithreading
Client-Server Architecture



//problems that i faced building this
“While working on this project, I faced a few practical challenges. Initially, my server wasn’t sending any response to the client, and the client appeared to hang. After debugging, I discovered it was due to an incorrect file path, which caused a FileNotFoundException on the server side. Since the server was handling multiple client requests using threads, the error kept repeating under load. Fixing this helped me understand how file handling and relative paths work in Java.

I also learned how blocking I/O works in socket programming, because the client was waiting for a response when the server wasn’t sending anything. Another challenge was handling multiple clients efficiently — instead of creating a new thread for each request, I improved the design using a thread pool with ExecutorService, which made the server more scalable.

Finally, while using JMeter for load testing, I initially found it difficult to configure threads and interpret results, but I learned how to simulate concurrent users and analyze performance metrics like throughput and response time