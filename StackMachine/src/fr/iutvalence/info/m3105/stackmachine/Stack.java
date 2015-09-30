package fr.iutvalence.info.m3105.stackmachine;

public class Stack
{
	private static final int WORD_SIZE = 32;
	
	int[] stack;
	int currentSize;
	int wordSize;
	
	public Stack(int size) throws InvalidParametersException
	{
		this.stack = new int[size];
		this.wordSize = WORD_SIZE;
	}
	
	public void write(int param) throws StackOverflowException
	{
		if(currentSize >= stack.length)
			throw new StackOverflowException();
		
		stack[currentSize] = param;
		currentSize += 1;
	}
	
	public int read() throws StackUnderflowException
	{
		if(currentSize <= 0)
			throw new StackUnderflowException();
		
		currentSize -= 1;
		
		return stack[currentSize];
	}
}
