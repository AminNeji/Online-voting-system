package ovs;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class adminlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	private JTextField cinf;
	private JPasswordField passf;
	private JTextField namef;
	private JTextField lastnf;
	private JTextField cinf_1;
	private JPasswordField passfsignup;
	private JTextField emailf;
	 private JLabel imageLabel;
	
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
	public adminlogin() {
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
		
		JLabel lblNewLabel = new JLabel("ADMIN - LOGIN");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel.setBounds(112, 46, 248, 42);
		login.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(58, 147, 117, 42);
		login.add(lblNewLabel_1_1);
		JLabel imageLabel = new JLabel();
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pass.setBounds(58, 247, 117, 42);
		login.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have account ?");
		lblNewLabel_1.setBounds(223, 397, 117, 13);
		login.add(lblNewLabel_1);
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cinl=cinf.getText();
				String passl=passf.getText();
				if(cinl.length()<8 || passl.length()<3) {
					JOptionPane.showMessageDialog(null, "Login informations incorrect");
				}
				if(con!=null) {
					try {
						PreparedStatement pst=con.prepareStatement("select * from admins where cin=? and pass=?");
						pst.setInt(1, Integer.parseInt(cinl));
						pst.setString(2, passl);
						ResultSet res2=pst.executeQuery();
						if(res2.next()) {
							String name=res2.getString("name");
							String lastname=res2.getString("lastname");
							String email=res2.getString("email");
							int cin=Integer.parseInt(cinl);
							admininterface af=new admininterface(cin,name,lastname,email,passl);
							af.show();
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "ADMIN doesn't exist.");
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
		
		cinf = new JTextField();
		cinf.setBounds(46, 186, 351, 35);
		login.add(cinf);
		cinf.setColumns(10);
		
		passf = new JPasswordField();
		passf.setBounds(46, 287, 351, 35);
		login.add(passf);
		
		
		
		JLabel lblSignup = new JLabel("ADMIN - SIGNUP");
		lblSignup.setForeground(new Color(128, 0, 0));
		lblSignup.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblSignup.setBounds(98, 34, 276, 42);
		signup.add(lblSignup);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CIN");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(58, 188, 117, 42);
		signup.add(lblNewLabel_1_1_1);
		
		JLabel pass_1 = new JLabel("Password");
		pass_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass_1.setBounds(58, 241, 117, 42);
		signup.add(pass_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Already a user ?");
		lblNewLabel_1_2.setBounds(257, 397, 117, 13);
		signup.add(lblNewLabel_1_2);
		
		JButton loginbtn_1 = new JButton("Sign Up");
		loginbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=namef.getText();
				String lastname=lastnf.getText();
				String cin=cinf_1.getText();
				String pass=passfsignup.getText();
				String email=emailf.getText();
				byte[] imageData = getImageData();
				if(cin.length()<8) {
					JOptionPane.showMessageDialog(null, "Verify Your CIN !");
				}
				if(pass.length()<3) {
					JOptionPane.showMessageDialog(null, "Verify Your Password !");
				}
				if(con!=null) {
				try {
					pst=con.prepareStatement("select * from admins where cin=?");
					pst.setInt(1,Integer.parseInt(cin));
					ResultSet res=pst.executeQuery();
					if(res.next()) {
						JOptionPane.showMessageDialog(null, "An Admin with this cin"+cin+" already exist");
					}
					else {
						PreparedStatement pst2=con.prepareStatement("insert into admins(cin,name,lastname,pass,email) values(?,?,?,?,?)");
						pst2.setInt(1, Integer.parseInt(cin));
						pst2.setString(2, name);
						pst2.setString(3, lastname);
						pst2.setString(4, pass);
						pst2.setString(5,email);
						pst2.executeUpdate();
						
						
					}
				}
				catch(SQLException e1) {
					
				}
				namef.setText("");
				lastnf.setText("");
				passfsignup.setText("");
				cinf_1.setText("");
				emailf.setText("");
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
		loginbtn_1.setBounds(46, 380, 106, 41);
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
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(58, 139, 117, 42);
		signup.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Name");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(58, 87, 117, 42);
		signup.add(lblNewLabel_1_1_1_2);
		
		namef = new JTextField();
		namef.setBounds(46, 119, 351, 27);
		signup.add(namef);
		namef.setColumns(10);
		
		lastnf = new JTextField();
		lastnf.setColumns(10);
		lastnf.setBounds(46, 171, 351, 27);
		signup.add(lastnf);
		
		cinf_1 = new JTextField();
		cinf_1.setColumns(10);
		cinf_1.setBounds(46, 221, 351, 27);
		signup.add(cinf_1);
		
		passfsignup = new JPasswordField();
		passfsignup.setBounds(46, 279, 351, 27);
		signup.add(passfsignup);
		
		JLabel lblNewLabel_3 = new JLabel("Email ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(56, 317, 46, 14);
		signup.add(lblNewLabel_3);
		
		emailf = new JTextField();
		emailf.setBounds(46, 342, 351, 27);
		signup.add(emailf);
		emailf.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("...");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));
                
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileChooser.getSelectedFile();
                    String filePath = file.getAbsolutePath();
                }
            }
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(403, 223, 38, 23);
		signup.add(btnNewButton_2);
	}
	private byte[] getImageData() {
		Icon icon = imageLabel.getIcon();
        if (icon instanceof ImageIcon) {
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0,0);
            g.dispose();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "png", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return out.toByteArray();
        }
        return null;
    }
}
