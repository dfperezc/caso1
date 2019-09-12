package caso1javaProy;

public class Mensaje {

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
//	
//	public void depMess()
//	{
//		
//	}
//	

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
