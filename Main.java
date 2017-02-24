
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;



//C:\Program Files\Java\jdk1.8.0_45\bin\javadoc.exe

public class Main{
	private static HashMap<String,Libroxml> hasMap;

	
		public static void main(String[] args) throws Throwable {
			
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			ParsearLibro parserlibro = new ParsearLibro();
			
			reader.setContentHandler(parserlibro);
			
			reader.parse(new InputSource(new FileInputStream("libros.xml")));
			
			mostrar();
		}
		
		public static void mostrar(){
			for (String nombre: hasMap.keySet())
			{
		    	String value = hasMap.get(nombre).toString();
		    	System.out.println(value);
			} 
		}

		public static int getNLibros(){
			int numeroLibros = 0;
			for (String nombre: hasMap.keySet())
			{
				numeroLibros++;
			} 
			return numeroLibros;
		}
		
		public static void setMapaLibros(HashMap<String,Libroxml> mapaLibros2){
			hasMap = mapaLibros2;
		}
		
		
	
	}
