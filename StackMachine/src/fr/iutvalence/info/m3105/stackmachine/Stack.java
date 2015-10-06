package fr.iutvalence.info.m3105.stackmachine;

public interface Stack
{

	public abstract void write(int param) throws StackOverflowException;

	public abstract int read() throws StackUnderflowException;

}