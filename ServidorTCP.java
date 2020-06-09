package practica1;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Date;

import javax.jws.soap.SOAPBinding;

public class ServidorTCP {



	public static void main(String[] args) throws Exception{
		ServerSocket socketServidor = null;
		Socket socketCliente=null;
		BufferedReader entrada = null;
		PrintWriter salida= null;
		java.util.Date fecha = new Date();
		System.out.println("**********SERVIDOR EN LINEA*********");
		

		try {
			socketServidor = new ServerSocket(8888);	//definimos sokect servidor

		} catch (Exception e) {
			// TODO: handle exception

		}
		//recibimos peticiones del cliente
		try {
			while (true) {
				socketCliente =socketServidor.accept();			//acepta al cliente 
				entrada= new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));//crea entrada y salida
				salida= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);

				while (true) {
					int q=1;
					while(q==1) {
						String ca2=entrada.readLine();
						System.out.println("33333"+ca2);
						salida.println(ca2);
						if (ca2.equals("")) {
							q=0;
						}
					}
					String ca2=entrada.readLine();
					System.out.println("33333"+ca2);
					salida.println(ca2);
					
					
					String cad=entrada.readLine();//mensaje recive
					if (cad.equals("exit")) break;
					//salida.println(cad);
					//envia
					//String res="IMPAR";
					//if(cad.length()%2==0) res = "PAR";

					//salida.println(cad.toUpperCase()+" "+fecha);


				}


				//System.out.println(cad);

				//System.out.println("el puerto del clietne "+socketCliente.getPort());
				//System.out.println("el addrss del cliente "+socketCliente.getInetAddress());
				//System.out.println("el addrss del cliente "+socketServidor.getSoTimeout());
				//System.out.println("el addrss del cliente "+socketCliente.getSoTimeout());




			}
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
	}
}
