package fr.iutvalence.info.m3105.stackmachine;

public class MemoryW32A32 implements Memory
{
	private int startAddress;
	private int endAddress;
	private int[] memory;

	public MemoryW32A32(int startAddress, int endAddress)
	{
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		if(endAddress - startAddress > 0)
			memory = new int[endAddress-startAddress];
	}

	@Override
	public int getStartAddress()
	{
		return this.startAddress;
	}
	
	@Override
	public int getEndAddress()
	{
		return this.endAddress;
	}

	@Override
	public void write(int currentAddress, int instructionParam) throws AddressOutOfBoundsException
	{
		if(currentAddress < startAddress || currentAddress > endAddress)
			throw new AddressOutOfBoundsException();
		
		this.memory[currentAddress] = instructionParam;
	}

	@Override
	public int read(int address) throws AddressOutOfBoundsException
	{
		if(address < startAddress || address > endAddress)
			throw new AddressOutOfBoundsException();
		
		if(this.memory != null)
			return this.memory[address];
		
		return -1;
	}
}
