package object.dataobjects;

public class UserObject {
	public int userID;
	public String userName;
	
	public UserObject(int userID, String userName){
		this.userID=userID;
		this.userName=userName;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
