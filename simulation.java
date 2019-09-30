/*
Author: Kushan Singh

Assignment: Working with bytes
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Byte; //To import the Byte Wrapper class
class Memory
{
	byte address; //Holds the address where data is stored in 'Memory'
	byte data;
	Memory()
	{
		address = 0;
		data = 0;
	}
	Scanner sc = new Scanner(System.in);
	
	void displayMemoryContent(Memory memory[]) 
	{
		System.out.println("\nMemory contains:");
		for(int i=0; i<memory.length; i++)
			System.out.println("Address: "+String.format("0x%02X",memory[i].address)+"\tData: "+memory[i].data); //String.format() is being used to display 2 hexadecimal characters of 'Memory' address
	}
	void initiliaseMemory(Memory memory[])
	{
		Random random = new Random(); 
		int randAddress;
		System.out.println("\nSize of Memory is: "+memory.length);
		for(int i=0; i<memory.length; i++)
		{
			randAddress = random.nextInt(256); //To generate a random number whithin the range of 1 byte = 256
			
			memory[i] = new Memory(); //To allocate space for each 'Memory' unit
			memory[i].address = (byte) randAddress;
			
			System.out.println("\nEnter data into memory address: "+String.format("0x%02X",memory[i].address)); 
			memory[i].data = (byte) sc.nextInt(); //If the input integer exceeds the range of 'byte' then the integer value modulo 256 is stored into the 'Memory' data 
		}
		System.out.println("\nConverting data to bytes");
	}
}
class Register
{
	Scanner sc = new Scanner(System.in);
	
	byte accumulator; //The accumulator (AC) holds the data temporarily before storing into 'Memory'
					  //In reality the AC also hold the instructions and respective address
	Register()
	{
		accumulator = 0;
	}
	void displayRegisterContent()
	{
		System.out.println("\nRegister contains:");
		System.out.println("AC data: "+accumulator);
	}
	void instructionFetch(Memory memory[]) //Simulates the function of Program Counter(PC) in CPU 'Register'
	{
		System.out.println("\nEnter Instruction:");
		System.out.println("\n1-Load data from memory to AC\n2-Store data of AC to memory\n3-Add data to AC");
		byte instruction = sc.nextByte();
		switch(instruction)
		{
			case 1: load(memory); break;
			case 2: store(memory); break;
			case 3: add(); break;
			default: System.out.println("\nInvalid instruction");
		}
	}
	int addressFetch(Memory memory[], byte address) //Checks if inputted address exists in 'Memory'
	{
		for(int i=0; i<memory.length; i++)
		{
			if(Byte.compare(address,memory[i].address) == 0)
			{
				System.out.println("\nAddress "+String.format("0x%02X",memory[i].address)+" exists");
				return i;  //Returns the index value of 'Memory' address
			}
		}
		System.out.println("\nAddress "+String.format("0x%02X",address)+" does not exist");
		return -1;
	}
	boolean dataFetch(Memory memory[], byte data) //Checks if inputted data exists in 'Memory'
	{
		for(int i=0; i<memory.length; i++)
		{
			if(Byte.compare(data,memory[i].data) == 0)
			{
				System.out.println("\nData: "+data+" is found at address: "+String.format("0x%02X",memory[i].address));
				return true;
			}
		}
		System.out.println("\nData: "+data+" is not found");
		return false;
	}
	void load(Memory memory[]) //Loads data from memory to AC
	{
		System.out.println("\nEnter data to load");
		byte data =(byte) sc.nextInt();
		System.out.println("\nConverting data to bytes");
		
		if(dataFetch(memory, data) == true)
		{
			System.out.println("\nData: "+data+" is being loaded into AC");
			accumulator = data;
			System.out.println("\nOverWriting data at AC");
		}
		
	}
	void store(Memory memory[]) //Stores data of AC to memory
	{
		System.out.println("\nEnter address to store data");
		int adr = sc.nextInt(16);
		byte address = (byte) adr;
		int index = addressFetch(memory, address);
		if(index >=0)
		{
			System.out.println("\nData at AC: "+accumulator+" is being stored into Memory address: "+String.format("0x%02X",adr));
			memory[index].data = accumulator;
		}
	}
	void add() //Adds data to AC
	{
		System.out.println("\nEnter data to add to AC:");
		byte data = (byte) sc.nextInt();
		accumulator += data; //The old contents of AC and the new data are added and the result is stored in AC
		
		System.out.println("\nConverting data to bytes");
		System.out.println("\nUpdating data at AC to: "+accumulator);
	}
}
public class Simulation
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Memory obj = new Memory(); //used to access the functions of 'Memory'
		Memory memory[] = new Memory[3];
		Register register = new Register();

		obj.initiliaseMemory(memory);
		System.out.println("\nContents of Memory and Register are in 'bytes'\n");
		
		int answer = 1;
		while(answer == 1)
		{
			obj.displayMemoryContent(memory);
			register.displayRegisterContent();
			register.instructionFetch(memory);

			System.out.println("\n\nInitiate next instruction cycle (1 = Yes, 0 = No) ?");
			answer = sc.nextInt();
		}
	}
}

