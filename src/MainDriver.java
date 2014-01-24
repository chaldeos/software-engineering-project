import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainDriver extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		LoginFrameDriver window = new LoginFrameDriver();
		window.setTitle("Log in");
		window.setVisible(true);
	}
}
