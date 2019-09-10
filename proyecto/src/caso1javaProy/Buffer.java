package caso1javaProy;

import java.util.ArrayList;

public class Buffer {
	
	//-------------------------------------------AB
	private int size;
	private ArrayList<Mensaje> mess;
	private int numbCli;
	//-------------------------------------------AE

	public Buffer(int size, int numbCli)
	{
		
	}
	
	//-------------------------------------------SGB
	
	//-------------------------------------------SGE
	
	public synchronized void keepMessage(Mensaje mess)
	{
		
	}
	
	public synchronized Mensaje removeMessage()
	{
		return new Mensaje();
	}
	
	
	
}
