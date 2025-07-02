# Global Dorm

## Project Overview

**Global Dorm** is a web application designed to assist international students relocating to the UK in finding suitable accommodation. It allows users to:

- Browse available rooms with detailed listings.
- View key information such as pricing, safety (e.g. crime statistics), and other relevant factors.
- Apply for accommodations directly through the platform.
- Track the history and status of their applications.
- Cancel pending applications if needed.

The goal is to streamline the housing search process and empower students to make informed decisions during their move abroad.

---

## Tech Stack

### Frontend
- **HTML**
- **JavaScript**

### Backend
- **Java**
- **Microservices Architecture**
  - Built with multiple Java microservices.
  - Integrated both custom-built and third-party APIs.
- **Orchestrator**
  - A central Java service coordinating all microservices to form a cohesive application.
- **MongoDB Atlas**
  - Cloud-hosted MongoDB used for storing room listings and user applications.
  - Connected through MongoDB URI and accessed via the Orchestrator.

### Data Handling
- **JSON**
  - Used for data exchange between APIs and frontend.
  - Ensured smooth parsing and dynamic rendering of information.

---

## Key Features

- Search and filter available rooms.
- View safety data for neighborhoods.
- Apply for accommodations and manage application status.
- Fully integrated backend with real-time updates from the database.

---

## Video Demo

Watch the full demo on [YouTube](https://youtu.be/K7h_73U_Oiw).

[![Watch the video](https://img.youtube.com/vi/K7h_73U_Oiw/0.jpg)](https://youtu.be/K7h_73U_Oiw)

*This short demonstration covers the main features and demonstrates both the user-facing, backend, and admin functionality.*
---

## 🚀 Getting Started

This project was developed using **NetBeans 24** and is configured to run on **Apache Tomcat**. You can run the application locally in your IDE or deploy it on a server using a generated `.WAR` file.

### 🔧 Requirements
- Java (JDK 17+)
- NetBeans 24 (or any Java IDE that supports web apps)
- Apache Tomcat
- MongoDB Atlas (for database)

---

### 🗄️ MongoDB Setup

You will need to set up a **MongoDB Atlas** instance and create a database with the following **four collections**:

1. `rooms`  
   - Must be manually populated before use.  
   - Example format:  
     ![image](https://github.com/user-attachments/assets/5e941df7-2ea1-4529-94ee-b91525e404a4)  
   - Room availability is automatically updated when a user is accepted for an application.

2. `applications`  
   - Automatically populated when a user applies for a room.

3. `history`  
   - Automatically managed by the application to track accepted/rejected applications.

4. `users`  
   - Populated when users fill out and submit their profile details via the frontend.

> **Note:** There is a hidden **admin page** accessible at `/admin.html`, used to approve or reject user applications.

---

### Running the Project

1. Clone the repository.
2. Import the project into NetBeans (or your preferred Java IDE).
3. Set up your MongoDB connection string in the configuration.
4. Run the project on Apache Tomcat.
5. Access the app via your `localhost` port.

---



