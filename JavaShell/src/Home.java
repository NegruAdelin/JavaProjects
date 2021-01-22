import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Home extends JFrame {
	private JLabel[] field = new JLabel[33];
	private short nrField = 0;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField text = new JTextField();
	private static String director = new String("\"C:\\Users\\Adelin\\Music\\");
	
	public Home() {	
		frame.setTitle("Shell");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocation(150, 100);
		frame.setResizable(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.BLACK);
		
		text.setPreferredSize(new Dimension(frame.getWidth() - 30, frame.getHeight() - 575));
		text.setBorder(new SoftBevelBorder (SoftBevelBorder.RAISED));
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setCaretColor(Color.WHITE);
		text.setFont(new Font("LaTeX", Font.PLAIN, 12));
		
		frame.add(panel);
		createLabels();
		frame.add(text);
		Listener action = new Listener(); 
		text.addActionListener(action);
		
		frame.setVisible(true);
	}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			try {
				String txt = event.getActionCommand();
				
				if(txt.contains("play ")) {
					String[] s = event.getActionCommand().split("play ");
					
					if(s[1].contains("c:\\") || s[1].contains("d:\\"))
						Runtime.getRuntime().exec("cmd /c \"" + s[1] + "\"");
					else
						Runtime.getRuntime().exec("cmd /c \"" + director + s[1] + "\"");
					
					if(conditionAdd()) {
						addLabels(" ");
						addLabels(txt);
					}
					else {
						replaceLabels(" ");
						replaceLabels(txt);
					}
				}
				else
					if(txt.contains("play")) {
						if(conditionAdd()) {
							addLabels(" ");
							addLabels("Unknow command");
						}
						else {
							replaceLabels(" ");
							replaceLabels("Unknown command!!!");
						}
					}
				else {
					if(txt.contains("dir ")) {
						Process p;
						String[] s = event.getActionCommand().split("dir ");
						String[] ext = new String[5];
						ext[0] = ".mp3";ext[1] = ".aac";
						ext[2] = ".flac";ext[3] = ".ogg";
						ext[4] = ".wma";
						
						String m;
						if(s[1].contains("c:\\") || s[1].contains("d:\\")) {
							p = Runtime.getRuntime().exec("cmd /c dir /b \"" + s[1] + "\"");
						}
						else {
							p = Runtime.getRuntime().exec("cmd /c dir /b \"" + director + s[1] + "\"");
						}
						
						BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						if(conditionAdd()) {
							addLabels(" ");
							addLabels(txt);
						}
						else {
							replaceLabels(" ");
							replaceLabels(txt);
						}
						while((m = stdInput.readLine()) != null) {
							if(extAudio(ext, m)) {
								if(conditionAdd())
									addLabels(m);
								else
									replaceLabels(m);
							}
							
						}
					}
					else 
						if(txt.contains("dir")) {
							if(conditionAdd()) {
								addLabels(" ");
								addLabels("Unknow command");
							}
							else {
								replaceLabels(" ");
								replaceLabels("Unknown command!!!");
							}
						}
							
					else {
						if(txt.contains("cd ")) {
							String[] s = event.getActionCommand().split("cd ");
							director = s[1] + "\\";
							
							if(conditionAdd()) {
								addLabels(" ");
								addLabels(txt);
							}
							else {
								replaceLabels(" ");
								replaceLabels(txt);
							}
						}
						else
							if(txt.contains("cd")) {
								if(conditionAdd()) {
									addLabels(" ");
									addLabels("Unknow command");
								}
								else {
									replaceLabels(" ");
									replaceLabels("Unknown command!!!");
								}
							}
						else {
							if(txt.contains("search ")) {
								Process p;
								String[] s = event.getActionCommand().split("search ");
								String m;
								
								p = Runtime.getRuntime().exec("cmd /c dir /s /b \"" + director + "\"");
								BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
								
								if(conditionAdd()) {
									addLabels(" ");
									addLabels(txt);
								}
								else {
									replaceLabels(" ");
									replaceLabels(txt);
								}
								
								while((m = stdInput.readLine()) != null) {
									if(m.contains(s[1])) {
										if(conditionAdd()) {
											addLabels(m);
										}
										else {
											replaceLabels(m);
										}
									}
									
								}
							}
							else
								if(txt.contains("search")) {
									if(conditionAdd()) {
										addLabels(" ");
										addLabels("Unknow command");
									}
									else {
										replaceLabels(" ");
										replaceLabels("Unknown command!!!");
									}
								}
							else {
								if(txt.contains("rename ")) {
									String[] s = event.getActionCommand().split("rename ");
									Runtime.getRuntime().exec("cmd /c rename \"" + director + s[1] + "\"");
									
									if(conditionAdd()) {
										addLabels(" ");
										addLabels(txt);
									}
									else {
										replaceLabels(" ");
										replaceLabels(txt);
									}
								}
								else
									if(txt.contains("rename")) {
										if(conditionAdd()) {
											addLabels(" ");
											addLabels("Unknow command");
										}
										else {
											replaceLabels(" ");
											replaceLabels("Unknown command!!!");
										}
									}
								else {
									if(txt.equals("cls")) {
										for(short i =0; i < nrField; i++) {
											field[i].setVisible(false);
										}
									}
									else {
										if(txt.equals("exit"))
											frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
										else {
											if(conditionAdd()) {
												addLabels(" ");
												addLabels("Unknow command");
											}
											else {
												replaceLabels(" ");
												replaceLabels("Unknown command!!!");
											}
										}
											
									}
								}
							}
						}
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			text.setText("");
		}
	}
	
	
	public void createLabels() {
		for(short i = 0; i < 33; i++ ) {
			field[i] = new JLabel();
			field[i].setFont(new Font("LaTeX", Font.PLAIN, 12));
			field[i].setForeground(Color.WHITE);
			field[i].setVisible(false);
		}
		for(short i = 0; i < 33; i++) {
			panel.add(field[i]);
		}
	}
	
	public boolean conditionAdd() {
		return (nrField != 33);
	}
	
	public boolean extAudio(String[] ext, String line) {
		for(short i = 0; i < ext.length; i++) {
			if(line.contains(ext[i]))
				return true;
		}
		return false;
	}
	
	public void addLabels(String txt) {
		field[nrField].setText(txt);
		field[nrField].setVisible(true);
		nrField++;
	}
	
	public void replaceLabels(String txt) {
		
		for(short i = 0; i < nrField - 1; i++) {
			field[i].setText(field[i + 1].getText()); 
		}
		field[nrField - 1].setText(txt);
	}

}
