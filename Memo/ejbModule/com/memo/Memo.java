package com.memo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

//�����������̽�
public interface Memo extends EJBObject{
	
	//�����Ͻ� �޼ҵ� ����
	
	public int insertMemo(MemoDTO dto) throws RemoteException;
	
	public int deleteMemo(String no) throws RemoteException;
	
	public ArrayList listMemo() throws RemoteException;
	
	public MemoDTO memoView(String no) throws RemoteException;

}
