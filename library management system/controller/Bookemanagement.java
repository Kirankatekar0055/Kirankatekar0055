package controller;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Book;
import Model.BookDao;

public class Bookemanagement extends JFrame implements ActionListener

{
	Container cp;
	JLabel lblid,lblName,lblAuther,lblPrice;
	JTextField txtid,txtName,txtAuther,txtPrice;
	JButton btninsert,btndelete,btnupdate,btnshowall,btnclear,btnok;
	
	
	public Bookemanagement(String Title)
	{
		//setTitle="Book Management System";
		super(Title);
		cp=getContentPane();
		cp.setLayout(new GridLayout(7,2));
		cp.setBackground(Color.YELLOW);
	
		
		lblid=new JLabel("Id");
		txtid=new JTextField();
		cp.add(lblid);
		cp.add(txtid);
		
		lblName=new JLabel("Name");
		txtName=new JTextField();
		cp.add(lblName);
		cp.add(txtName);
		
		lblAuther=new JLabel("Auther");
		txtAuther=new JTextField();
		cp.add(lblAuther);
		cp.add(txtAuther);
		
		lblPrice=new JLabel("Price");
		txtPrice=new JTextField();
		cp.add(lblPrice);
		cp.add(txtPrice);
		
		btninsert=new JButton("Insert");
		cp.add(btninsert);
		btninsert.addActionListener(this);
		
		btnupdate=new JButton("Update");
		cp.add(btnupdate);
		btnupdate.addActionListener(this);
		
		btndelete=new JButton("Delete");
		cp.add(btndelete);
		btndelete.addActionListener(this);
		
		btnshowall=new JButton("ShowAll");
		cp.add(btnshowall);
		btnshowall.addActionListener(this);
		
		btnclear=new JButton("Clear");
	    cp.add(btnclear);
	    btnclear.addActionListener(this);
	    
		btnok=new JButton("Ok");
		cp.add(btnok);
		
		setSize(400,400);
		setVisible(true);
		
}
	
	

	public static void main(String[] args) 
	{
		new Bookemanagement("Book Management System");

	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		try {
		BookDao dao=new BookDao();
		if(e.getSource()==btninsert)
		{
			int i=Integer.parseInt(txtid.getText());
			String a=txtName.getText();
			double p=Double.parseDouble(txtPrice.getText());
			String b=txtAuther.getText();
			Book obj=new Book(i,a,b,p);
			boolean res=dao.addBook(obj);
			if(res)
			
				JOptionPane.showMessageDialog(this,"Insertion Succesfull..");
			
		}
		else if	(e.getSource()==btnupdate)
		{
			int i=Integer.parseInt(txtid.getText());
			double a=Double.parseDouble(txtPrice.getText());
			Book b=new Book();
			b.setId(i);
			b.setPrice(a);
			boolean res=dao.updateBook(b);
            if(res)
				
				JOptionPane.showMessageDialog(this,"Update Succesfull..");
		}
		else if(e.getSource()==btndelete)
		{
			int i=Integer.parseInt(txtid.getText());
			boolean res=dao.deleteBook(i);
			if(res) 
			{
				
				JOptionPane.showMessageDialog(this,"Delete Succesfull..");
				
		    }
			else
			{
				JOptionPane.showMessageDialog(this,"Record Not Found..");
			}
				
			}
		
		else if(e.getSource()==btnclear)
		{
			txtid.setText("");
			txtName.setText("");
			txtAuther.setText("");
			txtPrice.setText("");
		}
		else if(e.getSource()==btnshowall)
		{
			//Create Column
			String cols[]= {"BID","BNAME","PRICE","AUTHER"};
			//Create Model
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(cols);
			//create JTable
			JTable tb=new JTable(model);
			
			JScrollPane jp=new JScrollPane(tb);
			
			//Call Show All
			ResultSet rs=dao.showall();
			//add data
			while(rs.next())
			{
				int i=rs.getInt(1);
				String n=rs.getString(2);
				double p=rs.getDouble(3);
				String a=rs.getString(4);
				
				model.addRow(new Object[] {i,n,p,a});
				
			}
			
			JFrame f=new JFrame("Record Area");
			f.add(jp);
			f.setSize(400,400);
			
			f.setVisible(true);
		    }
		    }
	
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }	
			
			
		}
		
		
	}


