import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class slip15_2 extends JFrame{
	private JLabel lblID,lblName,lblAddr,lblYear;
	private JTextField txtID,txtName,txtAddr,txtYear;
	private JButton btnSave,btnClose;
	private JPanel panCenter,panSouth;

	private Connection con;
	private PreparedStatement ps;

	public slip15_2(){
		lblID = new JLabel("Roll No:");
		lblName = new JLabel("Name:");
		lblAddr = new JLabel("Per:");
		lblYear = new JLabel("Gender:");

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();

		panCenter = new JPanel();
		panCenter.setLayout(new GridLayout(4,2));
		panCenter.add(lblID);
		panCenter.add(txtID);
		panCenter.add(lblName);
		panCenter.add(txtName);
		panCenter.add(lblAddr);
		panCenter.add(txtAddr);
		panCenter.add(lblYear);
		panCenter.add(txtYear);

		btnSave = new JButton("Save");
		btnClose = new JButton("Close");

		panSouth = new JPanel();
		panSouth.add(btnSave);
		panSouth.add(btnClose);

		setTitle("College Information");
		setSize(400,200);
		setLocation(100,100);
		add(panCenter,"Center");
		add(panSouth,"South");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
			Class.forName("oracle.jdbc.OracleDriver");

		con = DriverManager.getConnection(oracle:thin:tybca/bca@localhost:1521:XE");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			dispose();
		}

		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					int rno = Integer.parseInt(t1.getText());
					String name = t2.getText();
					float per =Float.parseFloat(t3.getText());
					String gender = t4.getText());

					ps = con.prepareStatement("insert into college values(?,?,?,?)");
		
					ps.setInt(1,cid);
					ps.setString(2,cname);
					ps.setFloat(3,per);
					ps.setString(4,gender);

					ps.executeUpdate();

					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");

					txtID.requestFocus();
				}
				catch(Exception e){	
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});				

		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
			}
		});
	}

	public static void main(String args[]){
		new slip15_2();
	}
}