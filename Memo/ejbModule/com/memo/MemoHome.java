package com.memo;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

//Home 인터페이스
public interface MemoHome extends EJBHome {
	public Memo create() throws RemoteException, CreateException;

}
