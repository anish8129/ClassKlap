# Parking Lot
# Features!
  - Create a Parking Lot With a fixed Size.
  - Park Car and get nearest Slot from the enterance gate.
  - Leave a parking slot.
  - List out the car's registration number of a particular Colour.
  - List out the slot of cars of a particular Colour.
  - List out the Cars present in the parking lot.

### Tech
- Simple Java with Junit Library.

### How to run the File ? 
#### create the jar file
Open the project containing folder.
- cd ClassKlap
- gradle build -x test
#### Run the Jar file
Type in the following command.
- Cd ClassKlap/build/libs
- java -jar ClasKlap.jar

#### Expected Output :
This is a menu driven Program.
1. CREATE A PARKING LOT
2. EXIT  
if you chosse option 1  
Enter the Size of the parking area  
2  
Parking Lot is created.  
Then Sub menu appears  
  
1. PARK A CAR
  
2. REMOVE CAR FROM PARKING

3. STATUS OF PARKING SLOT

4. REGISTRATION NUMBERS OF CAR FOR A PARTICULAR COLOR

5. SLOT NUMBERS OF CAR FOR A PARTICULAR COLOR  
6. SLOT NUMBER OF CAR FOR A PARTICULAR REGISTRATION NUMBER  
7. EXIT  
  
if you choose Option 1.  
You will be prompt to enter you car number and then you will be prompt to enter the color of the car.  
If the input is proper it will allot a slot to the Car.  
  
If you choose option 2.  
It will ask for the slot number which you want to release.  
  
If you choose option 3.  
It will list the Cars present in the Parking Slot.  
  
If you choose the Option 4.  
It will prompt you to enter color of the car.  
if Cars are present then it will list the Cars registration number.  
  
If you choose the Option 5.  
It will prompt you to enter color of the car.  
if Cars are present then it will list the Cars slot number.  
  
If you choose the Option 6.  
It will prompt you to enter the registration number.  
if Cars are present then it will show the Cars slot number.  
  
If you choose the Option 7.  
It will exit the program.  

#### Along with this some negative scenarios are also covered in this program.
- Car with duplicate registration number cannot be parked.
- Car should belong from India(Indian State) to be parked in the Parking area.
- Car with improper regirstration number cannot be parked.
- Car should have 13 characters in "2char-2Number-2char-4Number" format eg: KA-23-JV-1234.


#### How to test Junit.
Junit didnot work in my system while building the JAR file due to gradle version issue.  
Still you can try in your system to build it with the following command.  
- gradle build

So to run the test case . You can use any IDE(Eclipse, IntelliJ)  
