import javax.swing.JOptionPane;


public class Driver extends User{


	public Driver(String username, String password) {
		
		super(username, password);
		
		if (type == 2){
			Driver_Frame w = new Driver_Frame();
			w.setTitle("������");
			w.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "�� �������� ��� ��� ����� ������. ","������", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
