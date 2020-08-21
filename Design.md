# ***Challenge 2***

####Designing a method to display student list without duplicates

In our design we have to understand the importance of avoiding duplicated code,
try to avoid excessive use off literals.

To start things off, we have to decide where do we want to declare
our method. Since typically in real life, university is has a knows a relationship between the students, and the classes.
Therefore, when a student enrols in a unit, the students details will be received by
the university. In conclusion, the method to display the students list
should be placed in University class.

##### An algorithm and pseudocode as to Roughly how this Method will be implemented

1) Define method's body in University class
2) Declare just one local variable of array type to store the lists of students
3) For each unit available inside the university class, get the enrolled students list
4) Now for each student list inside a unit, add each unique student into the local variable declared
5) After Step 3 and Step 4 are repeated for each unit available in the university, return the array.


A pseudocode to define the algorithm:

methodbody: 

            let array=[];

            foreach unit in univeristy;
            
                  foreach students in studentlist in unit;
                  
                       if student not in array;
                       
                           add student to array;
                           
            return array

Only one local variable is declared, no duplicated codes, university is
responsible for properties in students

