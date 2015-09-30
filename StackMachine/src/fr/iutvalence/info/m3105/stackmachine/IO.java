package fr.iutvalence.info.m3105.stackmachine;

import java.io.IOException;

public interface IO
{
	public abstract void displayRuntimeError(String error);

	public abstract void displayProgramTermination();

	public abstract int read() throws IOException;

	public abstract void write(int op);
}
