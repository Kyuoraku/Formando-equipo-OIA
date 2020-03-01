package mainclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Equipo {

	String ruta;
	Integer qIntegrantes;
	Integer qPreguntas;
	char[][] respuestas;
	ArrayList<Combinacion> combinaciones;
	
	public Equipo (String ruta) {
		
			this.ruta = ruta;
			this.ingresoDeDatos();
			this.crearCombinaciones();
			
			
	}
	
	private void crearCombinaciones() {
		
		this.combinaciones = new ArrayList<Combinacion>();
		for(int p=0;p<this.qPreguntas;p++) {
			this.combinaciones.add(new Combinacion(this.respuestas,p));
		}
		
	}
	
	private void ingresoDeDatos() {
		
		BufferedReader br;
		String linea = "";
		try {
			br = new BufferedReader(new FileReader(ruta));
			this.qPreguntas = Integer.parseInt(br.readLine());
			this.qIntegrantes = Integer.parseInt(br.readLine());
			this.respuestas = new char[qIntegrantes][qPreguntas];
			for(int i=0;i<this.qIntegrantes;i++) {
				linea = br.readLine();
				this.respuestas[i] = linea.toCharArray();
				continue;
			}
			try {
				if(br != null) {
					br.close();
				}
				}
				catch(Exception ex) {
					System.out.println(ex.getStackTrace());
				}
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

	
	
	
	
	
	
	public static void main(String[] a) {
		Equipo e1 = new Equipo("test1.in");
	}
}
