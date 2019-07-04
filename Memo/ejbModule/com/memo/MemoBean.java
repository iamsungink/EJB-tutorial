package com.memo;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 세션빈 : Stateless Bean
public class MemoBean implements SessionBean{
	
	private Context ctx;
	private DataSource ds;
	private SessionContext sc;
	

	public MemoBean() {
		System.out.println("!!! MemoBean 생성 !!!");
	}//기본 생성자
	
	public void ejbCreate() {
		try {
			System.out.println("ejbCreate()메소드 호출...");
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("KTPPool");
			System.out.println("!!! 커넥션 확보 !!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//ejbCreate
	
	//SessionBean 인터페이스가 갖고 잇는 메소드 오버라이드.

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		ctx = null;
		ds = null;
		sc = null;
	}

	@Override
	public void setSessionContext(SessionContext sc) throws EJBException, RemoteException {
		this.sc = sc;
	}
	
	/* 비지니스 로직 */
	public int insertMemo(MemoDTO dto) throws RemoteException{
		Connection con = null;
		PreparedStatement ps = null;
		
		//String sql = "insert into ksi_ejb_memo(no, writer, email, title, memo, wdate) values(KSI_MEMO_SEQ.nextval, ?, ?, ?, ? sysdate)";
		//mysql
		String sql = "insert into tbl_ejb_memo(writer, email, title, memo, wdate) values(?, ?, ?, ?, now())";
		
		try {
			con = ds.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1,  dto.getWriter());
			ps.setString(2,  dto.getEmail());
			ps.setString(3,  dto.getTitle());
			ps.setString(4,  dto.getMemo());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
			}
		}
	}//insertMemo
	
	public int deleteMemo(String no) throws RemoteException{
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete from tbl_ejb_memo where no = ?";
		
		try {
			con = ds.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1,  no);
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
			}
		}
	}//delelteMeom
	
	public ArrayList listMemo() throws RemoteException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_ejb_memo order by no desc";
		
		try {
			con = ds.getConnection();
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList dtos = new ArrayList();
			while(rs.next()) {
				String no = rs.getString(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String title = rs.getString(4);
				String memo = rs.getString(5);
				String wdate = rs.getDate(6).toString();
				
				MemoDTO dto = new MemoDTO(no, writer, email, title, memo, wdate);
				dtos.add(dto);
			}//while
			
			return dtos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
			}
		}
	}//listMemo
	
	public MemoDTO memoView(String no) throws RemoteException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemoDTO dto = null;
		
		String sql = "select * from tbl_ejb_memo where no = ?";
		
		try {
			con = ds.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String title = rs.getString(4);
				String memo = rs.getString(5);
				String wdate = rs.getDate(6).toString();
				
				dto = new MemoDTO(no, writer, email, title, memo, wdate);
			}//while
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
			}
		}
	}//memoView

}
