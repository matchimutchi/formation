package javaApiDom;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class App {

	public static void main(String[] args) throws TransformerConfigurationException {
		
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
			
			
			System.out.println("----------------XPATH------------------------");
			
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			
			//requette XPath
			XPathExpression xpe = xp.compile("//catalog/book[price>10]/title/text()");
			//execution de la requette
			NodeList result = (NodeList)xpe.evaluate(doc1,XPathConstants.NODESET);
			
			//parcour des resultats
			for(int i = 0; i < result.getLength(); i++) {
				
				System.out.println(result.item(i).getNodeValue());
				
			}
			
			
			System.out.println("----------------XPATH2------------------------");
			Document doc2 = db.parse(new File("nutrition.xml"));
			
			//XPathExpression xpe2 = xp.compile("//nutrition/food/name/text()");
			//XPathExpression xpe2 = xp.compile("//nutrition/food[cholesterol>20]/name/text()");
			XPathExpression xpe2 = xp.compile("//nutrition/food/calories[@fat<50]/../name/text()");
			result = (NodeList)xpe2.evaluate(doc2,XPathConstants.NODESET);
			
			
			for(int i = 0; i < result.getLength(); i++) {
				
				System.out.println(result.item(i).getNodeValue());
				
			}
			
			
			System.out.println("----------------XPATH3------------------------");
			
			
			XPathExpression xpe3 = xp.compile("sum(//nutrition/food/calories[@fat<50]/../protein) div count(//nutrition/food/calories[@fat<50])");
			
			double total = (double)xpe3.evaluate(doc2,XPathConstants.NUMBER);
			
			System.out.println("moyenne proteines = " + total);

			
			System.out.println("----------------CREATION DE DOCUMENT------------------------");
			
			
			//document vide
			Document doc3 = db.newDocument();
			
			//balise racine du document
			Element racine = doc3.createElement("comptes");
			doc3.appendChild(racine);
			
			Random rd = new Random();
			for( int i = 0; i < 10 ; i++) {
				//une balise "compte"
				Element compte = doc3.createElement("comptes");
				//ajout d'un attribut id
				compte.setAttribute("id", "" + (i + 1));
				
				
				//creation de sous balises
				Element solde = doc3.createElement("solde");
				Text texte = doc3.createTextNode("" + (rd.nextDouble() * 1000.0));
				solde.appendChild(texte);
				compte.appendChild(solde);
				
				Element proprietaire = doc3.createElement("proprietaire");
				//equivalent a creer un textNode dans la balise
				proprietaire.setTextContent("Bob " + i);
				compte.appendChild(proprietaire);
								
				racine.appendChild(compte);
			}
			
			
			//----------------ecriture on passe par des transformers------------------
			TransformerFactory tfact = TransformerFactory.newInstance();
			
			//------------------------------source------------------------------
			DOMSource source = new DOMSource(doc3);
			
			//---------------------destination -> nouvea fichier xml--------------
			StreamResult destination = new StreamResult(new File("comptes.xml"));	
			
			//-------------------------------ECRIVAIN DE XML------------------------
			Transformer tf = tfact.newTransformer();	
			
			//------------------------on veut de l'indentation------------------------
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			//----------------------------ecriture---------------------------------
			tf.transform(source, destination);
			
			
			
			
			System.out.println("----------------ECRITURE 2------------------------");
			
			XPathExpression xpe4 = xp.compile("//nutrition/food/calories[@fat<50]/..");
			result = (NodeList)xpe4.evaluate(doc2, XPathConstants.NODESET);
			
			
			
			Document doc4 = db.newDocument();
			racine = doc4.createElement("selectefoods");
			doc4.appendChild(racine);
			
			for(int i = 0; i < result.getLength(); i++) {
				//balise food provenant de nutrition.xml
				Element food = (Element)result.item(i);
				Element nourriture = doc4.createElement("nourriture");
				nourriture.appendChild(doc4.adoptNode(food.getElementsByTagName("name").item(0)));
				nourriture.appendChild(doc4.adoptNode(food.getElementsByTagName("cholesterol").item(0)));
				nourriture.appendChild(doc4.adoptNode(food.getElementsByTagName("sodium").item(0)));
				racine.appendChild(nourriture);
			}
			
			source = new DOMSource(doc4);
			destination = new StreamResult(new File("selecteFood.xml"));
			tf.transform(source, destination);
			
			//explorer 
			//explore(doc1.getChildNodes());
			
			
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | TransformerException e ) {
			e.printStackTrace();
		} 

	}
	
	
	public static void explore(NodeList nodes) {
		for(int i = 0; i < nodes.getLength(); i ++) {
			Node n = nodes.item(i);
			switch(n.getNodeType()) {
			
				//----------------------RECUPERER Les COMMENTAIRES DU FICHIER---------------------	
				case Node.COMMENT_NODE:
					System.out.println("Commentaire : " + ((Comment)n).getTextContent());
					break;
					
				//----------------------RECUPERER LES TEXTES DU FICHIER---------------------		
				case Node.TEXT_NODE:
					System.out.println("Texte : " + n.getNodeValue());
					break;
					
					
				//----------------------RECUPERER Les ELEMENTS DU FICHIER---------------------
				case Node.ELEMENT_NODE:
					Element el = (Element)n;
					System.out.println("Balise : " + el.getTagName());
					//sur une balise ouvrante 
					//je peux parcourir ses attributs
					NamedNodeMap attr = el.getAttributes();
					for(int j = 0; j < attr.getLength(); j++) {
						
						System.out.println("attribut : " + attr.item(j).getLocalName() 
												+ " - " + attr.item(j).getNodeValue());
					}
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");

					
					explore(n.getChildNodes());
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					break;
					
					
				//----------------------RECUPERER Les ATTRIBUTS DU FICHIER---------------------	
				case Node.ATTRIBUTE_NODE:
					System.out.println("Attribut : " + n.getNodeName());
					break;
			}
		}
	}

}
