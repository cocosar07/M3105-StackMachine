package fr.iutvalence.info.m3105.stackmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO implements IO
{
	private FileReader in;
	private FileWriter out;
	
	public FileIO(File file)
	{
		try
		{
			in = new FileReader(file);
			out = new FileWriter(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void displayRuntimeError(String error)
	{
		try
		{
			out.write(error);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void displayProgramTermination()
	{
		try
		{
			out.write("HALT");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int read() throws IOException
	{
		return in.read();
	}

	@Override
	public void write(int op)
	{
		try
		{
			out.write(op);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
