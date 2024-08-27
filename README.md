# P.A.D. (People at desks)  
In this project we have a system that can track students, their chairs, the tables which they sit at and the rooms containing the tables.  
The program can also provide the following information:   
 - What is the full name of the student who has to clean next in a given room?
 - Find the student to a chair by id
 - Who is the oldest student sitting at the 3rd table in a room?

Here are the key information for the classes:  
## Student:
 - Has first name
 - Has last name
 - Has age
 - Has cleaning order (a number representing how close a student is to be the cleaner in the room)
 - Can provide full name
## Chair:
 - Has id
 - Table:
 - Has students with chairs (can only hold 4 pairs -> technical limitation)
## Room:
 - Has tables (has to be unique and insertion order matters (can only hold 10 -> technical limitation)
 - Has students in cleaning order (can only hold 40 -> technical limitation)
## School:
 - Has rooms (has to be unique, order does not matter) (can hold base rooms + 10 -> technical limitation)
 - Can tell the name of the student who has to clean a given room next
 - Can give back the student who sits at a given chair by id
 - Can give back the oldest student in a room for a table number

The project currently has a working version uploaded for you.  
Your job is to refactor the classes to use the correct collections and data structures instead of arrays.  
Eliminate all the technical limitations highlighted in the class description.  
You can change the classes in any way as long as the tests still run successfully without changing the tests!

## Helpful links: 
Iterate through map: https://www.baeldung.com/java-iterate-map  
Using priority queue: https://www.baeldung.com/java-priorityqueue
