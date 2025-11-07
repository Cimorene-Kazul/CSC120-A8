
Methods TO OVERLOAD
ALL CLASSES
Constructor -> equivilents for Building's partially empty Constructors, including with very few and with just special inputs
FOR BOTH ELEVATOR CLASSES
goUp -> have goUp() for just one floor and goUp(n) for using the elevator to go up n floors
goDown -> just like goUp
Constructor -> set default hasElevator to false if not given

House Constructor -> set default hasDiningRoom to false if not given
Cafe Constructor -> set defauly quanities of supplies if not given

It was unclear what to change with an elevator, and goToFloor() seems to not actually be the right method. Instead, it seems like the methods to override are goUp() and goDown(). At the time of writing this, I have a pending question in the slack about whether my interpretation is correct or not. For completing this assignment at the present time, I am assuming correctness, so I can get the assignment done.

I overloaded the following methods:
 + For all three subclasses, I created equivilents of the missing-attribute constructors for the parent Building class. They all have constructors with no givens, just the address and just the address and name, with defaults being given for other values.
 + For Library and House, the subclasses with elevators, I added two copies of goUp() and goDown(). One version moves up or down by one floor and has no inputs. The other takes a numerical input, the integer number of floors to go up or down by, and only will take an input that is not one if the building has an elevator. This way, code designed for default Buildings still works.
 + For House, there is a constructor that takes no hasElevator OR hasDiningRoom arguments, both of which are default false.