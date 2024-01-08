package Model;

import java.awt.*;
import java.sql.*;


public class BookDao implements Dbservice
{
	String url="jdbc:mysql://localhost:3306/kiran",
	user="root",pass="root";
	
	Connection con=null;
	PreparedStatement ps=null;
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return con=DriverManager.getConnection(url,pass,user);
	}
	public BookDao() throws ClassNotFoundException, SQLException
	{
		con=getConnection();
	}
	public boolean addBook(Book obj)throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("insert into Bookm values(?,?,?,?)");
		ps.setInt(1,obj.getId());
		ps.setString(2,obj.getBname());
		ps.setDouble(3,obj.getPrice());
		ps.setString(4,obj.getAuther());
		
		int r=ps.executeUpdate();
		if(r>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean updateBook(Book obj)throws SQLException
	{
	    ps=con.prepareStatement("update Bookm set Price=? where Id=?");
	    ps.setDouble(1,obj.getPrice());
	    ps.setInt(2,obj.getId());
	    int r=ps.executeUpdate();
	    if(r>0)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	public boolean deleteBook(int obj)throws SQLException
	{
		ps=con.prepareStatement("delete from Bookm where ID=?");
	    ps.setInt(1,obj);
	    int r=ps.executeUpdate();
	    if(r>0)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	    
	    
	}
	public ResultSet showall()throws SQLException
	{
		String q="select * from Bookm"
				+ "";
		ps=con.prepareStatement(q);
		
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
}
