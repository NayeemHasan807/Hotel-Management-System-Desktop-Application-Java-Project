package frames;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import repository.*;
import entity.*;


public class ChangePassFrame extends JFrame implements MouseListener,ActionListener
{
	private JLabel userIdLabel,prePassLabel,newPassLabel;
	private JTextField userIdTF,prePassTF,newPassTF;
	private JButton updateBtn,refreshBtn,backBtn,logoutBtn;
	private JPanel panel;
	
	private User user;
	private UserRepo ur;	
	
	public ChangePassFrame(User user)
	{
		super("HotelManagementSystem/EmployeeHome/ChangePass");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		userIdLabel = new JLabel("UserID :");
		userIdLabel.setBounds(290,70,100,30);
		panel.add(userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(410,70,100,30);
		panel.add(userIdTF);
		
		prePassLabel = new JLabel("Present Pass :");
		prePassLabel.setBounds(290,120,100,30);
		panel.add(prePassLabel);
		
		prePassTF = new JTextField();
		prePassTF.setBounds(410,120,100,30);
		panel.add(prePassTF);


		newPassLabel = new JLabel("New Pass :");
		newPassLabel.setBounds(290,170,100,30);
		panel.add(newPassLabel);
		
		newPassTF = new JTextField();
		newPassTF.setBounds(410,170,100,30);
		panel.add(newPassTF);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(290,220,100,30);
		updateBtn.setBackground(Color.WHITE);
		updateBtn.setForeground(Color.RED);
		updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(412,220,100,30);
		refreshBtn.setBackground(Color.WHITE);
		refreshBtn.setForeground(Color.RED);
		refreshBtn.addMouseListener(this);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(290,270,100,30);
		backBtn.setBackground(Color.WHITE);
		backBtn.setForeground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(412,270,100,30);
		logoutBtn.setBackground(Color.WHITE);
		logoutBtn.setForeground(Color.RED);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}

	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.RED);
		    updateBtn.setForeground(Color.WHITE);

		}
		else if(me.getSource()==refreshBtn)
		{
			refreshBtn.setBackground(Color.RED);
		    refreshBtn.setForeground(Color.WHITE);

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

		if(me.getSource()==updateBtn)
		{
			updateBtn.setBackground(Color.WHITE);
		    updateBtn.setForeground(Color.RED);

		}
		else if(me.getSource()==refreshBtn)
		{
			refreshBtn.setBackground(Color.WHITE);
		    refreshBtn.setForeground(Color.RED);

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
		
		if(command.equals(refreshBtn.getText()))
		{
			userIdTF.setText("");
			prePassTF.setText("");
			newPassTF.setText("");
		}
		else if(command.equals(updateBtn.getText()))
		{

			User u1 = ur.getUser(userIdTF.getText(),prePassTF.getText());
			
			if(u1 !=null)
			{
				if(newPassTF.getText().equals("") || newPassTF.getText().equals(null))
				{
					JOptionPane.showMessageDialog(this,"Please enter new Password first to update");
				}
				else
				{
					ur.updateUser(u1,newPassTF.getText());
			
					JOptionPane.showMessageDialog(this,"Updated");
				
					userIdTF.setText("");
					prePassTF.setText("");
					newPassTF.setText("");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Invaild Id or Password");
			}
			
			

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
		else{}
	}
}