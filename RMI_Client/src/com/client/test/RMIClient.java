package com.client.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.interf.test.Constant;
import com.interf.test.RemoteInterface;

// Ŭ���̾�Ʈ�� ���ּ̹�����(rmiRegistry) ��ϵ� ���ݸ޼ҵ带 ȣ���Ѵ�.

public class RMIClient {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		RemoteInterface remoteObj = (RemoteInterface) registry.lookup(Constant.RMI_ID);
		
		String str = remoteObj.sayHello("RMI");
		System.out.println("str >> " + str);
	}

}
