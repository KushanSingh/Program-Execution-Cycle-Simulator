			Project Details
This project aims to simulate program execution in memory
It shows how the components of register and memory interact to execute a program
For the purpose of this project instructions are being asked from the user
But in reality the operating system understands what instructions to perform on the respective address based on the opcode

Commented words enclosed in single quotes refer to the class of the same name


			Sample Output

Size of Memory is: 3

Enter data into memory address: 0x9F
124

Enter data into memory address: 0xFB
125

Enter data into memory address: 0x03
126

Converting data to bytes

Contents of Memory and Register are in 'bytes'


Memory contains:
Address: 0x9F	Data: 124
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: 0

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
3

Enter data to add to AC:
127

Converting data to bytes

Updating data at AC to: 127


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: 124
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: 127

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
3

Enter data to add to AC:
1

Converting data to bytes

Updating data at AC to: -128


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: 124
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: -128

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
2

Enter address to store data
9f

Address 0x9F exists

Data at AC: -128 is being stored into Memory address: 0x9F


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: -128
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: -128

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
1

Enter data to load
900

Converting data to bytes

Data: -124 is not found


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: -128
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: -128

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
1

Enter data to load
126

Converting data to bytes

Data: 126 is found at address: 0x03

Data: 126 is being loaded into AC

OverWriting data at AC


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: -128
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: 126

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
3

Enter data to add to AC:
1009

Converting data to bytes

Updating data at AC to: 111


Initiate next instruction cycle (1 = Yes, 0 = No) ?
1

Memory contains:
Address: 0x9F	Data: -128
Address: 0xFB	Data: 125
Address: 0x03	Data: 126

Register contains:
AC data: 111

Enter Instruction:

1-Load data from memory to AC
2-Store data of AC to memory
3-Add data to AC
2

Enter address to store data
0f2

Address 0xF2 does not exist


Initiate next instruction cycle (1 = Yes, 0 = No) ?
0

