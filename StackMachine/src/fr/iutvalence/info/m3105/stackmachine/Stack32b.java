package fr.iutvalence.info.m3105.stackmachine;

public class Stack32b implements Stack
{
	private static final int WORD_SIZE = 32;
	
	int[] stack;
	int currentSize;
	int wordSize;
	
	public Stack32b(int size) throws InvalidParametersException
	{
		this.stack = new int[size];
		this.wordSize = WORD_SIZE;
	}
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m3105.stackmachine.StackI#write(int)
	 */
	@Override
	public void write(int param) throws StackOverflowException
	{
		if(currentSize >= stack.length)
			throw new StackOverflowException();
		
		stack[currentSize] = param;
		currentSize += 1;
	}
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.info.m3105.stackmachine.StackI#read()
	 */
	@Override
	public int read() throws StackUnderflowException
	{
		if(currentSize <= 0)
			throw new StackUnderflowException();
		
		currentSize -= 1;
		
		return stack[currentSize];
	}
}
