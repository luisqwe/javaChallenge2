package com.davivienda.sv.challenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FileManager {
public static final String FILE_URL = "https://robertux-words.s3.amazonaws.com/pg345.txt";
	
	/**
	 * Carga el texto contenido en el archivo ubicado en la URL en la constante FILE_URL
	 * @return El contenido del arcihvo cargado
	 */
	public String loadFile() {
		//TODO: Implementar un cliente HTTP para cargar en memoria el archivo ubicado en la URL
		
		StringBuilder content =  new StringBuilder();
		try {
			URL url = new URL(FILE_URL);
			java.net.HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				content.append(line).append("\n");
				
			}
			reader.close();
			connection.disconnect();
		}catch(IOException e) {
			System.out.println("Error al cargar el archivo" + e.getMessage());
			return null;
		}
		return content.toString();
		
	}
}
