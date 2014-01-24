public class Manager extends User{
	
	public Manager(String username, String password) throws RegisterLoginException {
		
		super(username, password);
		
		if (type != 0){
			throw new RegisterLoginException("Τα στοιχεία σας δεν είναι έγκυρα.");
		}
		
	}
	
	public void insertUser(String username, String password, String firstname, String surname, String tin, String address, String phone, int sex, int type) throws DBIOException, RegisterLoginException {
		if (type == 0) {
			throw new RegisterLoginException("You can't insert another admin");
		}
		else {
			RegisterLogin.register(username, password, firstname, surname, tin, address, phone, sex, type);
		}
	}
	
	public String[][] getFuellings() throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		return db.fetchFromDatabase("fuellings", "fid, bid, litres, km, date, comments", "");
	}
	
	public String[][] getUsers() throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		return db.fetchFromDatabase("users", "uid, username, password, firstname, surname, tin, address, phone, sex, type", "type!=0");
	}
	
	public void editUserUsername (String username, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "username", username, "uid="+uid);
	}
	
	public void editUserPassword (String passwrod, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "password", password, "uid="+uid);
	}
	
	public void editUserFirstname (String firstname, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "firstname", firstname, "uid="+uid);
	}
	
	public void editUserSurname(String surname, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "surname", surname, "uid="+uid);
	}
	
	public void editUserTin (String tin, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "tin", tin, "uid="+uid);
	}
	
	public void editUserAddress (String address, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "address", address, "uid="+uid);
	}
	
	public void editUserPhone (String phone, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "phone", phone, "uid="+uid);
	}
	
	public void editUserSex (int sex, int uid) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		db.updateDatabase("users", "sex", Integer.toString(sex), "uid="+uid);
	}
	
	public void editUserType (int type, int uid) throws DBIOException {
		if (type == 0) {
			throw new DBIOException("You can't make someone else admin");
		}
		else {
			Database db = new Database();
			db.mysqlConnect();
			db.updateDatabase("users", "type", Integer.toString(type), "uid="+uid);
		}
	}
	
}
