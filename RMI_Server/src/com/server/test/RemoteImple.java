package com.server.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.RemoteInterface;

/* ���� ��ü(Remote Object)
 *  - �����������̽��� ��ӹ޴´�.
 *  - java.rmi.server.UnicastRemoteObject Ŭ������ ��ӹ޴´�.
 *  - �⺻�����ڸ� �����, RemoteException ����
 *  - �����������̽��� ����� ���ݸ޼ҵ带 �����Ѵ�.
 * 
 */
public class RemoteImple extends UnicastRemoteObject implements RemoteInterface {

	protected RemoteImple() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(String str) throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello!!" + str;
	}

}
