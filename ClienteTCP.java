package practica1;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

public class ClienteTCP {
	public static void main(String[] args) throws IOException{

		Socket socketCliente =null;
		Scanner reader = new Scanner(System.in);
		//CREAMOS LOS FLUJOS DE ENTRADA Y SALIDA (BAFERS)
		BufferedReader entrada =null;
		PrintWriter salida =null;
		System.out.println("************CLIENTE***********");
		try {
			socketCliente = new Socket("localhost",8888);//asignamos host y un puerto 
			//crea entrada y salida para poder enviar los mensajes
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		} catch (Exception e) {
			System.out.println(e);
			
		}

		BufferedReader sc= new BufferedReader(new InputStreamReader(System.in)); //para poder escribir en consola
		try {

			System.out.println("Menu");
			System.out.println("Opcion 1");
			System.out.println("opcion 2");
			System.out.println("Opcion 3");
			System.out.println("Opcion 4 salir");
			while (true) {

				int ca=0; String ca2="";
				int die=0;
				
				while(die==0) {
					System.out.println("******digite opcion del menu******");
					ca=reader.nextInt();
					switch(ca) {
					case 1:
						ca2="piedra";
						salida.println(ca2);// mesaje enviado 
						//if (cad.equals("exit"))break ;
						break;
					case 2:
						ca2="papel";
						salida.println(ca2);// mesaje enviado 
						//	if (cad.equals("exit"))break ;
						break;
					case 3:
						ca2="tijera";
						salida.println(ca2);// mesaje enviado 
						//if (cad.equals("exit"))break ;
						break;
					case 4:
						ca2="";
						salida.println(ca2);// mesaje enviado 
						//if (cad.equals("exit"))break ;
						die=1;
						break;
					default:
						ca2="";
						salida.println(ca2);
						System.out.println("------digite una opcion del menu------");
						//if (cad.equals("exit"))break ;
						break;

					}
					System.out.println("88888888888");
					ca2=entrada.readLine();//renviamos mensaje
					//System.out.println("caaa2"+ca2);
					System.out.println("la respuesta es del server: "+ca2);
				}
				

				System.out.println("@ SALIR DEL CLIENTE @ con exit");
				String cad=sc.readLine();
				//cad=sc.readLine();
				if (cad.equals("exit"))break ;


				//salida.println(cad);// mesaje enviado 

				//if (cad.equals("exit"))break ;




			}




			//cad=entrada.readLine();
			//System.out.println("la respuesta del servidor es "+cad);
			//cad=entrada.readLine();
			//System.out.println("la respues es¡¡¡"+cad);




		} catch (Exception e) {

		}
		//liberamos recursos
		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
	}
}
