package storage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import context.Const;

public class StorageAccess {
	private static int USERS_LAST_ID = 0;
	
	public static void AddNewUser(String username, String password) throws JAXBException, IOException {
		File xml = new File(Const.XMLPATH);
		Storage s;
		JAXBContext context = JAXBContext.newInstance(Storage.class);
		
		//write to XML
		//create new user
		User user = new User();
		user.setId(USERS_LAST_ID);
		user.setUsername(username);
		user.setPassword(password);
		USERS_LAST_ID++;
		
		if(xml.exists()){
			//unmarshal existing data
			Unmarshaller u = context.createUnmarshaller();
			s = (Storage) u.unmarshal(xml);
		} else {
			s = new Storage();
		}
		//add new user to existing users
		s.setUserList(user);
		
		//marshal back to xml
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(s, xml);
	}
	
	public static User FindUser(String username, String password) throws JAXBException {
		File xml = new File(Const.XMLPATH);
		
		if(xml.exists()){
			JAXBContext context = JAXBContext.newInstance(Storage.class);
			
			//unmarshal existing data
			Unmarshaller u = context.createUnmarshaller();
			Storage s = (Storage) u.unmarshal(xml);
			
			//get hash map of all users
			HashMap<String, User> usersMap = s.getUserList();
			
			//find user
			User user = usersMap.get(username);
			
			//check user password
			if(user != null && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
	
}
