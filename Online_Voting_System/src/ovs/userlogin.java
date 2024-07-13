package ovs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class userlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cinlogin;
	private JPasswordField passlogin;
	private JTextField cinfield;
	private JPasswordField passfield;
	private JTextField lastnamefield;
	private JTextField namefield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	
	public void Connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ovs", "root", "");
			con.setAutoCommit(true);
		}
		catch(ClassNotFoundException e) {
			
		}
		catch(SQLException e) {
			
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public userlogin() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 380, 452);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\moham\\Downloads\\logo2.jpg");
		Image originalImage1 = originalIcon1.getImage();
		Image resizedImage1 = originalImage1.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
		JLabel lblNewLabel_2 = new JLabel(""); /// image(logo)
		lblNewLabel_2.setIcon(resizedIcon1);
		lblNewLabel_2.setBounds(54, 44, 255, 284);
		panel.add(lblNewLabel_2);
		
		JPanel auth = new JPanel();
		auth.setBackground(new Color(255, 255, 255));
		auth.setBounds(379, 0, 472, 452);
		contentPane.add(auth);
		auth.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setBackground(new Color(255, 255, 255));
		auth.add(login, "name_12268239789700");
		login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel.setBounds(177, 46, 117, 42);
		login.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(58, 147, 117, 42);
		login.add(lblNewLabel_1_1);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pass.setBounds(58, 247, 117, 42);
		login.add(pass);
		
		cinlogin = new JTextField();
		cinlogin.setBounds(46, 187, 351, 35);
		login.add(cinlogin);
		cinlogin.setColumns(10);
		
		passlogin = new JPasswordField();
		passlogin.setBounds(46, 288, 351, 35);
		login.add(passlogin);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have account ?");
		lblNewLabel_1.setBounds(223, 397, 117, 13);
		login.add(lblNewLabel_1);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cinl=cinlogin.getText();
				String passl=passlogin.getText();
				if(cinl.length()<8 || passl.length()<3) {
					JOptionPane.showMessageDialog(null, "Login informations incorrect");
				}
				if(con!=null) {
					try {
						PreparedStatement pst=con.prepareStatement("select * from users where cin=? and pass=?");
						pst.setInt(1, Integer.parseInt(cinl));
						pst.setString(2, passl);
						ResultSet res2=pst.executeQuery();
						if(res2.next()) {
							String name=res2.getString("name");
							String lastname=res2.getString("lastname");
							String email=res2.getString("email");
							int cin=Integer.parseInt(cinl);
							Boolean hasvoted=res2.getBoolean("hasvoted");
							userinterface uf=new userinterface(cin,name,lastname,email,passl,hasvoted);
							uf.show();
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "USER doesn't exist. Try Signing UP");
						}
					}
					catch(SQLException e2){
						
					}
				}
				else {
					System.out.println("DB NOT CONNECTED!");
				}
			}
		});
		loginbtn.setBackground(new Color(128, 0, 0));
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		loginbtn.setBounds(46, 369, 106, 41);
		login.add(loginbtn);
		
		JPanel signup = new JPanel();
		signup.setLayout(null);
		signup.setBackground(Color.WHITE);
		auth.add(signup, "name_972909563400");
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				signup.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnNewButton.setBounds(350, 384, 100, 35);
		login.add(btnNewButton);
		
		
		
		JLabel lblSignup = new JLabel("SIGNUP");
		lblSignup.setForeground(new Color(128, 0, 0));
		lblSignup.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblSignup.setBounds(170, 34, 131, 42);
		signup.add(lblSignup);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CIN");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(58, 204, 117, 42);
		signup.add(lblNewLabel_1_1_1);
		
		JLabel pass_1 = new JLabel("Password");
		pass_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass_1.setBounds(58, 257, 117, 42);
		signup.add(pass_1);
		
		cinfield = new JTextField();
		cinfield.setColumns(10);
		cinfield.setBounds(46, 236, 351, 27);
		signup.add(cinfield);
		
		passfield = new JPasswordField();
		passfield.setBounds(46, 291, 351, 27);
		signup.add(passfield);
		
		JLabel lblNewLabel_1_2 = new JLabel("Already a user ?");
		lblNewLabel_1_2.setBounds(257, 397, 117, 13);
		signup.add(lblNewLabel_1_2);
		
		JButton loginbtn_1 = new JButton("Sign Up");   // singup btn
		loginbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=namefield.getText();
				String lastname=lastnamefield.getText();
				String cin=cinfield.getText();
				
				String pass=passfield.getText();
				if(cin.length()<8) {
					JOptionPane.showMessageDialog(null, "Verify Your CIN !");
				}
				if(pass.length()<3) {
					JOptionPane.showMessageDialog(null, "Verify Your Password !");
				}
				if(con!=null) {
				try {
					pst=con.prepareStatement("select * from users where cin=?");
					pst.setString(1,cin);
					ResultSet res=pst.executeQuery();
					if(res.next()) {
						JOptionPane.showMessageDialog(null, "A user with this cin"+cin+" already exist");
					}
					else {
						PreparedStatement pst2=con.prepareStatement("insert into users(cin,name,lastname,pass,email,hasvoted) values(?,?,?,?,?,?)");
						pst2.setInt(1, Integer.parseInt(cin));
						pst2.setString(2, name);
						pst2.setString(3, lastname);
						pst2.setString(4, pass);
						pst2.setString(5, "");
						pst2.setBoolean(6,false);
						pst2.executeUpdate();
						
						
					}
				}
				catch(SQLException e1) {
					
				}
				namefield.setText("");
				lastnamefield.setText("");
				passfield.setText("");
				cinfield.setText("");
				}
				else {
					System.out.println("Connection lost");
					return;
				}
		
				login.setVisible(true);
				signup.setVisible(false);
			
			}
		});
		loginbtn_1.setForeground(Color.WHITE);
		loginbtn_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		loginbtn_1.setBackground(new Color(128, 0, 0));
		loginbtn_1.setBounds(46, 369, 106, 41);
		signup.add(loginbtn_1);
		
		JButton btnNewButton_1 = new JButton("Sign In"); // sign in btn
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				signup.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(350, 384, 100, 35);
		signup.add(btnNewButton_1);
		
		lastnamefield = new JTextField();
		lastnamefield.setColumns(10);
		lastnamefield.setBounds(46, 187, 351, 27);
		signup.add(lastnamefield);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(58, 155, 117, 42);
		signup.add(lblNewLabel_1_1_1_1);
		
		namefield = new JTextField();
		namefield.setColumns(10);
		namefield.setBounds(46, 135, 351, 27);
		signup.add(namefield);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Name");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(58, 103, 117, 42);
		signup.add(lblNewLabel_1_1_1_2);
		
		
		
		
		
		

		
	}
}
