package com.yedam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.domain.Employee;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void close() {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 단건조회.
	public Employee getEmp(int empId) {
		// 사원번호의 조회결과로 값이 있으면 Employee 반환.
		// 값이 없으면 null이 반환.
		Employee emp = null;
		try {
			conn = DAO.getConnect();
			
			String sql = "SELECT * FROM employees WHERE employee_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(empId);
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHiredate(rs.getString("hire_date"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return emp;
	}
	
	// 사원정보삭제(매개값은 int).
	public boolean deleteEmployee(int empId) {
		try {
			conn = DAO.getConnect();
			
			String sql = "DELETE FROM employees\r\n"
					+ "WHERE employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();
			
			System.out.println("처리된 건수: " + r);
			if (r > 0) 
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	// 사원등록.
	public boolean insertEmployee(Employee emp) {
		conn = DAO.getConnect();
		
		String sql = "INSERT INTO employees (employee_id, last_name, email, hire_date, job_id, first_name)\r\n"
				+ "VALUES(employees_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHiredate());
			psmt.setString(4, emp.getJobId());
			psmt.setString(5, emp.getFirstName());
			
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수: " + r);
			if (r > 0) 
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	//사원목록
	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employees order by 1 desc";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHiredate(rs.getString("hire_date"));
				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 로그인(사원번호, 이메일
	public Employee loginCheck(Employee emp) {
		conn = DAO.getConnect();
		
		try {
			String sql = "SELECT * FROM employees "
					+ "WHERE employee_id=? and email=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getEmail());
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				Employee result = new Employee();
				result.setEmployeeId(rs.getInt("employee_id"));
				result.setFirstName(rs.getString("first_name"));
				result.setLastName(rs.getString("last_name"));
				result.setEmail(rs.getString("email"));
				result.setJobId(rs.getString("job_id"));
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
		
	}
	
	
	// 수정처리.(정보수정)
	public boolean updateMember(Employee emp) {
		conn = DAO.getConnect();
		
		String sql = "UPDATE employees SET  first_name = ?\r\n"
				+ "                    , last_name = ?\r\n"
				+ "                    , email = ?\r\n"
				+ "                WHERE employee_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getEmployeeId());
			
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수: " + r);
			if (r > 0) 
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	
	
}
