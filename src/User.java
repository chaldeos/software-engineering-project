import javax.swing.JOptionPane;


abstract public class User {

	
	protected int uid, sex, type;
	protected String username, password, firstname, surname, tin, adress, phone;
	
	
	public User(String username, String password){
		String data[][] = null;
		try {
			data = RegisterLogin.login(username,password);
		} catch (RegisterLoginException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"׃צÜכלב", JOptionPane.PLAIN_MESSAGE);
		}
		this.uid = Integer.parseInt(data[0][0]);
		this.username =data[0][1];
		this.password = data[0][2];
		this.firstname = data[0][3];
		this.surname = data[0][4];
		this.tin = data[0][5];
		this.adress = data[0][6];
		this.phone = data[0][7];
		this.sex = Integer.parseInt(data[0][8]);
		this.type = Integer.parseInt(data[0][9]);
		
	}

}
