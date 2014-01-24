public class Manager extends User{
	
	public Manager(String username, String password) throws RegisterLoginException {
		
		super(username, password);
		
		if (type != 0){
			throw new RegisterLoginException("Credentials are not valid.");
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
	
	public String[][] getUsers(String firstname, String surname, String tin, int type) throws DBIOException {
		String condition = "";
		
		if (type != 0) {
			condition += " WHERE type=" + type + " ";
			
			if (firstname != null) {
				condition += "AND firstname='" + firstname + "' ";
			}
			
			if (surname != null) {
				condition += "AND surname='" + surname + "' ";
			}
			
			if (tin != null) {
				condition += "AND tin='" + tin + "' ";
			}
			
		}
		else {
			throw new DBIOException("Invalid user type");
		}
		
		Database db = new Database();
		db.mysqlConnect();
		return db.fetchFromDatabase("users", "uid, username, password, firstname, surname, tin, address, phone, sex, type", condition);
	}
	
	public String[][] getBusses() throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		return db.fetchFromDatabase("busses", "bid, numberplate, cc, brand", "");
	}
	
	public String[][] getBusses(String numberplate) throws DBIOException {
		Database db = new Database();
		db.mysqlConnect();
		return db.fetchFromDatabase("busses", "bid, numberplate, cc, brand", "numberplate='" + numberplate + "'");
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
	
	public String getName() {
		return this.firstname + " " + this.surname;
	}
	
}
