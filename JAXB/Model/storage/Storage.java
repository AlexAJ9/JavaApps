package storage;

import java.util.HashMap;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Storage {

	@XmlElementWrapper
	@XmlElement (name = "user")
	private ArrayList<User> userList = new ArrayList<>();
	
	//TODO: Other data in storage

	
	public HashMap<String, User> getUserList() {
		HashMap<String, User> userMap = new HashMap<>();
		for (User u: userList) {
			userMap.put(u.getUsername(), u);
		}
		return userMap;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public void setUserList(User user) {
		this.userList.add(user);
	}
	
	
}
