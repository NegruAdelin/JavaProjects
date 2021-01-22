import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame{
	private JFrame frame = new JFrame();
	private JLabel[] field = new JLabel[2];
	private JLabel error = new JLabel();
	private JTextField text = new JTextField(16);
	private JPasswordField password = new JPasswordField(16);
	private JButton login = new JButton("Login");
	
	public Main() {	
		
		
		field[0] = new JLabel("Username");
		field[1] = new JLabel("Password");
		
		frame.setTitle("Login");
		frame.setSize(300, 200);
		frame.setLocation(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.add(field[0]);
		frame.add(text);
		frame.add(field[1]);
		frame.add(password);
		frame.add(login);
		frame.add(error);
		frame.setResizable(false);
		
		Listener action = new Listener();
		login.addActionListener(action);
		
		
		
		frame.setVisible(true);
		
	}
	
	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(text.getText().equals("NegruAdelin") && password.getText().equals("123456789")) {
				new Home();
				frame.setVisible(false);
			}
			else {
				if(text.getText().equals("") || password.getText().equals("")) {
					error.setForeground(Color.ORANGE);
					error.setText("Forgot to fill in one or all fields, please fill it in!!!");
				}
				else {
					error.setForeground(Color.RED);
					error.setText("Your username or password is wrong !!!");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		 new Main();
		
	}
}
