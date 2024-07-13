package ovs;

import java.awt.EventQueue;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import ovs.userinterface.NonEditableTableModel;

import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admininterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField eidf;
	private JTextField enamef;
	private JTextField elocf;
	private int electionid;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					admininterface frame = new admininterface();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	private JTextField canid;
	private JTextField cancin;
	private JTextField canname;
	private JTextField canlastn;
	private JTextField canemail;
	private JTable tablem;
	private JTextField adminname;
	private JTextField adminlastn;
	private JTextField adminemail;
	private JTextField adminpass;
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
	 * @param passl 
	 * @param email 
	 * @param lastname 
	 * @param name 
	 * @param cin 
	 */
	public admininterface(int cina, String namea, String lastnamea, String emaila, String passla) {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setBackground(new Color(232, 232, 232));
		title.setBounds(0, 0, 805, 42);
		contentPane.add(title);
		
		JLabel welcome = new JLabel("Welcome "+namea.toUpperCase()+ " "+lastnamea.toUpperCase());
		welcome.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		welcome.setBounds(43, 11, 319, 20);
		title.add(welcome);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(232, 232, 232));
		panel.setBounds(0, 42, 130, 398);
		contentPane.add(panel);
		
		
		
		
		ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\moham\\Downloads\\elections.png");
		Image originalImage1 = originalIcon1.getImage();
		Image resizedImage1 = originalImage1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
		JButton elections= new JButton(resizedIcon1);
		elections.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		elections.setFocusPainted(false);
		elections.setContentAreaFilled(false);
		elections.setBorderPainted(false);
		elections.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		elections.setBounds(10, 38, 120, 46);
		panel.add(elections);
		
		
		
		
		ImageIcon originalIcon2 = new ImageIcon("C:\\Users\\moham\\Downloads\\voter.png");
		Image originalImage2 = originalIcon2.getImage();
		Image resizedImage2 = originalImage2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
		JButton voters = new JButton(resizedIcon2);
		voters.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		voters.setFocusPainted(false);
		voters.setContentAreaFilled(false);
		voters.setBorderPainted(false);
		voters.setBounds(20, 135, 100, 34);
		panel.add(voters);
		
		ImageIcon originalIcon = new ImageIcon("C:\\Users\\moham\\Downloads\\switch.png");
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		JButton logout = new JButton(resizedIcon);
		
		logout.setBounds(27, 338, 83, 34);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setFocusPainted(false);

		logout.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		panel.add(logout);
		
		
		ImageIcon originalIcon4 = new ImageIcon("C:\\Users\\moham\\Downloads\\results.png");
		Image originalImage4 = originalIcon4.getImage();
		Image resizedImage4 = originalImage4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon4 = new ImageIcon(resizedImage4);
		JButton results = new JButton(resizedIcon4);
		results.setFocusPainted(false);
		results.setContentAreaFilled(false);
		results.setBorderPainted(false);
		results.setBounds(27, 211, 83, 40);
		panel.add(results);
		
		ImageIcon originalIcon3 = new ImageIcon("C:\\Users\\moham\\Downloads\\profile.png");
		Image originalImage3 = originalIcon3.getImage();
		Image resizedImage3 = originalImage3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon3 = new ImageIcon(resizedImage3);
		JButton profile = new JButton(resizedIcon3);
		
		profile.setFocusPainted(false);
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		profile.setBounds(27, 277, 83, 34);
		panel.add(profile);
		
		JPanel panels = new JPanel();
		panels.setBounds(130, 42, 675, 398);
		contentPane.add(panels);
		panels.setLayout(new CardLayout(0, 0));
		
		JPanel electionsm = new JPanel();
		panels.add(electionsm, "name_6460737154000");
		electionsm.setLayout(null);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 70, 406, 218);
		electionsm.add(scrollPane);
		
		table = new JTable();
		
		String[] columnNames = {"ID", "Name", "Location", "Start date", "End Date"};
		table.setModel(new NonEditableTableModel(null,columnNames));
		scrollPane.setViewportView(table);
		showelections();// insert elections into the table 
		
		JLabel lblNewLabel = new JLabel("Elections Management");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(37, 20, 288, 26);
		electionsm.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 93, 46, 14);
		electionsm.add(lblNewLabel_1);
		
		eidf = new JTextField();
		eidf.setBounds(104, 91, 124, 20);
		electionsm.add(eidf);
		eidf.setColumns(10);
		
		enamef = new JTextField();
		enamef.setColumns(10);
		enamef.setBounds(104, 132, 124, 20);
		electionsm.add(enamef);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(21, 134, 46, 14);
		electionsm.add(lblNewLabel_1_1);
		
		elocf = new JTextField();
		elocf.setColumns(10);
		elocf.setBounds(104, 167, 124, 20);
		electionsm.add(elocf);
		
		JLabel lblNewLabel_1_2 = new JLabel("Location :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(21, 169, 60, 14);
		electionsm.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Start Date :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(21, 205, 73, 14);
		electionsm.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("End Date :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(21, 240, 60, 14);
		electionsm.add(lblNewLabel_1_4);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DatePicker datePicker = new DatePicker(dateSettings);
		datePicker.setBounds(104, 204, 124, 20);
        electionsm.add(datePicker);
        
        DatePickerSettings dateSettings2 = new DatePickerSettings();
        dateSettings2.setFormatForDatesCommonEra(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DatePicker dateendf = new DatePicker(dateSettings2);
		dateendf.setBounds(104, 239, 124, 20);
		electionsm.add(dateendf);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				if(con!=null) {
					if(eidf.getText().equals("") || enamef.getText().equals("") || datePicker.getDate().equals(null) || dateendf.getDate().equals(null)) {
						JOptionPane.showMessageDialog(null, "Please Fill Complete Information ");
					}
					else {
					int eid=Integer.parseInt(eidf.getText());
					String ename=enamef.getText();
					String eloc=elocf.getText();
					LocalDate selectedDate1 = datePicker.getDate();
					LocalDate selectedDate2 = dateendf.getDate();
					java.sql.Date startdate = java.sql.Date.valueOf(selectedDate1);
					java.sql.Date enddate = java.sql.Date.valueOf(selectedDate2);
					try {
						PreparedStatement statement=con.prepareStatement("INSERT INTO elections (id, name, location, start_date,end_date) VALUES (?, ?, ?, ?,?)");
						statement.setInt(1, eid);
						statement.setString(2, ename);
						statement.setString(3, eloc);
						statement.setDate(4, startdate);
						statement.setDate(5, enddate);
						int rowsInserted = statement.executeUpdate();
					    if (rowsInserted > 0) {
					        JOptionPane.showMessageDialog(null, "A new record was inserted successfully.");
					    }
					    showelections();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					eidf.setText("");
					enamef.setText("");
					elocf.setText("");
					datePicker.setDate(null);
					dateendf.setDate(null);
					}
				}
			}
		});
		add.setBounds(37, 288, 71, 23);
		electionsm.add(add);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            int eid = (int) table.getValueAt(selectedRow, 0); // Assuming ID is in column 0

		            String ename = enamef.getText();
		            String eloc = elocf.getText();

		            // Convert LocalDate to java.sql.Date
		            LocalDate startDate = datePicker.getDate();
		            LocalDate endDate = dateendf.getDate();

		            try {
		                String sql = "UPDATE elections SET name=?, location=?, start_date=?, end_date=? WHERE id=?";
		                PreparedStatement statement = con.prepareStatement(sql);

		                statement.setString(1, ename);
		                statement.setString(2, eloc);
		                statement.setDate(3, DateConverter.localDateToSqlDate(startDate));
		                statement.setDate(4, DateConverter.localDateToSqlDate(endDate));
		                statement.setInt(5, eid);

		                int rowsUpdated = statement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL");
		                }

		                statement.close();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		            showelections();
		        }
		    }
		});
		update.setBounds(158, 288, 71, 23);
		electionsm.add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				if(con!=null) {
					 int row = table.getSelectedRow();
				        if (row == -1) {
				            JOptionPane.showMessageDialog(null, "Select a record to delete!");
				        } else {
				            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirmation",
				                    JOptionPane.YES_NO_OPTION);
				            if (confirm == 0) {
				                String eid = table.getValueAt(row, 0).toString();
				                try {
				                    PreparedStatement pst = con.prepareStatement("delete from elections where id=?");
				                    pst.setString(1, eid);
				                    pst.executeUpdate();
				                    JOptionPane.showMessageDialog(null, "Election deleted successfully!");
				                    showelections();

				                } catch (SQLException e5) {
				                    e5.printStackTrace();
				                }
				                eidf.setText("");
				                enamef.setText("");
								elocf.setText("");
								datePicker.setDate(null);
								dateendf.setDate(null);
				            }
				        }
				}
			}
		});
		delete.setBounds(37, 330, 71, 23);
		electionsm.add(delete);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eidf.setText("");
				enamef.setText("");
				elocf.setText("");
				datePicker.setDate(null);
				dateendf.setDate(null);
			}
		});
		clear.setBounds(158, 330, 71, 23);
		electionsm.add(clear);
		
		JPanel candidatesm = new JPanel();
		JButton btnNewButton = new JButton("Manage Candidates >>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		        	electionid = (int) table.getValueAt(selectedRow, 0);
		            showcandidates(electionid);
		            electionsm.setVisible(false);
					candidatesm.setVisible(true);
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "Please Select an election.");
		        }
			}
		});
		btnNewButton.setBounds(518, 299, 147, 23);
		electionsm.add(btnNewButton);
		
		
		
		JPanel votersm = new JPanel();
		panels.add(votersm, "name_6500447871300");
		votersm.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel resultsm = new JPanel();
		panels.add(resultsm, "name_6520154714800");
		resultsm.setLayout(null);
		
		JPanel logoutm = new JPanel();
		panels.add(logoutm, "name_6578847040100");
		logoutm.setLayout(null);
		
		
		
		
		
		
		// candidates management
		
		
		candidatesm.setLayout(null);
		panels.add(candidatesm, "name_6910799222300");
		
		

		
		
		JLabel lblCandidatesManagement = new JLabel("Candidates Management");
		lblCandidatesManagement.setForeground(Color.GRAY);
		lblCandidatesManagement.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 23));
		lblCandidatesManagement.setBounds(37, 20, 288, 26);
		candidatesm.add(lblCandidatesManagement);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(21, 93, 46, 14);
		candidatesm.add(lblNewLabel_1_5);
		
		canid = new JTextField();
		canid.setColumns(10);
		canid.setBounds(104, 91, 124, 20);
		candidatesm.add(canid);
		
		cancin = new JTextField();
		cancin.setColumns(10);
		cancin.setBounds(104, 132, 124, 20);
		candidatesm.add(cancin);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cin :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(21, 134, 46, 14);
		candidatesm.add(lblNewLabel_1_1_1);
		
		canname = new JTextField();
		canname.setColumns(10);
		canname.setBounds(104, 167, 124, 20);
		candidatesm.add(canname);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Name :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(21, 169, 60, 14);
		candidatesm.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Last Name :");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(21, 205, 73, 14);
		candidatesm.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email :");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(21, 240, 60, 14);
		candidatesm.add(lblNewLabel_1_4_1);
		
		JButton add_1 = new JButton("Add");
		add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				if(con!=null) {
					if(electionid!=-1) {
						if(canid.getText().equals("") || cancin.getText().equals("") || canname.getText().equals("") || canlastn.getText().equals("") || canemail.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please Fill Complete Information ");
						}
						else {
							int candid=Integer.parseInt(canid.getText());
							int candcin=Integer.parseInt(cancin.getText());
							String candname=canname.getText();
							String candlastn=canlastn.getText();
							String candemail=canemail.getText();
							try {
								PreparedStatement statement=con.prepareStatement("INSERT INTO candidates (id,cin, name,lastname, email,election_id) VALUES (?, ?, ?, ?,?,?)");
								statement.setInt(1, candid);
								statement.setInt(2, candcin);
								statement.setString(3, candname);
								statement.setString(4, candlastn);
								statement.setString(5, candemail);
								statement.setInt(6,electionid);
								int rowsInserted = statement.executeUpdate();
							    if (rowsInserted > 0) {
							        JOptionPane.showMessageDialog(null, "A new candidate was inserted successfully.");
							    }
							    showelections();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							canid.setText("");
							cancin.setText("");
							canname.setText("");
							canlastn.setText("");
							canemail.setText("");
							}
					}
					showcandidates(electionid);
				}
			}
		});
		add_1.setBounds(37, 288, 71, 23);
		candidatesm.add(add_1);
		
		JButton update_1 = new JButton("Update");
		update_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            electionid = (int) table.getValueAt(selectedRow, 0); // Assuming ID is in column 0

		            int candid = Integer.parseInt(canid.getText());
		            int candcin = Integer.parseInt(cancin.getText());
		            String candname=canname.getText();
		            String candlastn=canlastn.getText();
		            String candemail=canemail.getText();

		            try {
		                String sql = "UPDATE candidates SET id=?, cin=?, name=?, lastname=?, email=? WHERE id=? AND election_id=?";
		                PreparedStatement statement = con.prepareStatement(sql);

		                statement.setInt(1, candid);
		                statement.setInt(2, candcin);
		                statement.setString(3, candname);
		                statement.setString(4, candlastn);
		                statement.setString(5, candemail);
		                statement.setInt(6, candid);
		                statement.setInt(7, electionid);

		                int rowsUpdated = statement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL");
		                }

		                statement.close();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		            showcandidates(electionid);
		        }
		    }	
		});
		update_1.setBounds(158, 288, 71, 23);
		candidatesm.add(update_1);
		
		JButton delete_1 = new JButton("Delete");
		delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				if(con!=null) {
					 int row = table.getSelectedRow();
				        if (row == -1) {
				            JOptionPane.showMessageDialog(null, "Select a candidate to delete!");
				        } else {
				            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirmation",
				                    JOptionPane.YES_NO_OPTION);
				            if (confirm == 0) {
				                int candid = (int) tablem.getValueAt(row, 0);
				                try {
				                    PreparedStatement pst = con.prepareStatement("delete from candidates where id=?");
				                    pst.setInt(1, candid);
				                    pst.executeUpdate();
				                    JOptionPane.showMessageDialog(null, "candidate deleted successfully!");
				                    showelections();

				                } catch (SQLException e5) {
				                    e5.printStackTrace();
				                }
				                canid.setText("");
								cancin.setText("");
								canname.setText("");
								canlastn.setText("");
								canemail.setText("");
				            }
				        }
				}
				showcandidates(electionid);
			}
		});
		delete_1.setBounds(37, 330, 71, 23);
		candidatesm.add(delete_1);
		
		JButton clear_1 = new JButton("Clear");
		clear_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canid.setText("");
				cancin.setText("");
				canname.setText("");
				canlastn.setText("");
				canemail.setText("");
			}
		});
		clear_1.setBounds(158, 330, 71, 23);
		candidatesm.add(clear_1);
		
		canlastn = new JTextField();
		canlastn.setColumns(10);
		canlastn.setBounds(104, 203, 124, 20);
		candidatesm.add(canlastn);
		
		canemail = new JTextField();
		canemail.setColumns(10);
		canemail.setBounds(104, 238, 124, 20);
		candidatesm.add(canemail);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(281, 79, 384, 197);
		candidatesm.add(scrollPane_1);
		
		tablem = new JTable();
		scrollPane_1.setViewportView(tablem);
		String[] co = {"ID", "CIN", "Name", "LastName", "Email"};
		tablem.setModel(new NonEditableTableModel(null,co));
		scrollPane_1.setViewportView(tablem);
		
		JPanel profileo = new JPanel();
		profileo.setLayout(null);
		panels.add(profileo, "name_10408639667900");
		
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
		
		adminname = new JTextField();
		adminname.setText(namea);
		adminname.setColumns(10);
		adminname.setBounds(201, 79, 276, 20);
		profileo.add(adminname);
		
		adminlastn = new JTextField();
		adminlastn.setText(lastnamea);
		adminlastn.setColumns(10);
		adminlastn.setBounds(201, 139, 276, 20);
		profileo.add(adminlastn);
		
		adminemail = new JTextField();
		adminemail.setText(emaila);
		adminemail.setColumns(10);
		adminemail.setBounds(201, 204, 276, 20);
		profileo.add(adminemail);
		
		adminpass = new JTextField();
		adminpass.setText(passla);
		adminpass.setColumns(10);
		adminpass.setBounds(201, 265, 276, 20);
		profileo.add(adminpass);
		
		JButton update_2 = new JButton("UPDATE");
		update_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
			    if (con != null) {
			        if (adminname.getText().equals(namea) && adminemail.getText().equals(emaila) && adminlastn.getText().equals(lastnamea) && adminpass.getText().equals(passla)) {
			            JOptionPane.showMessageDialog(null, "No changes applied");
			        } else {
			            String name = adminname.getText();
			            String lastname = adminlastn.getText();
			            String pass = adminpass.getText();
			            String email = adminemail.getText();
			            PreparedStatement pst = null;
			            try {
			                pst = con.prepareStatement("UPDATE users SET name = ?, lastname = ?, pass = ?, email = ? WHERE cin = ?");
			                pst.setString(1, name);
			                pst.setString(2, lastname);
			                pst.setString(3, pass);
			                pst.setString(4, email);
			                pst.setInt(5, cina);
			                pst.executeUpdate();
			                JOptionPane.showMessageDialog(null, "Update Done");
			            } catch (SQLException e1) {
			                e1.printStackTrace();
			            } finally {
			                // Ensure PreparedStatement and Connection are closed
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
		update_2.setBounds(527, 326, 89, 23);
		profileo.add(update_2);
		
		JLabel lblNewLabel_2 = new JLabel("Your Personal informations ");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(61, 30, 253, 23);
		profileo.add(lblNewLabel_2);
		
		
		
		
		
		elections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				electionsm.setVisible(true);
				profileo.setVisible(false);
				logoutm.setVisible(false);
				candidatesm.setVisible(false);
				votersm.setVisible(false);
			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				electionsm.setVisible(false);
				profileo.setVisible(false);
				logoutm.setVisible(true);
				candidatesm.setVisible(false);
				votersm.setVisible(false);
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
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				electionsm.setVisible(false);
				profileo.setVisible(true);
				logoutm.setVisible(false);
				candidatesm.setVisible(false);
				votersm.setVisible(false);
				
			}
		});
		
		
		
		TableModel model=table.getModel();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				eidf.setText(model.getValueAt(i, 0).toString());
				enamef.setText(model.getValueAt(i, 1).toString());
				elocf.setText(model.getValueAt(i, 2).toString());
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date startDate = sdf.parse(table.getValueAt(i, 3).toString());
                    java.util.Date endDate = sdf.parse(table.getValueAt(i, 4).toString());
                    LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    datePicker.setDate(startLocalDate);
                    dateendf.setDate(endLocalDate);
	                datePicker.setDate(startLocalDate); // Set LocalDate in DatePicker
	                dateendf.setDate(endLocalDate); // Set LocalDate in DatePicker
	            } catch (ParseException ex) {
	                ex.printStackTrace();
	            }
				
			}
		});
		TableModel modelm=tablem.getModel();
		tablem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tablem.getSelectedRow();
				canid.setText(modelm.getValueAt(i, 0).toString());
				cancin.setText(modelm.getValueAt(i, 1).toString());
				canname.setText(modelm.getValueAt(i, 2).toString());
				canlastn.setText(modelm.getValueAt(i, 3).toString());
				canemail.setText(modelm.getValueAt(i, 4).toString());
			}
		});
	}
	public void showelections() {
		Connect();
		if(con!=null) {
			try{
				PreparedStatement ps=con.prepareStatement("select * from elections");
				ResultSet res=ps.executeQuery();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
			    model.setRowCount(0);
			    while(res.next()) {
			    	Object[] rows = new Object[5]; // Initialize the array inside the loop

			        rows[0] = res.getInt("id");
			        rows[1] = res.getString("name");
			        rows[2] = res.getString("location");
			        rows[3] = res.getDate("start_date");
			        rows[4] = res.getDate("end_date");
			        model.addRow(rows);
			    }
			    res.close();
			    ps.close();
			    con.close();
			}
			catch(SQLException e) {
				
			}
		}
		else {
			System.out.println("CONNECTION TO DATABASE NOT ESTABLISHED ");
		}
	}
	public void showcandidates(int id) {
		Connect();
		if(con!=null) {
			try{
				PreparedStatement ps1=con.prepareStatement("select * from candidates where election_id = ?");
				ps1.setInt(1, id);
				ResultSet res1=ps1.executeQuery();
				DefaultTableModel modelm = (DefaultTableModel) tablem.getModel();
			    modelm.setRowCount(0);
			    while(res1.next()) {
			    	Object[] rows = new Object[5]; // Initialize the array inside the loop

			        rows[0] = res1.getInt("id");
			        rows[1] = res1.getString("cin");
			        rows[2] = res1.getString("name");
			        rows[3] = res1.getString("lastname");
			        rows[4] = res1.getString("email");
			        modelm.addRow(rows);
			    }
			    res1.close();
			    ps1.close();
			    con.close();
			}
			catch(SQLException e) {
				
			}
		}
		else {
			System.out.println("CONNECTION TO DATABASE NOT ESTABLISHED ");
		}
		
	}
}
