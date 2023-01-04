package Converter.Money;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Request {
	public static void main(String[] args) {
		String to= "USD";
		String from= "COP";
		String amount = "5000";
		System.out.println(response(to,from,amount));
		
	}
	
	public static double response(String to,String from,String amount) {
		String url = "https://api.apilayer.com/exchangerates_data/convert?to="+to+"&from="+from+"&amount="+amount;
		String response = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			response = peticionHttpGet(url);
			ExchageApi data = mapper.readValue(response, ExchageApi.class);
			return data.getResult();
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		conexion.addRequestProperty("apikey", "bewZUU6yElWvqQwKxWd9TP3b5qs0byg3");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
}
