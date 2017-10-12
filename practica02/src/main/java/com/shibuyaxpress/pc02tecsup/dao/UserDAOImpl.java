package com.shibuyaxpress.pc02tecsup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shibuyaxpress.pc02tecsup.bean.User;
import com.shibuyaxpress.pc02tecsup.db.ConnectionDB;

public class UserDAOImpl implements UserDAO{

	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		System.out.println("getUsers()");
		
		ResultSet rs=null;
		PreparedStatement pst=null;
		Connection con=ConnectionDB.getConnection();
		String stm="Select id, username, password, type from user order by id";
		ArrayList<User> records=new ArrayList<User>();
		try {
			pst=con.prepareStatement(stm);
			pst.execute();
			rs=pst.getResultSet();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setType(rs.getString(4));
				records.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return records;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("getUser()"+id);
		ResultSet rs=null;
		PreparedStatement pst=null;
		Connection con=ConnectionDB.getConnection();
		String stm="Select id, username, password, type from user where id=?";
		User user=new User();
		try {
			pst=con.prepareStatement(stm);
			pst.setInt(1, id);
			pst.execute();
			rs=pst.getResultSet();
			if(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setType(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public int create(String pUsername, String pPassword, String pType) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		int idGenerator = -1;
		
		String stm = "SELECT MAX(id) FROM user";
		
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			if (rs.next())  idGenerator = rs.getInt(1)+1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String stm2 = "INSERT INTO user (username,password,type)  VALUES (?,?,?)";
		try {
			pst = con.prepareStatement(stm2);
			pst.setString(1, pUsername);
			pst.setString(2, pPassword);
			pst.setString(3, pType);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return idGenerator;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "DELETE FROM user WHERE id =? ";
		try {
			pst = con.prepareStatement(stm);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(int id, String pUsername, String pPassword, String pType) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "UPDATE user SET username=?, password = ?, type = ? WHERE ID = ?";
		try {
			pst = con.prepareStatement(stm);
			pst.setString(1, pUsername);
			pst.setString(2, pPassword);
			pst.setString(3, pType);
			pst.setInt(4,id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
