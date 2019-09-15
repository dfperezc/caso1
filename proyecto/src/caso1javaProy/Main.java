package caso1javaProy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {
			BufferedReader buffRdr = new BufferedReader(new FileReader("data/inicData.txt"));

			String[] inicValues = buffRdr.readLine().split(" ");

			//par�metros que est�n en el primer rengl�n del archivo de texto
			int numbCli	= Integer.parseInt(inicValues[0]);
			int capp = Integer.parseInt(inicValues[1]);
			int numbSis = Integer.parseInt(inicValues[2]);
			Buffer buff = new Buffer(capp, numbCli);
			System.out.println("se inicializ� el proceso con:\n" + numbCli + " clientes \n" + capp + " en capacidad de buffer\n" + numbSis + " servidores");
			inicValues = buffRdr.readLine().split(" ");
			//par�metros que est�n en el segundo rengl�n del archivo de texto, b�sicamente la cantidad de mensajes de cada cliente
			int numCantCli = inicValues.length;
			for(int i=0; i<numCantCli; i++)
			{	
				if(i==numCantCli)
				{
					System.out.println("pusieron m�s clientes que cantidades de mensajes o m�s cantidades de mensajes que clientes");
					System.out.println("Para sortear el error el programa correr� los con los");
					System.out.println("clientes a los que se les asigno una cantidad de mensajes en el documento de texto");
					break;
				}
				int numbMess = Integer.parseInt(inicValues[i]);
				Cliente nC = new Cliente(i, numbMess, buff);
				System.out.println("se inicializ� al cliente "+ i + " con " + nC.getNumbMess() + " mensajes");
				nC.start();
			}
			for(int j=0; j<numbSis; j++)
			{
				Servidor ser = new Servidor(buff);
				ser.start();
			}
			buffRdr.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("no se encontr� el archivo de configuraci�n");
			e.printStackTrace();
		}
		catch (IOException f)
		{
			System.out.println("no se ley� bien archivo de configuraci�n");
			f.printStackTrace();
		}


	}

}
