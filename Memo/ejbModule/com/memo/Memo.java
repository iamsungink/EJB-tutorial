package com.memo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

//원격인터페이스
public interface Memo extends EJBObject{
	
	//비지니스 메소드 정의
	
	public int insertMemo(MemoDTO dto) throws RemoteException;
	
	public int deleteMemo(String no) throws RemoteException;
	
	public ArrayList listMemo() throws RemoteException;
	
	public MemoDTO memoView(String no) throws RemoteException;

}
