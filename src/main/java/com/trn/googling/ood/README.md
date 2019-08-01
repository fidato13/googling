## SOLID

1. #### Single Responsibility Principle
    Every object should perform a single responsibility. Or in more formal words : It should have only one and only reason to get changed.
    
    So For example, consider Imagine a class HospitalManagement which basically represents the management staff of a Hospital.  Generally Hospital Management has the capability to instruct
    hospital staff to do their duties. Imagine, there is a method in this class `instructToPerformDuties(Employee employee)` which asks the employee to perform their duties. Now, if there are other methods in this class about `HOW` an employee would perform its duties, then that would be a violation of `Single Responsibility Princniple` , because this class does more than one thing or has more than one reason to change. Like, if the Employee's responsibilities change then this class would require the modification as well. Ideally, Employee should have allof it's related methods like what/how to perform its duties. 
 
2. #### Open Closed Principle [Tutorial](http://joelabrahamsson.com/a-simple-example-of-the-openclosed-principle/)
    The system should be `Open for Extension` and `Closed for modification` . i.e. it should not be possible for the derivative classes to be able to modify the behavior, However it should be super easy to be able to add/extend more behavior when required
    
    So For example, Imagine a home entertainment system, we have RemoteControl class which can control any device in the living room. So the system should be designed in such a way that adding more devices in the future to be controlled by this remote should be easy , rather than having to change most part of the system. 
    So if all the devices conform to an interface or abstract class, then it would be very easy to add devices to the system; just make the new device to implement the said interface.
    
3. #### Liskov Substitution principle
    All subclasses should be substitutable for the base class.
    
    So Imagine a School system, in which Teacher is our base class which has an abstract method `teach` and a method `performOtherResponsibilites`. There are few subclasses which inherit from this base class, `MathTeacher`, `ScienceTeacher`. Now, if there is another sub class `SubstituteTeacher`
    then this class would also have a `teach` method. But let's say that we don't have in our system Substitue Teachers teaching. So to handle this kind of a case , we can opt for either:
    - Implement the `teach` method anyway and do nothing in it
    - Implement the `teach` method but from inside the `teach` method, throw a custom exception like `CannotTeachException`
    
    1. Both these handlings are not good, because first one would set an exceptation to users that it is supposed to do something
    2. and the second one would force the parent class to throw the `CannotTeachException` , which is also bad, we should not force the parent class to change.
    
    A good handling could be that , since `teach` method is not to be implemented by all kind of teachers and all teachers have to perform additional responsibilities. So make a base class `SchoolStaff` and have a method `performOtherResponsibilities` implemented. Classes `MathTeacher`, `ScienceTeacher` & `SubstitueTeacher` would inherit from `SchoolStaff` class. Also, define an interface `CourseInstructor` which has a method `teach` and `MathTeacher` and `ScienceTeacher` only would implement that interface.
    
4. #### Interface Segregation Principle
    This principle is about separating out the concerns. So Imagine a class that although follows the `Single Responsibility Principle` however may be has too much breadth of variation. 
    
    For Example, Imagine a `CustomerTransaction` class in a banking application, and this class provides two different kind of behaviors related to Transactions like `Invoice/report` related & `Prodcut on which transaction` was done.
    
    We could argue that this class still has the responsibility of managing the Customer's transactions. Now, suppose two of the objects `AccountsReceivable` and `ReportGenerator` require this object as a dependency and want to use it's method  
    
    Then we can observe that any change done to `CustomerTransaction` class will result in both `AccountsReceivable` and `ReportGenerator` classes being compiled/changed
    
    So, if a change is only made related to `reporting` related behaviors in `CustomerTransaction` class then that should not lead to any change in `AccountsReceivable` class and it's true for other class behavior combination as well. So, we can ideally abstract the reporting related behaviors in a separate interface and product related behavior in a different interface. Then the class `CustomerTransaction` can implement both of these interfaces. Till this point everything is same and we have not changed anything much. Now comes the beauty, `AccountsReceivable` and `ReportGenerator` classes which required the dependency of `CustomerTransaction` for respective subsets of behaviors can now import the dependecy as `Reporting` & `Accounting` (these are the new interfaces name in which we abstracted the methods). Thus the dependency in class `AccountsReceivable` would be of type `Accounting` and in `ReportGenerator` would be of `Reporting` . and the constructor in `AccountsReceivable` and `ReportGenerator` classes will accept `CustomerTransaction` type and will put them into `Reporting` and `Accounting` required objects. Thus any changes now in `CustomerTransaction` class with respect to one kind of behavior will not affect other type.
    
5. #### Dependency Inversion Principle
    This is about higher level module should not depend upon the lower level module implementation details. Infact they both should depend thru abstractions.
       
    
       
