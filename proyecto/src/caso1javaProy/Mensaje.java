package caso1javaProy;

public class Mensaje extends Thread{

	//-------------------------------------------AB
	/**
	 * no es necesario guardar dos valores es solo para que el resultado en consola 
	 * se entienda mejor
	 */
	private int valOriginal;
	private int valNuevo;
	//-------------------------------------------AE

	public Mensaje(int val)
	{
		valOriginal=val;
	}
	
	public void  sendMess(Buffer buff) {
		while(!buff.getFull()) {
			buff.keepMess(this);
			System.out.println("mensaje entro al buff");
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("sendMess messit up");
			}
		}
		buff.keepMess(this);
	}

	//-------------------------------------------SGB
	public int getValOriginal() {
		return valOriginal;
	}

	public int getVal() {
		return valNuevo;
	}

	public void setVal(int val) {
		this.valNuevo = val;
	}
	//-------------------------------------------SGE


}
