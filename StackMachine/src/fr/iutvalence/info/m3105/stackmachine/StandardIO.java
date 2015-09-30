package fr.iutvalence.info.m3105.stackmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class StandardIO implements IO
{
	private BufferedReader in;
	private PrintStream out;
	private PrintStream err;

	public StandardIO(InputStream inStream, OutputStream outStream, OutputStream errStream)
	{
		super();
		this.in = new BufferedReader(new InputStreamReader(inStream));
		this.out = new PrintStream(outStream);
		this.err = new PrintStream(errStream);
	}

	@Override
	public void displayRuntimeError(String error)
	{
		this.err.println(error);

	}

	@Override
	public void displayProgramTermination()
	{
		this.out.println("(HALT)");
	}

	@Override
	public int read() throws IOException
	{
		this.out.print("? ");
		String line = this.in.readLine();
		this.out.println();
		return Integer.parseInt(line);

	}

	@Override
	public void write(int op)
	{
		this.out.println("> " + op);
	}
}
