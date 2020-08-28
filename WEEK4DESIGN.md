#**Designing a Mark class**

**Attributes of a Mark class:**

totalMarks:double

comments: String

------------------------------------------------------------------------

totalMarks is the total marks the student achieved for that particular assessment

comments is a comments added by the marker

-----------------------------------------------------------------------

**Methods of a Mark class should have:**

setComments: There is one parameter to this method, which will be a string
and the attribute comments will be set what this parameter is. Return void.

getComments: This method is to return the attribute comments. No parameters needed.


description: This method returns a description of total marks the student achieved along
with the comments. This method takes no parameters. A concatenated string of total mark attribute and
comments is returned.

setTotalMarks: There is one parameter to this method which is a double numerical value. This method
sets the total mark to the parameter if and only if the total mark passes the validation check
which is more than zero and less than 100. Else it will raise an exception.
There is no return value for this method.

getTotalMarks: This method returns the totalMarks attribute. No parameters needed. Returns a type double.

______________________________________________________________________________

#**Modifying Unit Class**

A new method isEnrolled that takes in a String parameter student ID and returns a boolean whether a student is enrolled 
by transversing through the Arraylist returned by getEnrolledStudentList.

A new method completedAllAssessments that takes in a String parameter and returns a boolean if students completed all
assessments in assessments scheme.

A new method needs to be created, we will name it getStudentTotalMarks which returns a double.

In this method, a String parameter of studentID is needed. It will first then check
for whether the student is enrolled in that unit, else it will raise an exception.
If the student is enrolled in that unit,it will then check for the whether students have
completed all assessments for that unit, if the student has completed, then only
it will return the total marks of that unit.

Algorithm:

               if student isEnrolled and completedAllAssessements
                   return calculateStudentTotalMarks
                


Then, setStudentMark method needs to be created.

We will make a method setStudentMark and the method has three parameters, one is String studentID, a Mark object and another is
Assessment object. It will check the assessment object is in the assessment scheme of that unit and whether that student
is enrolled. If he is, then, we called the method of assessment to add student marks by passing in studentID and Mark 
object to it. No return value is needed.

Algorithm:

                  if assessment in AssessmentScheme and student isEnrolled:
                             assessment.addStudentMarks

We will make further modifications to Unit class to calculate the total marks of the student.
To do that we will add a new method called calculateStudentTotalMarks. It takes in a String parameter studentID, 
and in a loop, we loop through assessment scheme and for each assessment in that object, it gets the mark of the student
in assessment and it sums them up and return it.
 

Overall modifications to the Unit class:

a) Adding getStudentTotalMarks, setStudentMark,calculateStudentTotalMarks method, isEnrolled,completedAllAssesments

--------------------------------------------------------------------------------------------------------------------

#**Modifying Assessment class**

Add attribute studentMarks of type hashMap

Create method called addStudentMarks which takes in a parameter of studentID and a Mark object.
Inside the method, we add the key-value pair to the hashMap. No return value needed

Add another method called getStudentMarks which takes in a parameter of studentID.
Given the parameter which is the key to the hashMap, it will get the value and return mark
obJect.



Overall modifications of Assessment class:

1) Adding attribute studentMarks of type hashMap
2) Adding two methods, getStudentMarks, addStudentMarks





