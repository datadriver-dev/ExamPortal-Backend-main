# ExamPortal-Backend

Major dependancies used - Spring Data JPA, Spring Security

Sping JPA Hibernate is used to communicate with MySQL datbase  used to store data such as user, category, quiz and question details.

Spring Security with JWT is used for securing all the APIs that require authorisation, role passed in jwt and checked in any subsequent requests that require authorisation.

Models (each model has it's table in the MySQL database) defined are as follows
* User
* Role
* User Role
* Category
* Quiz
* Question

Following relationships are established in the database
* Many-to-one relationship between users and roles, each user can have only one role (either user or admin), many users can be assigned the same role. This is achieved using intermediate user role model which maps keys user_i and role_id from user and role tables respectively. 
* One-to-many realtionship between categories and quiz, multiple quizzes in each category but a quiz can only be part of a single category.
* One-to-many relationship between quizzez and questions, multiple questions in each quiz but a question can only be part of a single quiz.
