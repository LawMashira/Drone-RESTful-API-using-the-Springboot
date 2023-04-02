
DRONE PROJECT

This project is about a drone application that registers new dronesused for carrying medication




BUILD STATUS 

Basically, the project has the contoller class the "DroneEntityClass and MedicineController" for recieving http requests from postman and map them to the related data.
The model package has three JavaBean Classes "DroneHistory,DroneEntityClass and MedicineEntity"- these classes are validated with the expexted data.
Repositories are also available in the form of DroneHistoryRepository,MedicineRepository and DroneRepository
The service class is implemented by the ServicesInterface_Implementation class where there are methods for peforming specific roles.
The in-memeory H2  database was used for testing data insertion purposes.

CODE STYLE
the ccode was written following Java coventions especially in naming variables and methods

FRAMEWORK
The Spring Boot frame work was used.
