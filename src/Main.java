import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		LoginFrameManager window = new LoginFrameManager();
		window.setTitle("Log in");
		window.setVisible(true);		
	}
}
