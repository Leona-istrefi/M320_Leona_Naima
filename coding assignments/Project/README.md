# UML diagram Vehicle Rental project

## Description
This is a vehicle rental game where you can rent a lot of different vehicles. <br>
For land, water and also air vehicles. <br>
We've implemented the project with multiple interfaces to avoid using the same code several times.<br>
You can see our structure on the pictures, there is a vehicle interface which is extended by the interfaces AirVehicle, WaterVehicle
and also AirVehicle interfaces. Then there are different vehicles such as submarine, car and rocket.
They all have a different price and individual attributes. <br>
There is also a class to create a contract and a class to register the person. To avoid several people renting the same car at the
same time, there are exceptions and exception handling is also implemented for age.

## UML
![img.png](img.png)

## Detailed images
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)


# Sequence diagram Vehicle Rental project
Use Case:
Marina, 25 wants to rent a bike for the coming weekend from 24/02/2025 - 25/02/2025. <br>
Her birthday is on 29.10.2000 and she would prefer a blue bike. <br>
She has no children and no other wishes. <br>

![image](https://github.com/user-attachments/assets/022e6a2b-a6bd-474a-8d66-012930ff1ca8)

# Delegation
SpaceVehicle class represents a generic space vehicle, inheriting from the Vehicle class while delegating some of its behavior to the VehicleBehavior interface.
Instead of directly handling air pressure management, SpaceVehicle delegates this responsibility to an instance of SpaceVehicleBehavior, which implements VehicleBehavior.
The constructor of SpaceVehicle initializes an instance of SpaceVehicleBehavior and assigns it to the behavior field.
When calling getAirPressure() or setAirPressure(), SpaceVehicle simply forwards the request to behavior, ensuring that it does not manage air pressure directly.
This delegation allows SpaceVehicle to remain focused on its core attributes like year, price, speed, and seating capacity, while offloading behavior-specific responsibilities.
The SpaceShuttles class extends SpaceVehicle, adding a walkieTalkie property, making it a specialized type of space vehicle.
Since SpaceShuttles inherits from SpaceVehicle, it automatically gains access to the delegation pattern for air pressure management.
TheVehicleBehavior interface ensures that different vehicle behaviors can be implemented and assigned dynamically to SpaceVehicle.

# Lines of code

<p> We have 1555 lines of Code</p>

![image](https://github.com/user-attachments/assets/24a893a7-f0cc-4df8-aa2e-0e28fb93da72)
