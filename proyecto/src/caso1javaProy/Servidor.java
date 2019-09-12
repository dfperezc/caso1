package caso1javaProy;

public class Servidor extends Thread{

	//-------------------------------------------AB
	private Mensaje mess;
	private static Buffer buff;
	//-------------------------------------------AE

	public Servidor(Buffer buff)
	{
		Servidor.buff = buff;
		mess = new Mensaje(-1);

	}

	/**
	 * Despertar al cliente que estaba durmiendo en el mensaje
	 */
	public void notiCli()
	{
		synchronized(mess)
		{
			mess.notify();
		}
	}
	
	/**
	 *Receive Message, saca mensajes del buffer 
	 */
	public void recMess()
	{
		while(buff.getMesss().size()==0 && buff.getNumbCli() != 0)
		{
			yield();
		}
		try
		{

			mess = buff.remoMess();
			prossMess();
			notiCli();

		}
		catch(Exception e)
		{
			System.out.println("");
		}

	}


	/**
	 * consumir mensaje, básicamente sumarle 1 al valor del mensaje
	 */
	public void prossMess()
	{
		int messValCu = mess.getValOriginal();
		System.out.println("valor original " + messValCu);
		messValCu ++;
		mess.setVal(messValCu);
		System.out.println("valor respuesta "  + mess.getVal());

	}

	@Override
	public void run()
	{
		while(0<buff.getMesss().size())
		{
			recMess();
		}
	}
	//-------------------------------------------SGB

	/**
	 * @return the mess
	 */
	public Mensaje getMess() {
		return mess;
	}

	/**
	 * @param mess the mess to set
	 */
	public void setMess(Mensaje mess) {
		this.mess = mess;
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
		Servidor.buff = buff;
	}

	//-------------------------------------------SGE





}
