Jason Lam, with assistance from Mohidul Abedin and Joseph Yusufov

0. citations for contributions by others (hw3C#concepts and basic honesty)

Assisted by Mohidul Abedin and Joseph Yusufov
Protagonist, Character are taken from Piazza #280
Framework of UserOfRPG taken from Holmes and Mr. Brown Mykolyk

1. Explanations of the various implementations of polymorphism along with the specific code that shows that implementation. (hw #47)
(check documentation)

2. UserOfRPG class that runs the game, based on the code in hw3C#0
(check documentation)

3. Allowing the player to choose a subclass of Protagonist. (hw44#6)
Uses the "Do you feel lucky" code modeled by Mr. Brown Mykolyk in order to simulate a choice

4. Instantiating a random type of Monster when one is encountered.
Variation on this. Creates an array with the size of MAX_ENCOUNTERS and then fills it with randomly generated monsters

5. all the constructors and members in hw3C#1, hw3C#2, but in the classes that a programmer of polymorphism would consider correct, rather than in the initial Protagonist and Monster classes described in hw3C

Each file should be relatively self explanatory (any ambiguity will be commented upon)
Each class is sufficiently different from one another, and NTSTT is employed in order to avoid overlap.

6. The Character class, including all the members (with the correct access modifier as we learned in hw3E#1) that are common across both Protagonist and Monster classes.

Changed damage calculation. Presents the basic framework of a character and how damage calculation works).

7. Subclasses of Monster and Protagonist (at least three of each), with specialized methods. (hw44#3,4)

Subclasses were meant not as a crash course in game design but rather examples of polymorphism. Each is suffiently different but can be referred to
by a variable containing a reference to its superclass.

8. The use of polymorphism, especially in parameters, to denote ambiguity among superclasses vs subclasses

In the pat field, it can hold a reference to a Protagonist, and as a result can hold a reference to any of its subclasses. This means that any of the classes
can be treated as such. The same holds for the "opponent" variable.

9. Discern where members are defined (variable/object type) and if that rule is imposed at compile/run time. (hw42#2)

For a variable that holds a reference to a superclass, the variable type is locked in, but the member class and the object type is determined at compile time. 
This is because it is unsure what to assign a reference to until the JVM goes through the code, but understands what it can and cannot hold a reference to.

10. One variable that holds a reference to a single instance of an existing super-class. (hw46 #6)

This is found in the "opponent" field, which holds a reference to a specific monster that is locked in combat with the protagonist. This will changed based on defeat and victory.

11. A collection of super classe variables (eg. Horde of monsters, guild of heroes, armored Characters) in the form of an array, and a block comment to describe its use at the top of the program (hw46#3,4)

The "horde" variable is a reference to an array of monsters that represents the different monsters the player will fight on their journey.
This is adapred from userofRPGv2 in order to fit properly.
12. Avoid the null pointer exception (2019-02-08 Notes)
(check documentation)
13. Overridden toString() methods to report the game-player's chosen role and the status of the game-player's antagonist. Use of toString() methods after character selection and turn of combat (hw46#1,2)

All character subclasses have different toString()s that overwrite the superclass's toString(). Along with printing name and having unique quotes associated with one another, it is meant to be a form
of telling these characters apart. 
14. report the status of the protagonist and the monster after each playTurn

(check documentation)

15. NTTSTT by using super() or super.methodName(). (hw44#3)
super() is most prominently used in overwriting the toStrings that are present in the Monster and Protagonist subclasses, in order to give a unique quote and differentiate each character apart.

16. comments in UserOfRPG and other classes to allow efficient navigation of the code to new and old users alike (2019-02-08 notes)

(check documentation)
17. A README.txt file to act as documentation referencing the above elements with numbers, to facilitate easy grading.

(check documentation)

18.Various block comments in the code where elements of polymorphism is demonstrated that can explain the benefit of using polymorphism in the specific area of code.

(check documentation)
19. Overloaded constructors (if necessary) to call a method for different parameters

I do not believe this is necessary.

20. The use of inheritance to obtain a member or method from classes (super and sub) without having repetitive code

(check documentation); very similar to the other points on the rubric by using super to denote accessing methods from higher in the hierarchy.