package gr.aueb.cf.doctorsapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.doctorsapp.model.Doctor;

import static gr.aueb.cf.doctorsapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.doctorsapp.dao.dbutil.DBUtil.closeConnection;

public class DoctorDAOImpl implements IDoctorDAO {
	
	@Override
	public void insert(Doctor doctor) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "INSERT INTO DOCTORS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  doctor.getFname());
			pst.setString(2,  doctor.getSname());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}	
	}

	@Override
	public void delete(Doctor doctor) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			//String sql = "DELETE FROM DOCTORS WHERE ID = " + doctor.getId();
			String sql = "DELETE FROM DOCTORS WHERE ID =  ?";
			
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  doctor.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public void update(Doctor oldDoctor, Doctor newDoctor) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "UPDATE DOCTORS SET FIRSTNAME = '" + newDoctor.getFname() + "', " + "LASTNAME = '" 
					+ newDoctor.getSname() + "' WHERE ID = " + oldDoctor.getId();
			
			pst = openConnection().prepareStatement(sql);
			pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}
	}

	@Override
	public List<Doctor> getDoctorsByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		List<Doctor> doctors = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM DOCTORS WHERE LASTNAME LIKE '" + lastname + "%'";
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setId(rs.getInt("ID"));
				doctor.setFname(rs.getString("FIRSTNAME"));
				doctor.setSname(rs.getString("LASTNAME"));
				
				doctors.add(doctor);
			}
			
			//if (doctors.size() > 0)  return doctors; else return null;
			return (doctors.size() > 0) ? doctors : null;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}
	}

	@Override
	public Doctor getDoctorById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Doctor doctor = null;
		
		try {
			String sql = "SELECT * FROM DOCTORS WHERE ID = " + id;
			
			pst = openConnection().prepareStatement(sql);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				doctor = new Doctor();
				doctor.setId(rs.getInt("ID"));
				doctor.setFname(rs.getString("FIRSTNAME"));
				doctor.setSname(rs.getString("LASTNAME"));
			}
		
			return doctor;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}
	}
}