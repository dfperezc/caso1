package caso1javaProy;

import java.util.ArrayList;

public class Cliente extends Thread{

	//-------------------------------------------AB
	private int iD;
	
	/**
	 * number of Messages
	 */
	private int numbMess;
	
	
	/**
	 * list of messages
	 */
	private ArrayList<Mensaje> messs;
	
	/**
	 * el buffer duh
	 */
	private static Buffer buff;
	//-------------------------------------------AE
	
	public Cliente(int iD, int numbMess, Buffer buff)
	{
		this.iD = iD;
		this.numbMess = numbMess;
		Cliente.buff = buff;
		messs = new ArrayList<Mensaje>();
		for (int i = 0; i <= numbMess; i++)
		{
			int rInt = (int)Math.random()*(20)+1;
			Mensaje mess = new Mensaje(iD*rInt); //el parámetro raro es solo para evitar que muchos mensajes me que-
												//den con el mismo valor
			messs.add(mess);
		}
	}
	
	public void thrMess()
	{
		for(int i=0; i<messs.size();i++) {
			messs.get(i).sendMess(buff);
		}
//		//O lo mete o se espera
//		while(buff.getFull())
//		{
//			yield();
//		}
//		buff.keepMess(mess);
//
//		synchronized(mess) {
//		//esto es para cuando entre el mensaje en el buffer (diseño- párrafo3 )
//		try {
//			mess.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
	}
	
	@Override
	public void run()
	{

			thrMess();//kidA es el mensaje que el cliente está intentando introducir eso y también un albúm de radiohead 
		
		buff.killMe(); //el cliente debe avisar al buffer que chao
	}
	//-------------------------------------------SetterGetterBegin

	/**
	 * @return the id
	 */
	public int getID() {
		return iD;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int iD) {
		this.iD = iD;
	}

	/**
	 * @return the numbMess
	 */
	public int getNumbMess() {
		return numbMess;
	}

	/**
	 * @param numbMess the numbMess to set
	 */
	public void setNumbMess(int numbMess) {
		this.numbMess = numbMess;
	}

	/**
	 * @return the messs
	 */
	public ArrayList<Mensaje> getMesss() {
		return messs;
	}

	/**
	 * @param messs the messs to set
	 */
	public void setMesss(ArrayList<Mensaje> messs) {
		this.messs = messs;
	}

	/**
	 * @return the buff
	 */
	public static Buffer getBuff() {
		return buff;
	}

	/**
	 * @param buff the buff to set
	 */
	public static void setBuff(Buffer buff) {
		Cliente.buff = buff;
	}
	



}
//-------------------------------------------SGE