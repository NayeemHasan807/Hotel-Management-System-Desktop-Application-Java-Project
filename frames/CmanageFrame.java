package frames;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import repository.*;
import entity.*;


public class CmanageFrame extends JFrame implements MouseListener,ActionListener
{
	private JLabel cusIdLabel,cusNameLabel,cusRoomNumber,cusCheckInTime,cusCheckOutTime;
	private JTextField cusIdTF,cusNameTF,cRoomNoTF,cCheckInTF,cCheckOutTF;
	private JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	private JTable cusTable;
	private JScrollPane cusTableSP;
	private JPanel panel;
	
	private User user;
	private CustomerRepo cr;
	private RoomRepo rr;	
	
	public CmanageFrame(User user)
	{
		super("HotelManagementSystem/EmployeeHome/ManageCustomer");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		cr = new CustomerRepo();
		rr = new RoomRepo();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		
		
		String data[][]={{"","","","",""}};
		String head[]={"CustomerId","Name","RoomNumber","CheckInTime","CheckOutTime"};
		

		cusTable = new JTable(data,head);
		cusTableSP = new JScrollPane(cusTable);
		cusTableSP.setBounds(350, 50, 400, 230);
		cusTable.setEnabled(false);
		panel.add(cusTableSP);
		
		cusIdLabel = new JLabel("CustomerID :");
		cusIdLabel.setBounds(100,50,100,30);
		panel.add(cusIdLabel);
		
		cusIdTF = new JTextField();
		cusIdTF.setBounds(220,50,100,30);
		panel.add(cusIdTF);
		
		cusNameLabel = new JLabel("Name :");
		cusNameLabel.setBounds(100,100,100,30);
		panel.add(cusNameLabel);
		
		cusNameTF = new JTextField();
		cusNameTF.setBounds(220,100,100,30);
		panel.add(cusNameTF);
		
		cusRoomNumber = new JLabel("RoomNumber : ");
		cusRoomNumber.setBounds(100,150,100,30);
		panel.add(cusRoomNumber);
		
		cRoomNoTF = new JTextField();
		cRoomNoTF.setBounds(220,150,100,30);
		panel.add(cRoomNoTF);
		
		cusCheckInTime = new JLabel("CheckInTime : ");
		cusCheckInTime.setBounds(100,200,100,30);
		panel.add(cusCheckInTime);
		
		cCheckInTF = new JTextField();
		cCheckInTF.setBounds(220,200,100,30);
		panel.add(cCheckInTF);

		cusCheckOutTime = new JLabel("CheckOutTime : ");
		cusCheckOutTime.setBounds(100,250,100,30);
		panel.add(cusCheckOutTime);
		
		cCheckOutTF = new JTextField();
		cCheckOutTF.setBounds(220,250,100,30);
		panel.add(cCheckOutTF);


		
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
			if(!cusIdTF.getText().equals("") || !cusIdTF.getText().equals(null))
			{
				Customer c = cr.searchCustomer(cusIdTF.getText());
				if(c!= null)
				{
					cusNameTF.setText(c.getCName());
					cRoomNoTF.setText(Integer.toString(c.getCRoomNumber()));
					cCheckInTF.setText(c.getCCheckIn());
					cCheckOutTF.setText(c.getCCheckOut());
					
					cusIdTF.setEnabled(false);
					cusNameTF.setEnabled(true);
					cRoomNoTF.setEnabled(true);
					cCheckInTF.setEnabled(true);
					cCheckOutTF.setEnabled(true);
					
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
			Customer c = new Customer();
			Room r = new Room();
			
			if(cusIdTF.getText().equals("") || cusIdTF.getText().equals(null) || cusNameTF.getText().equals("") || cusNameTF.getText().equals(null) || cRoomNoTF.getText().equals("") || cRoomNoTF.getText().equals(null) || cCheckInTF.getText().equals("") || cCheckInTF.getText().equals(null) || cCheckOutTF.getText().equals("") || cCheckOutTF.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"Give full details to insert a Customer");			
			}
			else
			{
				Room room1=rr.searchRoom(Integer.parseInt(cRoomNoTF.getText()));

				if(room1!=null)
				{
					if(room1.getAvailability()==1)
					{
						c.setCId(cusIdTF.getText());
						c.setCName(cusNameTF.getText());
						c.setCRoomNumber(Integer.parseInt(cRoomNoTF.getText()));
						c.setCCheckIn(cCheckInTF.getText());
						c.setCCheckOut(cCheckOutTF.getText());
				
						cr.insertInDB(c);
						rr.updateAvailability(Integer.parseInt(cRoomNoTF.getText()),0);
				
						JOptionPane.showMessageDialog(this,"Inserted, Id: " +cusIdTF.getText());
						
						cusIdTF.setText("");
						cusNameTF.setText("");
						cRoomNoTF.setText("");
						cCheckInTF.setText("");
						cCheckOutTF.setText("");
						
						loadBtn.setEnabled(true);
						insertBtn.setEnabled(true);
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(false);
					
					}
					else
					{
						JOptionPane.showMessageDialog(this,"This room is not available at this moment,select enother room");
					}
				
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid Room Number");
				}

	
			}
		}
		else if(command.equals(refreshBtn.getText()))
		{
			cusIdTF.setText("");
			cusNameTF.setText("");
			cRoomNoTF.setText("");
			cCheckInTF.setText("");
			cCheckOutTF.setText("");
			
			cusIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Customer c = new Customer();
			
			c.setCId(cusIdTF.getText());
			c.setCName(cusNameTF.getText());
			c.setCRoomNumber(Integer.parseInt(cRoomNoTF.getText()));
			c.setCCheckIn(cCheckInTF.getText());
			c.setCCheckOut(cCheckOutTF.getText());
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			cusIdTF.setText("");
			cusNameTF.setText("");
			cRoomNoTF.setText("");
			cCheckInTF.setText("");
			cCheckOutTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			cusIdTF.setEnabled(true);
			cusNameTF.setEnabled(true);
			cRoomNoTF.setEnabled(true);
			cCheckInTF.setEnabled(true);
			cCheckOutTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			cr.deleteFromDB(cusIdTF.getText());
			rr.updateAvailability(Integer.parseInt(cRoomNoTF.getText()),1);
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			cusIdTF.setText("");
			cusNameTF.setText("");
			cRoomNoTF.setText("");
			cCheckInTF.setText("");
			cCheckOutTF.setText("");
			
			cusIdTF.setEnabled(true);
			cusNameTF.setEnabled(true);
			cRoomNoTF.setEnabled(true);
			cCheckInTF.setEnabled(true);
			cCheckOutTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getAllCustomer();
			String head[] = {"CustomerId","Name","RoomNumber","CheckInTime","CheckOutTime"};
			
			panel.remove(cusTableSP);
			
			cusTable = new JTable(data,head);
			cusTable.setEnabled(false);
			cusTableSP = new JScrollPane(cusTable);
			cusTableSP.setBounds(350, 50, 400, 230);
			panel.add(cusTableSP);
			
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