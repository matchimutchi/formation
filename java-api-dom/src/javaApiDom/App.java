package javaApiDom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) {
		
		//Utilisation de l'api DOM
		//cette classe permet de confugrer le parseInt DU COmmENT XML 
		//comme par exemple l'utilisation de schema de valisation
		//ou encore de namespace
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//le DocumentBuilder est l'objet concret qui permet 
			//soit de parse un fichier xml vers un objet Document (dom)
			// ou construite un document vide directement
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//--------------lire un fichier xml et construire sa representation objet----------------
			Document doc1 = db.parse(new File("book.xml"));
			
			//----------------on a acces a l'api DOM------------------------------------
			
			//recuperer tte les balises title du document
			NodeList tags = doc1.getElementsByTagName("title");
			
			//qu'est ce qu'un node?
			//c'est la classe de base de tout ce qu'on peut rencontrer en xml
			// -> Element(balise)
			// -> Attribut(attribut)
			// -> Texte (texte)
			
			//parcourir la collection
			for(int i = 0; i < tags.getLength(); i++) {
				Element balise = (Element)tags.item(i);
				System.out.println("Tag name = " + balise.getTagName());
				System.out.println("Texte interieur = " + balise.getTextContent());
			}
			
			System.out.println("-----------------------------------------");
			
			//explorer 
			explore(doc1.getChildNodes());
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void explore(NodeList nodes) {
		for(int i = 0; i < nodes.getLength(); i ++) {
			Node n = nodes.item(i);
			switch(n.getNodeType()) {
				case Node.COMMENT_NODE:
					System.out.println("Commentaire : " + ((Comment)n).getTextContent());
					break;
				case Node.TEXT_NODE:
					System.out.println("Texte : " + n.getNodeValue());
					break;
				case Node.ELEMENT_NODE:
					System.out.println("Balise : " + ((Element)n).getTagName());
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
					explore(n.getChildNodes());
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					break;
				case Node.ATTRIBUTE_NODE:
					System.out.println("Attribut : " + n.getNodeName());
					break;
			}
		}
	}

}
