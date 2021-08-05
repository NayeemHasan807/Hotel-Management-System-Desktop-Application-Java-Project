package frames;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import repository.*;
import entity.*;


public class EmanageFrame extends JFrame implements MouseListener,ActionListener
{
	private JLabel empIdLabel,empNameLabel,empJobCatLabel,empSalaryLabel,empPhoneLabel;
	private JTextField empIdTF,empNameTF,empJobCatTF,empSalaryTF,empPhoneTF;
	private JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	private JTable empTable;
	private JScrollPane empTableSP;
	private JPanel panel;
	
	private User user;
	private EmployeeRepo er;
	private UserRepo ur;
	
	
	public EmanageFrame(User user)
	{
		super("HotelManagementSystem/EmployeeHome/ManageEmployee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new EmployeeRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		
		
		String data[][]={{"","","","",""}};
		String head[]={"EmployeeId", "Name", "JobCatagory", "Salary","Phone"};
		

		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(350, 50, 400, 230);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		empIdLabel = new JLabel("EmployeeID :");
		empIdLabel.setBounds(100,50,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,50,100,30);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,100,100,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(220,100,100,30);
		panel.add(empNameTF);
		
		empJobCatLabel = new JLabel("JobCatagory: ");
		empJobCatLabel.setBounds(100,150,100,30);
		panel.add(empJobCatLabel);
		
		empJobCatTF = new JTextField();
		empJobCatTF.setBounds(220,150,100,30);
		panel.add(empJobCatTF);
		
		empSalaryLabel = new JLabel("Salary: ");
		empSalaryLabel.setBounds(100,200,100,30);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(220,200,100,30);
		panel.add(empSalaryTF);

		empPhoneLabel = new JLabel("PhoneNo: ");
		empPhoneLabel.setBounds(100,250,100,30);
		panel.add(empPhoneLabel);
		
		empPhoneTF = new JTextField();
		empPhoneTF.setBounds(220,250,100,30);
		panel.add(empPhoneTF);


		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,90,30);
		loadBtn.setBackground(Color.WHITE);
		loadBtn.setForeground(Color.RED);
		loadBtn.addMouseListener(this);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(212,300,90,30);
		insertBtn.setBackground(Color.WHITE);
		insertBtn.setForeground(Color.RED);
		insertBtn.addMouseListener(this);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(324,300,90,30);
		updateBtn.setBackground(Color.WHITE);
		updateBtn.setForeground(Color.RED);
		updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(436,300,90,30);
		deleteBtn.setBackground(Color.WHITE);
		deleteBtn.setForeground(Color.RED);
		deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(548,300,90,30);
		refreshBtn.setBackground(Color.WHITE);
		refreshBtn.setForeground(Color.RED);
		refreshBtn.addMouseListener(this);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(660,300,90,30);
		getAllBtn.setBackground(Color.WHITE);
		getAllBtn.setForeground(Color.RED);
		getAllBtn.addMouseListener(this);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(100,350,90,30);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(660,350,90,30);
		logoutBtn.setBackground(Color.WHITE);
		logoutBtn.setForeground(Color.RED);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}

	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==loadBtn)
		{
			loadBtn.setBackground(Color.RED);
		    loadBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==insertBtn)
		{
			insertBtn.setBackground(Color.RED);
		    insertBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.RED);
		    updateBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==deleteBtn)
		{
			deleteBtn.setBackground(Color.RED);
		    deleteBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==refreshBtn)
		{
			refreshBtn.setBackground(Color.RED);
		    refreshBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==getAllBtn)
		{
			getAllBtn.setBackground(Color.RED);
		    getAllBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.RED);
		    backBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==logoutBtn)
		{
			logoutBtn.setBackground(Color.RED);
		    logoutBtn.setForeground(Color.WHITE);

		}
		else
		{

		}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==loadBtn)
		{
			loadBtn.setBackground(Color.WHITE);
		    loadBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==insertBtn)
		{
			insertBtn.setBackground(Color.WHITE);
		    insertBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.WHITE);
		    updateBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==deleteBtn)
		{
			deleteBtn.setBackground(Color.WHITE);
		    deleteBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==refreshBtn)
		{
			refreshBtn.setBackground(Color.WHITE);
		    refreshBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==getAllBtn)
		{
			getAllBtn.setBackground(Color.WHITE);
		    getAllBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==backBtn)
		{
			backBtn.setBackground(Color.WHITE);
		    backBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==logoutBtn)
		{
			logoutBtn.setBackground(Color.WHITE);
		    logoutBtn.setForeground(Color.RED);

		}
		else
		{

		}
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

	public void actionPerformed(ActionEvent ae)
	{
        String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Employee e = er.searchEmployee(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getEName());
					empJobCatTF.setText(e.getEJobCategory());
					empSalaryTF.setText(Integer.toString(e.getESalary()));
					empPhoneTF.setText(Integer.toString(e.getEPhoneNo()));
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empJobCatTF.setEnabled(true);
					empSalaryTF.setEnabled(true);
					empPhoneTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Employee e = new Employee();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			if(empIdTF.getText().equals("") || empIdTF.getText().equals(null) || empNameTF.getText().equals("") || empNameTF.getText().equals(null) || empJobCatTF.getText().equals("") || empJobCatTF.getText().equals(null) || empSalaryTF.getText().equals("") || empSalaryTF.getText().equals(null) || empPhoneTF.getText().equals("") || empPhoneTF.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"Give full details to insert a new employee");			
			}
			else
			{
				e.setEId(empIdTF.getText());
				e.setEName(empNameTF.getText());
				e.seteJobCategory(empJobCatTF.getText());
				e.setESalary(Integer.parseInt(empSalaryTF.getText()));
				e.setEPhoneNo(Integer.parseInt(empPhoneTF.getText()));
				
				u.setUId(empIdTF.getText());
				u.setUPassword(x+"");
				
				if(((empJobCatTF.getText()).equals("Manager")) || ((empJobCatTF.getText()).equals("manager")))
				{
					u.setUStatus(1);
				}
				else if(((empJobCatTF.getText()).equals("Receptionist")) || ((empJobCatTF.getText()).equals("receptionist")))
				{
					u.setUStatus(2);
				}
				else 
				{
					u.setUStatus(3);
				}
				
				er.insertInDB(e);
				ur.insertUser(u);
				
				JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+" and Password: "+x);
			
				empIdTF.setText("");
				empNameTF.setText("");
				empJobCatTF.setText("");
				empSalaryTF.setText("");
				empPhoneTF.setText("");
				
				loadBtn.setEnabled(true);
				insertBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);

			}
		}	
		else if(command.equals(refreshBtn.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empJobCatTF.setText("");
			empSalaryTF.setText("");
			empPhoneTF.setText("");
			
			empIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Employee e = new Employee();
			
			e.setEId(empIdTF.getText());
			e.setEName(empNameTF.getText());
			e.seteJobCategory(empJobCatTF.getText());
			e.setESalary(Integer.parseInt(empSalaryTF.getText()));
			e.setEPhoneNo(Integer.parseInt(empPhoneTF.getText()));
			
			er.updateInDB(e);
			
			if(((empJobCatTF.getText()).equals("Manager")) || ((empJobCatTF.getText()).equals("manager")))
			{
				ur.updatestatus(empIdTF.getText(),1);
			}
			else if(((empJobCatTF.getText()).equals("Receptionist")) || ((empJobCatTF.getText()).equals("receptionist")))
			{
				ur.updatestatus(empIdTF.getText(),2);
			}
			else 
			{
				ur.updatestatus(empIdTF.getText(),3);
			}
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empJobCatTF.setText("");
			empSalaryTF.setText("");
			empPhoneTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empJobCatTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
			empPhoneTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empJobCatTF.setText("");
			empSalaryTF.setText("");
			empPhoneTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empJobCatTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
			empPhoneTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllEmployee();
			String head[] = {"EmployeeId", "Name", "JobCatagory", "Salary","Phone"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(350, 50, 400, 230);
			panel.add(empTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			EHomeFrame ehf = new EHomeFrame(user);
			ehf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else
		{

		}
		
	}
	
}