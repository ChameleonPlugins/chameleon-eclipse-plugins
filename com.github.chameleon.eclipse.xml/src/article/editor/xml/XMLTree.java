/*
 * Created on Oct 11, 2004
 */
package article.editor.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Phil Zoio
 */
public class XMLTree
{

	private XMLElement rootElement;
	private List allElements = new ArrayList();
	private List allAttributes = new ArrayList();

	public XMLTree()
	{

		super();
		rootElement = new XMLElement("world");
		XMLElement continent = newDTDElement("continent");
		rootElement.addChildElement(continent);

		continent.addChildAttribute(new XMLAttribute("name")).addChildAttribute(new XMLAttribute("population"));
		addAttribute("name");
		addAttribute("population");

		XMLElement continentDescription = newDTDElement("description");
		continent.addChildElement(continentDescription);

		XMLElement country = newDTDElement("country");
		country.addChildAttribute(new XMLAttribute("name")).addChildAttribute(new XMLAttribute("population"));
		continent.addChildElement(country);

		XMLElement countryDescription = newDTDElement("description");
		country.addChildElement(countryDescription);
		XMLElement countryAttraction = newDTDElement("attraction");
		country.addChildElement(countryAttraction);
		countryAttraction.addChildAttribute(new XMLAttribute("name"));

		XMLElement city = newDTDElement("city");
		city.addChildAttribute(new XMLAttribute("name")).addChildAttribute(new XMLAttribute("population"));
		country.addChildElement(city);

		XMLElement cityDescription = newDTDElement("description");
		city.addChildElement(cityDescription);
		XMLElement cityAttraction = newDTDElement("attraction");
		cityAttraction.addChildAttribute(new XMLAttribute("name"));
		cityAttraction.addChildAttribute(new XMLAttribute("cost"));
		city.addChildElement(cityAttraction);
		addAttribute("cost");

		XMLElement ocean = newDTDElement("ocean");
		continent.addChildElement(ocean);
		ocean.addChildAttribute(new XMLAttribute("name"));
		ocean.addChildAttribute(new XMLAttribute("depth"));
		addAttribute("depth");

	}

	private XMLElement newDTDElement(String elementName)
	{
		XMLElement element = new XMLElement(elementName);
		allElements.add(element);
		return element;
	}

	private void addAttribute(String attributeName)
	{
		if (!allAttributes.contains(attributeName))
		{
			allAttributes.add(attributeName);
		}
	}

	public List getAllElements()
	{
		return allElements;
	}

	public List getAllAttributes()
	{
		return allAttributes;
	}

	public XMLElement getRootElement()
	{
		return rootElement;
	}

	public void setRootElement(XMLElement rootElement)
	{
		this.rootElement = rootElement;
	}
}