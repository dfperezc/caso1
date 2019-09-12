package caso1javaProy;

import java.util.ArrayList;

public class Buffer {
	
	//-------------------------------------------AB
	/**
	 * vacancias. Es el número de espacios vacantes del Buffer
	 */
	private int vaca;
	
	/**
	 * la lista de mensajes
	 */
	private ArrayList<Mensaje> messs;
	
	/**
	 * number of Clientes
	 */
	private int numbCli;
	
	/**
	 * true si vacancias == 0
	 */
	private boolean full;
	//-------------------------------------------AE

	public Buffer(int vaca, int numbCli)
	{
		this.vaca = vaca;
		messs = new ArrayList<Mensaje>();
		this.numbCli = numbCli;
		updatefull();
		
	}
	
	
	/**
	 * guardar el mensaje, solo se activa si hay vacantes
	 * @param mess
	 */
	public synchronized void keepMess(Mensaje mess)
	{
		messs.add(mess);
		vaca --;
		updatefull();
	}


	/**
	 * saca el mensaje, solo se activa si hay mensajes	
	 * @return
	 */
	public synchronized Mensaje remoMess()
	{
		 Mensaje mess= messs.remove(0);
		 vaca++;
		 updatefull();
		 return mess;		 
	}
	
	/**
	 * reduce el numero de clientes
	 */
	public synchronized void killMe()
	{
		numbCli--;
	}
	
	//-------------------------------------------SGB
	public void updatefull()
	{
		full = vaca==0?true:false;
	}
	public boolean getFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public ArrayList<Mensaje> getMesss() {
		return messs;
	}

	public void setMesss(ArrayList<Mensaje> messs) {
		this.messs = messs;
	}

	public int getNumbCli() {
		return numbCli;
	}

	public void setNumbCli(int numbCli) {
		this.numbCli = numbCli;
	}
	public int get() {
		return vaca;
	}

	public void setVaca(int vaca) {
		this.vaca = vaca;
	}
	
	//-------------------------------------------SGE
	
	
	
	
}
