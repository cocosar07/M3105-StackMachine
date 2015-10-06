package fr.iutvalence.info.m3105.stackmachine;

public class CPU
{
	public final static int HALT = 0x00;
	public final static int PUSH = 0x01;
	public final static int ADD = 0x02;
	public final static int SUB = 0x03;
	public final static int MUL = 0x04;
	public final static int DIV = 0x05;
	public final static int MOD = 0x06;
	public final static int NEG = 0x07;
	public final static int LT = 0x08;
	public final static int LE = 0x09;
	public final static int GT = 0x0A;
	public final static int GE = 0x0B;
	public final static int EQ = 0x0C;
	public final static int NE = 0x0D;
	public final static int IN = 0x0E;
	public final static int OUT = 0x0F;
	public final static int CALL = 0x10;
	public final static int RET = 0x11;
	public final static int JP = 0x12;
	public final static int JZ = 0x13;
	public final static int DUP = 0x14;
	public final static int POP = 0x15;
	
	
	private IO ioSystem;
	private int programCounter;
	private Memory programMemory;
	private Stack expStack;
	private Stack callStack;

	public void run()
	{
		int opCode = 0;
		while (true)
		{
			try
			{
				opCode = programMemory.read(programCounter);
				programCounter += 1;
				
				System.err.print("@" + this.programCounter + ": ");
				
				switch (opCode)
				{
				case HALT:
				{
					System.err.println("HALT");
					if(this.ioSystem != null)
						this.ioSystem.displayProgramTermination();
					
					return;
				}
				case PUSH:
				{
					System.err.println("PUSH");
					break;
				}
				case ADD:
				{
					System.err.println("ADD");
					break;
				}
				case SUB:
				{
					System.err.println("SUB");
					break;
				}
				case MUL:
				{
					System.err.println("MUL");
					break;
				}
				case DIV:
				{
					System.err.println("DIV");
					break;
				}
				case MOD:
				{
					System.err.println("MOD");
					break;
				}
				case NEG:
				{
					System.err.println("NEG");
					break;
				}
				case LT:
				{
					System.err.println("LT");
					break;
				}
				case LE:
				{
					System.err.println("LE");
					break;
				}
				case GT:
				{
					System.err.println("GT");
					break;
				}
				case GE:
				{
					System.err.println("GE");
					break;
				}
				case EQ:
				{
					System.err.println("EQ");
					break;
				}
				case NE:
				{
					System.err.println("NE");
					break;
				}
				case IN:
				{
					System.err.println("IN");
					break;
				}
				case OUT:
				{
					System.err.println("OUT");
					break;
				}
				case CALL:
				{
					System.err.println("CALL");
					programCounter = programMemory.read(programCounter+1);
					break;
				}
				case RET:
				{
					System.err.println("RET");
					break;
				}
				case JP:
				{
					System.err.println("JP");
					break;
				}
				case JZ:
				{
					System.err.println("JZ");
					break;
				}
				case DUP:
				{
					System.err.println("DUP");
					break;
				}
				case POP:
				{
					System.err.println("POP");
					break;
				}
				default:
				{
					System.err.println("DEFAULT");
					return;
				}
				}
				
				if(this.ioSystem != null)
					this.ioSystem.write(opCode);
	
				System.out.println();
			}
			
			catch (AddressOutOfBoundsException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void clearStacks()
	{
		// TODO Auto-generated method stub
		
	}

	public void setPC(int address)
	{
		this.programCounter = address;
		
	}

	public void wireToProgramMemory(Memory programMemory)
	{
		this.programMemory = programMemory;
	}

	public void wireToExpStack(Stack expStack)
	{
		this.expStack = expStack;
	}

	public void wireToCallStack(Stack callStack)
	{
		this.callStack = callStack;
	}

	public void wireToIoSubsystem(IO ioSystem)
	{
		this.ioSystem = ioSystem;
	}
}