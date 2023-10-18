# Gaming PC Builders

1. Create a class called PC


2. Add the properties: *cpu*, *memory*, *graphics card*, *price* to the PC class


3. Create a constructor that ONLY accepts *cpu*, *memory*, and *graphics card*.


4. The *price* attribute is derived from the following rules:

- The base price of a PC is 800.
- A **NITEL** CPU costs 300, whereas a **DAM** CPU costs 250
- **8GB** of memory costs 400, **16GB** adds 700 to the cost, whereas **32GB** adds 1000 to the cost
- A **FORCEG** graphics card adds 500 to the cost, whereas a **EONRAD** card costs 350 

5. Override the `toString` method so that a PC object prints out in the following format:

`--------------------------------`
CPU: NITEL | Memory: 8GB | Graphics: EONRAD
Total Price: 1850
`--------------------------------`

**The line breaks are required (You can use the newline character).**

6. In the Mod1Checkpoint class there is a main method. Within this main method, make 2 different PC objects. Print
the 2 objects you made.


7. Create a method called offerDiscount. The method should return a boolean and take in as parameters: 
a reference to a PC object and a boolean indicating if the customer is a member of the saversClub. A
discount is offered if the customer is a member of the saversClub and the PC they are building has a price
greater than 2000.


8. Write code to process the file `Orders.CSV` within the main method and use it to populate a list of PC objects.
Note that the file contains unusual casing, and we must count the data regardless of case configuration:
For example, all three of these are valid inputs: NiTEL, nitel, NITEL, etc. 


Print out the total of all computed prices from the orders in the file.


9. Write a unit test to verify that a PC object is priced correctly for a certain configuration.


10. Write a unit test to verify the offerDiscount method.