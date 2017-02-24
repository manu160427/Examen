import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class ParsearLibro extends DefaultHandler
{


		
		private Libroxml libro;
		private HashMap<String,Libroxml> mapa_libros;
		private String valorActual;
		private String isbn;
		
		@Override
		public void startDocument() throws SAXException {
			mapa_libros = new HashMap<String,Libroxml>();
		}
		
		@Override
		public void endDocument() throws SAXException {
			Main.setMapaLibros(mapa_libros);
		}
		
		@Override
		public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException
		{
			if(localName.equals("libro"))
			{
				isbn = attributes.getValue("isbn");
				libro = new Libroxml();
				this.libro.setIsbn(isbn);
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName)throws SAXException
		{
			switch (localName) 
			{
			case "titulo":
				libro.setTitulo(valorActual);
				break;
			case "autor":
				libro.setAutor(valorActual);
				break;
			case "anyo":
				libro.setAnyo(valorActual);
				break;
			case "editorial":
				libro.setEditorial(valorActual);
				break;
			case "libro":
				mapa_libros.put(isbn, libro);
				break;
			default:
				break;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length)throws SAXException
		{
			
			String str = new String(ch,start,length);
			
			valorActual = str;
		}
}
