package ovs;
import java.sql.*;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;


import java.awt.EventQueue;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Component;

import javax.swing.table.TableCellEditor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class userinterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namef;
	private JTextField lastnamef;
	private JTextField emailf;
	private JTextField passf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*userinterface frame = new userinterface(cin,name,lastname,email,passl,hasvoted);
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection con;
	private JTable table;
	private JPanel elections;
	private JTable table_1;
	private JTextField canid;
	private JTextField elecid;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ovs","root","");
		}
		catch(ClassNotFoundException e) {
			
		}
		catch(SQLException e2) {
			
		}
	}
	
	public class NonEditableTableModel extends DefaultTableModel {

	    private static final long serialVersionUID = 1L;

	    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
	        super(data, columnNames);
	    }

	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false; // Makes all cells non-editable
	    }
	}

	

	/**
	 * Create the frame.
	 */
	public userinterface(int cin,String name,String lastname,String email,String passl,boolean hasvoted) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(232, 232, 232));
		panel.setBounds(0, 40, 130, 391);
		contentPane.add(panel);
		
		JPanel title = new JPanel();
		title.setBackground(new Color(232, 232, 232));
		title.setBounds(0, 0, 805, 42);
		contentPane.add(title);
		title.setLayout(null);
		
		
		
		JLabel welcome = new JLabel("Welcome"+" "+name+" "+lastname);
		welcome.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		welcome.setBounds(43, 11, 319, 20);
		title.add(welcome);
		
		
		
		JPanel panels = new JPanel();
		panels.setBounds(129, 40, 676, 378);
		contentPane.add(panels);
		panels.setLayout(new CardLayout(0, 0));
		
		elections = new JPanel();
        elections.setBounds(10, 10, 480, 280);
        panels.add(elections);
        elections.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 71, 676, 157);  
        
        elections.add(scrollPane);
        table = new JTable();
        String [] header=new String [] {"ID", "Name", "Location","Start Date","End Date","Number of candidates","Action"};
        Object [] rows=new Object[7];
        table.setModel(new NonEditableTableModel(null,header));
        scrollPane.setViewportView(table);
        
        JLabel lblNewLabel_1 = new JLabel("Available Elections ");
        lblNewLabel_1.setForeground(Color.GRAY);
        lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
        lblNewLabel_1.setBounds(10, 11, 312, 45);
        elections.add(lblNewLabel_1);
        
        JLabel lblNewLabel_5 = new JLabel("Choose Election's Id :");
        lblNewLabel_5.setBounds(66, 300, 135, 14);
        elections.add(lblNewLabel_5);
        
        elecid = new JTextField();
        elecid.setBounds(245, 297, 236, 20);
        elections.add(elecid);
        elecid.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Apply Now ");
        lblNewLabel_6.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_6.setBounds(10, 239, 236, 48);
        elections.add(lblNewLabel_6);
        
        JScrollPane scrollPanevote = new JScrollPane();
        scrollPanevote.setBounds(0, 84, 676, 294); 
    
		JPanel vote = new JPanel();
		panels.add(vote, "name_16767562947500");
		vote.setLayout(null);
		vote.add(scrollPanevote);
		JTable tablevote = new JTable();
		String[] columnNames = {"CIN", "User Name", "Election ID", "Election Name", "End Date", "Candidate Name", "Candidate Lastname"};
		tablevote.setModel(new NonEditableTableModel(null,columnNames));
		scrollPanevote.setViewportView(tablevote);
		
		JLabel lblNewLabel_7 = new JLabel("Voting History");
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_7.setBounds(30, 35, 277, 38);
		vote.add(lblNewLabel_7);
		
		JPanel logout = new JPanel();
		panels.add(logout, "name_16813694683000");
		logout.setLayout(null);
		
		JPanel profileo = new JPanel();
		panels.add(profileo, "name_16828670481900");
		profileo.setLayout(null);
		
		JLabel namel = new JLabel("Your Name :");
		namel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		namel.setBounds(61, 82, 117, 14);
		profileo.add(namel);
		
		JLabel lblYourLastname = new JLabel("Your lastname :");
		lblYourLastname.setBounds(61, 142, 117, 14);
		profileo.add(lblYourLastname);
		
		JLabel lblEmail = new JLabel("Your Email :");
		lblEmail.setBounds(61, 207, 117, 14);
		profileo.add(lblEmail);
		
		JLabel lblYourPassword = new JLabel("Your Password :");
		lblYourPassword.setBounds(61, 268, 117, 14);
		profileo.add(lblYourPassword);
		
		namef = new JTextField();
		namef.setBounds(201, 79, 276, 20);
		profileo.add(namef);
		namef.setColumns(10);
		namef.setText(name);
		
		lastnamef = new JTextField();
		lastnamef.setColumns(10);
		lastnamef.setBounds(201, 139, 276, 20);
		profileo.add(lastnamef);
		lastnamef.setText(lastname);
		
		emailf = new JTextField();
		emailf.setColumns(10);
		emailf.setBounds(201, 204, 276, 20);
		profileo.add(emailf);
		emailf.setText(email);
		
		passf = new JTextField();
		passf.setColumns(10);
		passf.setBounds(201, 265, 276, 20);
		profileo.add(passf);
		passf.setText(passl);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
			    if (con != null) {
			        if (passf.getText().equals(passl) && emailf.getText().equals(email) && lastnamef.getText().equals(lastname) && namef.getText().equals(name)) {
			            JOptionPane.showMessageDialog(null, "No changes applied");
			        } else {
			            String name = namef.getText();
			            String lastname = lastnamef.getText();
			            String pass = passf.getText();
			            String email = emailf.getText();
			            PreparedStatement pst = null;
			            try {
			                pst = con.prepareStatement("UPDATE users SET name = ?, lastname = ?, pass = ?, email = ? WHERE cin = ?");
			                pst.setString(1, name);
			                pst.setString(2, lastname);
			                pst.setString(3, pass);
			                pst.setString(4, email);
			                pst.setInt(5, cin);
			                pst.executeUpdate();
			                JOptionPane.showMessageDialog(null, "Update Done");
			            } catch (SQLException e1) {
			                e1.printStackTrace();
			            } finally {
			                try {
			                    if (pst != null) pst.close();
			                    if (con != null) con.close();
			                } catch (SQLException e2) {
			                    e2.printStackTrace();
			                }
			            }
			        }
			   }
			}
		});
		update.setBounds(527, 326, 89, 23);
		profileo.add(update);
		
		JLabel lblNewLabel = new JLabel("Your Personal informations ");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 20));
		lblNewLabel.setBounds(61, 30, 253, 23);
		profileo.add(lblNewLabel);
		
		JPanel afterelection = new JPanel(); /////////////////////////////////////////////////////////////////
		panels.add(afterelection, "name_10792413227900");
		afterelection.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 77, 676, 149);
		afterelection.add(scrollPane_1);
		
		String []header2=new String []{"ID","Name","LastName","Email"};
		table_1 = new JTable();
		table_1.setBounds(0, 0, 1, 1);
		table_1.setModel(new DefaultTableModel(null,header2));
        scrollPane_1.setViewportView(table_1);
        
        JLabel lblNewLabel_2 = new JLabel("Vote Now :");
        lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 28));
        lblNewLabel_2.setBounds(26, 269, 166, 24);
        afterelection.add(lblNewLabel_2);
        
        canid = new JTextField();
        canid.setBounds(193, 318, 217, 20);
        afterelection.add(canid);
        canid.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Candidate's ID :");
        lblNewLabel_3.setBounds(73, 321, 113, 14);
        afterelection.add(lblNewLabel_3);
        
        JButton lastvote = new JButton("VOTE");
        lastvote.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Connect();
        		if(con!=null) {
        			try {
        				int elid=Integer.parseInt(elecid.getText());
        				int candid =Integer.parseInt(canid.getText());
        				PreparedStatement ps=con.prepareStatement("select * from votes WHERE user_cin = ? AND election_id = ?");
        				 ps.setInt(1, cin);
        		         ps.setInt(2, elid);
        				ResultSet result=ps.executeQuery();
        				if(result.next()) {
        					JOptionPane.showMessageDialog(null, "You have already voted in this election! ");
        				}
        				else {
        					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to vote for this candidate?", "Confirm Vote",
        	                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	                
        	                if (response == JOptionPane.YES_OPTION) {
        	                	PreparedStatement pr=con.prepareStatement("INSERT INTO votes (user_cin, election_id, candidate_id) VALUES (?, ?, ?)");
        	                	pr.setInt(1, cin);
        	                    pr.setInt(2, elid);
        	                    pr.setInt(3, candid);
        	                    int rowsAffected = pr.executeUpdate();
        	                    if (rowsAffected > 0) {
        	                        System.out.println("Vote confirmed and recorded.");
        	                        JOptionPane.showMessageDialog(null, "Your vote has been recorded. Thank you!");
        	                    } else {
        	                        System.out.println("Failed to record vote.");
        	                    }
        	                } else if (response == JOptionPane.NO_OPTION) {
        	                	System.out.println("Vote canceled.");
        	                }
        				}
        			}
        			catch(SQLException e0) {
        				e0.printStackTrace();
        			}
        		}
        		
        	}
        });
        lastvote.setBounds(420, 317, 89, 23);
        afterelection.add(lastvote);
        
        JLabel lblNewLabel_4 = new JLabel("Available Candidates");
        lblNewLabel_4.setForeground(Color.GRAY);
        lblNewLabel_4.setBackground(Color.GRAY);
        lblNewLabel_4.setFont(new Font("Segoe UI Historic", Font.BOLD, 22));
        lblNewLabel_4.setBounds(10, 30, 289, 24);
        afterelection.add(lblNewLabel_4);
		
		
		
		
		
		ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\moham\\Downloads\\search.png");
		Image originalImage1 = originalIcon1.getImage();
		Image resizedImage1 = originalImage1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
		panel.setLayout(null);
		JButton candidates_1 = new JButton(resizedIcon1);
		candidates_1.setBounds(10, 64, 120, 46);
		candidates_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		candidates_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		candidates_1.setContentAreaFilled(false);
		candidates_1.setBorderPainted(false);
		candidates_1.setFocusPainted(false);
		panel.add(candidates_1);
		candidates_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				if(con!=null) {
					try {
					    PreparedStatement pst = con.prepareStatement("SELECT * FROM elections where end_date >= CURDATE()");
					    ResultSet res = pst.executeQuery();
					    DefaultTableModel model = (DefaultTableModel) table.getModel();
					    model.setRowCount(0);
					    /*if (model.getColumnCount() < 7) {
			                model.addColumn("Action");
					    }*/
					    table.getColumn("Action").setCellRenderer(new ButtonRenderer());
					    table.getColumn("Action").setCellEditor(
					        new ButtonEditor(new JCheckBox()));
					    while (res.next()) {
					        Object[] rows = new Object[7]; 

					        rows[0] = res.getInt("id");
					        rows[1] = res.getString("name");
					        rows[2] = res.getString("location");
					        rows[3] = res.getDate("start_date");
					        rows[4] = res.getDate("end_date");

					        PreparedStatement pst2 = con.prepareStatement("SELECT count(*) as nmbrc FROM candidates WHERE election_id = ?");
					        pst2.setInt(1, res.getInt("id"));
					        ResultSet res2 = pst2.executeQuery();

					        if (res2.next()) {
					            rows[5] = res2.getInt("nmbrc");
					        }
					        rows[6] = "Vote Now";
					        model.addRow(rows);

					        res2.close();
					        pst2.close();
					    }

					  
					    res.close();
					    pst.close();

					   
					    con.close();
					} catch (Exception e5) {
					    e5.printStackTrace();
					}

				}
				elections.setVisible(true);
				vote.setVisible(false);
				logout.setVisible(false);
				profileo.setVisible(false);
				afterelection.setVisible(false);
			}
		});
		
		ImageIcon originalIcon2 = new ImageIcon("C:\\Users\\moham\\Downloads\\votehistory.png");
		Image originalImage2 = originalIcon2.getImage();
		Image resizedImage2 = originalImage2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		
		JButton vote_1 = new JButton(resizedIcon2);
		vote_1.setBounds(18, 153, 100, 34);
		vote_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		vote_1.setContentAreaFilled(false);
		vote_1.setBorderPainted(false);
		vote_1.setFocusPainted(false);
		panel.add(vote_1);
		
		vote_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
		        if (con != null) {
		            try {
		            	String query = "SELECT users.cin, users.name AS user_name, elections.id AS election_id, elections.name AS election_name, elections.end_date, candidates.name AS candidate_name, candidates.lastname AS candidate_lastname FROM votes  JOIN users ON votes.user_cin = users.cin JOIN elections ON votes.election_id = elections.id JOIN candidates ON votes.candidate_id = candidates.id WHERE users.cin = ?";
		                PreparedStatement ps = con.prepareStatement(query);
		                ps.setInt(1, cin);
		                ResultSet rs = ps.executeQuery();

		                DefaultTableModel modelvote = (DefaultTableModel) tablevote.getModel();
		                modelvote.setRowCount(0);
					    

		              
		                while (rs.next()) {
		                    int cin1 = rs.getInt("cin");
		                    String userName = rs.getString("user_name");
		                    int electionId = rs.getInt("election_id");
		                    String electionName = rs.getString("election_name");
		                    Date endDate = rs.getDate("end_date");
		                    String candidateName = rs.getString("candidate_name");
		                    String candidateLastName = rs.getString("candidate_lastname");
		                    Object[] row = {cin1, userName, electionId, electionName, endDate, candidateName, candidateLastName};
		                    System.out.println("Row Data: " + Arrays.toString(row)); 
		                    modelvote.addRow(row);
		                }
		                if (modelvote.getRowCount() == 0) {
		                    System.out.println("No data found for CIN: " + cin); 
		                }
		            } catch (SQLException e3) {
		                e3.printStackTrace();
		            }
		        }

				elections.setVisible(false);
				vote.setVisible(true);
				logout.setVisible(false);
				profileo.setVisible(false);
				afterelection.setVisible(false);
				
			}
		});
		
		ImageIcon originalIcon = new ImageIcon("C:\\Users\\moham\\Downloads\\switch.png");
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		JButton logout_1 = new JButton(resizedIcon);
		logout_1.setBounds(27, 311, 83, 34);
		logout_1.setContentAreaFilled(false);
		logout_1.setBorderPainted(false);
		logout_1.setFocusPainted(false);

		logout_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		panel.add(logout_1);
		
		
		
		ImageIcon originalIcon3 = new ImageIcon("C:\\Users\\moham\\Downloads\\profile.png");
		Image originalImage3 = originalIcon3.getImage();
		Image resizedImage3 = originalImage3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon3 = new ImageIcon(resizedImage3);
		
		JButton profile = new JButton(resizedIcon3);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elections.setVisible(false);
				vote.setVisible(false);
				logout.setVisible(false);
				afterelection.setVisible(false);
				profileo.setVisible(true);
				
			}
		});
		profile.setBounds(27, 230, 83, 34);
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		profile.setFocusPainted(false);
		panel.add(profile);
		
		
		logout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elections.setVisible(false);
				vote.setVisible(false);
				logout.setVisible(true);
				JOptionPane.showMessageDialog(null,"You have successfully logged out. Thank you for using our online voting system. See you soon!");
				try{
					Thread.sleep(2);
				}
				catch(InterruptedException e3) {
					e3.getMessage();
				}
				System.exit(0);
			}
		});
		JButton btnNewButton = new JButton("View Candidates");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Connect();
        		if(con!=null) {
        			int elid=Integer.parseInt(elecid.getText());
        			try {
        				PreparedStatement ps=con.prepareStatement("Select * from elections where id = ?");
        				ps.setInt(1, elid);
        				ResultSet rs=ps.executeQuery();
        				if(rs.next()) {
        					PreparedStatement ps2=con.prepareStatement("Select * from candidates where election_id=?");
        					ps2.setInt(1, elid);
        					ResultSet rs2=ps2.executeQuery();
        					DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();
    					    model2.setRowCount(0);
    					    while(rs2.next()) {
    					    	Object [] rows2=new Object [4];
    					    	rows2[0]=rs2.getInt("id");
    					    	rows2[1]=rs2.getString("name");
    					    	rows2[2]=rs2.getString("lastname");
    					    	rows2[3]=rs2.getString("email");
    					    	model2.addRow(rows2);
    					    }
    					    elections.setVisible(false);
    					    afterelection.setVisible(true);
    					    vote.setVisible(false);
    					    profileo.setVisible(false);
    					    logout.setVisible(false);
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "Election with this ID doesn't exist!");
        				}
        			}
        			catch(SQLException e6) {
        				e6.printStackTrace();
        			}
        
        		}
        	}
        });
        btnNewButton.setBounds(527, 296, 111, 23);
        elections.add(btnNewButton);
		
	}	
}
