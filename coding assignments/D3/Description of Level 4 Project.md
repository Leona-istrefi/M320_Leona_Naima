## Vehicle Rental System in Java
We are aiming to build a Vehicle Rental system in Java with various components. Below are the key parts of the system:

### Base Class for Vehicles
The system will have a Base Vehicle Class, which will include common attributes shared by all types of vehicles. These attributes include:

<ls> 
<ul>Year</ul>
<ul>Price </ul>
<ul>Name </ul>
<ul>Color </ul>
<ul>Seats </ul>
<ul>Model </ul>
<ul>Brand </ul>
<ul>Speed </ul>
<ul>Age Approval </ul>
</ls>
  
### Person Class
In addition, we will implement a Person Class to represent individuals who own or interact with vehicles. The Person Class will contain the following attributes:
<ls> 
<ul>First Name </ul>
<ul>Last Name </ul>
<ul>Birth Date </ul>
<ul>Gender </ul>
<ul>Address </ul>
<ul>Phone Number </ul>
</ls>

### Contract Class
We will introduce a Contract Class that will hold contract details, including:

<ls> 
<ul>Contract ID </ul>
<ul>Start Date </ul>
<ul>End Date </ul>
<ul>Types of Vehicles </ul>
Our system will support several Vehicle Types, each with specialized attributes:
</ls>

### Land Vehicles
These include cars, trucks, buses, tractors, motorcycles, and more. A common attribute for these vehicles will be Highway Approval.

### Air Vehicles
This category includes airplanes, helicopters, and rockets.

### Water Vehicles
This category includes boats and submarines.

Each vehicle will have its own specialized attribute, setting them apart from each other.

### Exceptions
To handle various scenarios, we will implement the following exceptions:

MinorAgeException – Raised if a person is under the required age.
DenylistedPersonException – Raised if a person is on a denylist.
LeaseLengthCollisionException – Raised if there’s a conflict with lease durations.
