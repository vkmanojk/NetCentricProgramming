package excel_xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class JDBC_excel {
	public static void main(String[] args) throws Exception {
		Fillo fillo = new Fillo();
		com.codoid.products.fillo.Connection connection = fillo.getConnection("./Book1.xlsx");
		System.out.println("Existing record in the excel sheet");
		String strQuery = "Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {
			System.out.println("name: " + recordset.getField("name") + " email:	" + recordset.getField("email"));
		}
		System.out.println();
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("./database.xml"));
		doc.getDocumentElement().normalize();
		System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());
		NodeList listOfPersons = doc.getElementsByTagName("Profile");
		for (int s = 0; s < listOfPersons.getLength(); s++) {
			Node firstPersonNode = listOfPersons.item(s);
			if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
				Element firstPersonElement = (Element) firstPersonNode;
				NodeList nameList = firstPersonElement.getElementsByTagName("Name");
				Element nameElement = (Element) nameList.item(0);
				NodeList textFNList = nameElement.getChildNodes();
				String name = ((Node) textFNList.item(0)).getNodeValue().trim();
				NodeList emailList = firstPersonElement.getElementsByTagName("Email");
				Element emailElement = (Element) emailList.item(0);
				NodeList textLNList = emailElement.getChildNodes();
				String email = ((Node) textLNList.item(0)).getNodeValue().trim();
				connection.executeUpdate("insert into Sheet1(Name,email) values('" + name + "','" + email + "')");
			}
		}
		System.out.println("\nContents after inserting data to excel file");
		strQuery = "Select * from Sheet1";
		recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {
			System.out.println("name: " + recordset.getField("name") + " email:	" + recordset.getField("email"));
		}
		recordset.close();
		connection.close();
	}

}
