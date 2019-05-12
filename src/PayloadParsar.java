
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PayloadParsar  implements Cloneable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub


        List<String> payloadFragments = new ArrayList<>();
        try {
            // Load result into xml doc
        	String rootXmlPayload = 
        			//"<#if ncsAction == \"edit-config\">\n" + 
        			"<payloads>\n" + 
        			"  <payload>\n" + 
        			"     <managed-cpe xmlns=\"http://cisco.com/vms/config-mgmt/managed-cpe\">\n" + 
        			"        <service-name>${subscriptionId}</service-name>\n" + 
        			"        <provider>${provider.name}</provider>\n" + 
        			"        <tenant>${tenant.name}</tenant>\n" + 
        			"        <infrastructure>\n" + 
        			"          <day0-common>config-mgmt</day0-common>\n" + 
        			"          <device-credential>\n" + 
        			"             <username>cisco</username>\n" + 
        			"             <password>cisco123</password>\n" + 
        			"             <sec-password>cisco123</sec-password>\n" + 
        			"             <snmp-community-ro>ciso123</snmp-community-ro>\n" + 
        			"           </device-credential>\n" + 
        			"        </infrastructure>\n" + 
        			"     </managed-cpe>\n" + 
        			"  </payload>\n" + 
        			"  <payload>\n" + 
        			"	<action xmlns=\"http://cisco.com/vms/config-mgmt/managed-cpe\">\n" + 
        			"    	<data>\n" + 
        			"      	<custom-action xmlns=\"http://cisco.com/yang/nso/custom-action\">\n" + 
        			"        <delete>\n" + 
        			"          <service>${subscriptionId}</service>\n" + 
        			"          <offering-type>manage_device</offering-type>\n" + 
        			"        </delete>\n" + 
        			"      </custom-action>\n" + 
        			"    </data>\n" + 
        			"    </action>\n" + 
        			"  </payload>\n" + 
        			"</payloads>\n";
        			//"</#if>"
        			;
            Document rootXmlDocument = buildDocumentFromXMLString(rootXmlPayload);
            Element rootXmlNode = rootXmlDocument.getDocumentElement();

            // Look for children called payload. i.e..Find <payload> child nodes.
            NodeList childPayloads = rootXmlNode.getElementsByTagName("payload");

            boolean isMultiPart = (childPayloads == null || childPayloads.getLength() == 0) ? false : true;
            boolean isXPathPrefixNeeded = isMultiPart;      // if payload is MultiPart, all parts will be under /payloads/payload, that would USUALLY require XPaths to be prefixed with payloads/payload

            /*if (serviceExtensionTemplate != null) {

                //Get service extension data from the UI / request payload data map.
                Map subscriptionDetail = (HashMap) dataModel.get("subscriptionDetail");
                Map serviceInstanceDetail = (subscriptionDetail != null) ? (HashMap) subscriptionDetail.get("serviceInstanceDetail") : null;
                List<Map> serviceExtensions = (serviceInstanceDetail != null) ? (List<Map>) serviceInstanceDetail.get("serviceExtensions") : null;

                if (serviceExtensions == null) {
                    // Portal action is APPLY_SERVICE_EXTENSIONS
                    isXPathPrefixNeeded = false;    // The XPaths in the data model must not be prefixed here because they are already prefixed
                    serviceExtensions = (List<Map>) dataModel.get("serviceExtensions");
                }
                //Apply Service extensions.
                applyServiceExtensions(rootXmlDocument, serviceExtensionTemplate, serviceExtensions, isXPathPrefixNeeded);
            }*/

            if (!isMultiPart) {
                // single payload. return the original payload without
                // transforming it.
                //log.debug("MULTIPART Single Payload " + rootXmlPayload);
                payloadFragments.add(rootXmlPayload);
                //return payloadFragments;
            } else {
                for (int i = 0; i < childPayloads.getLength(); i++) {
                    Node childPayLoad = childPayloads.item(i);
                    Node serviceNode = getFirstChildNode(childPayLoad, Node.ELEMENT_NODE);
                    // Get the xmlcontent
                    //String childPayLoadContent = getNodeContent(serviceNode);
                    // Add resulting xml to result array.
                    //log.debug("MULTIPART Fragment Payload " + childPayLoadContent);
                    //payloadFragments.add(childPayLoadContent);
                }
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
        }

    
	}
	private static Node getFirstChildNode(Node node, int nodeType) {

        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node childNode = node.getChildNodes().item(i);
            if (childNode.getNodeType() == nodeType) {
                return childNode;
            }
        }
        return null;
    }
	public static Document buildDocumentFromXMLString(String xml) throws ParserConfigurationException, IOException, SAXException {

        // Create a Document out of the response MULTIPART
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));
    }
	
	public Object clone() throws CloneNotSupportedException{  
		return new PayloadParsar();
	}
		 
}
