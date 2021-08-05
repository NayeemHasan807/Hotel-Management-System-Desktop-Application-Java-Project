package frames;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import repository.*;
import entity.*;

public class RmanageFrame extends JFrame implements MouseListener,ActionListener
{
	private JLabel roomNoLabel,roomAvaLabel;
	private JTextField roomNoTF,roomAvaTF;
	private JButton loadBtn,updateBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	private JTable roomTable;
	private JScrollPane roomTableSP;
	private JPanel panel;
	
	private User user;
	private Room room;
	private RoomRepo rr;	
	
	public RmanageFrame(User user)
	{
		super("HotelManagementSystem/EmployeeHome/ManageRoom");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user=user;
		rr = new RoomRepo();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		
		
		String data[][]={{"","","","",""}};
		String head[]={"RoomNumber","Availability"};
		

		roomTable = new JTable(data,head);
		roomTableSP = new JScrollPane(roomTable);
		roomTableSP.setBounds(420,50,180,230);
		roomTable.setEnabled(false);
		panel.add(roomTableSP);
		
		roomNoLabel = new JLabel("RoomNumber :");
		roomNoLabel.setBounds(170,50,100,30);
		panel.add(roomNoLabel);
		
		roomNoTF = new JTextField();
		roomNoTF.setBounds(290,50,100,30);
		panel.add(roomNoTF);
		
		roomAvaLabel = new JLabel("Availability :");
		roomAvaLabel.setBounds(170,100,100,30);
		panel.add(roomAvaLabel);
		
		roomAvaTF = new JTextField();
		roomAvaTF.setBounds(290,100,100,30);
		roomAvaTF.setEnabled(false);
		panel.add(roomAvaTF);
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(170,300,90,30);
		loadBtn.setBackground(Color.WHITE);
		loadBtn.setForeground(Color.RED);
		loadBtn.addMouseListener(this);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(282,300,90,30);
		updateBtn.setBackground(Color.WHITE);
		updateBtn.setForeground(Color.RED);
		updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(394,300,90,30);
		refreshBtn.setBackground(Color.WHITE);
		refreshBtn.setForeground(Color.RED);
		refreshBtn.addMouseListener(this);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(506,300,90,30);
		getAllBtn.setBackground(Color.WHITE);
		getAllBtn.setForeground(Color.RED);
		getAllBtn.addMouseListener(this);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(170,350,90,30);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(506,350,90,30);
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
		else if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.RED);
		    updateBtn.setForeground(Color.WHITE);

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
		else if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.WHITE);
		    updateBtn.setForeground(Color.RED);

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
			if(roomNoTF.getText().equals("") || roomNoTF.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"Please input a room number");
			}
			else
			{
				Room r = rr.searchRoom(Integer.parseInt(roomNoTF.getText()));
				if(r!= null)
				{
					roomNoTF.setText(Integer.toString(r.getRoomNumber()));
					roomAvaTF.setText(Integer.toString(r.getAvailability()));
					
					roomNoTF.setEnabled(false);
					roomAvaTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid Room Number");
				}

			}
		}
		else if(command.equals(updateBtn.getText()))
		{
			if(roomAvaTF.getText().equals("") || roomAvaTF.getText().equals(null))
			{
				JOptionPane.showMessageDialog(this,"Please input Availability");
			}
			else
			{
				if(Integer.parseInt((roomAvaTF.getText()))<3 && Integer.parseInt((roomAvaTF.getText()))>=0 )
				{
					Room r = new Room();
				
			    	r.setRoomNumber(Integer.parseInt(roomNoTF.getText()));
					r.setAvailability(Integer.parseInt(roomAvaTF.getText()));
				
					rr.updateRoom(r);
				
					JOptionPane.showMessageDialog(this,"Updated");
				
					roomNoTF.setText("");
					roomAvaTF.setText("");
				
					loadBtn.setEnabled(true);
					updateBtn.setEnabled(false);
					refreshBtn.setEnabled(false);
			
					roomNoTF.setEnabled(true);
					roomAvaTF.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Not a valid input.Use 0 for Not Available 1 for Available 2 for Under Repairing");
				}
			}
			
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = rr.getAllRoom();
			String head[] = {"RoomNumber","Availability"};
			
			panel.remove(roomTableSP);
			
			roomTable = new JTable(data,head);
			roomTable.setEnabled(false);
			roomTableSP = new JScrollPane(roomTable);
			roomTableSP.setBounds(420,50,180,230);
			panel.add(roomTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			roomNoTF.setText("");
			roomAvaTF.setText("");
			
			roomNoTF.setEnabled(true);
			roomAvaTF.setEnabled(false);
			loadBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
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