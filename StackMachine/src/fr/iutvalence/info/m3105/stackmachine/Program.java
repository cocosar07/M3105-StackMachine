package fr.iutvalence.info.m3105.stackmachine;

public class Program
{
	private Instruction[] instructions;
	
	public Program(Instruction[] instructions)
	{
		this.instructions = instructions;
	}

	public int getInstructionCount()
	{
		return instructions.length;
	}

	public Instruction getInstructionAt(int instructionNumber)
	{
		return instructions[instructionNumber];
	}
}
