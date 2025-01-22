# Schedule App

Welcome to the Schedule App repository! This application helps users organize their daily events and tasks efficiently.

## Features

### 1. Adding Events

Users can easily add new events by specifying the following details:

- Event name
- Date
- Start and end time
- Event category (e.g., work, health, relaxation, sports, etc.)
- Additional description or information

### 2. Event Recurrence

Users have the flexibility to choose the recurrence of events:

- One-time events
- Repeating events with a specified frequency (e.g., every 2 weeks, every week, daily, every 2 days, etc.)
- Custom recurrence with a user-defined number of days

### 3. Priority Assignment

A priority system is implemented for events (high, medium, low). Events can be sorted based on their priority.

### 4. Editing and Deleting

Users can edit existing events or choose to delete them, providing flexibility in managing their schedule.

### 5. Statistics

Track the statistics of planned and completed events, as well as the breakdown of planned and completed events within a
selected category.

### 6. Work-life Balance

Generate a percentage report for the day's schedule, categorizing events into various aspects of life.

### 7. To-Do Tasks

Add to-do tasks with deadlines as part of the daily schedule plan.

## Profiles

### 1. User Profile

- **Objective:** Basic profile for normal users.
- **Features:** Uncomplicates the daily routine with an effortlessly intuitive interface.

### 2. Sender Profile

- **Objective:** For users sending data or information by RabbitMQ.
- **Features:** Includes functionalities related to sending messages - specific methods available for this profile.

### 3. Receiver Profile

- **Objective:** Designed for users receiving scheduled data from senders.
- **Features:** Enables the efficient reception and integration of scheduled events shared by others, ensuring a smooth
  collaborative experience.

In the Schedule App, the Sender and Receiver profiles work collaboratively to enhance communication and information
sharing. The Sender initiates the sharing process by securely transmitting messages, alerts etc. The Receiver has a set
of methods for different types of queues. Whether you're sending important updates or receiving messages, the Schedule
App's Sender and Receiver profiles work together to streamline collaboration and improve overall user experience.
