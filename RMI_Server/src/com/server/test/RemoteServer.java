package com.server.test;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.interf.test.Constant;

// ����
// ���� ��ü�� ���ּ̹���(rmiregistry)�� ���
/*
 * RMI Registry : ���ݰ�ü�� �����ϰ� �����ϴ� ���ݰ�ü �����̳�(Container)
 * 
 * ���ε� : ���ݰ�ü�� ����ϴ� ����(Binding)
 * ���ݰ�ü ��Ϲ�� : ���ݰ�ü�� �ĺ��� �� �ִ� �ĺ���(Name)�� �Բ� ����ؾ� �Ѵ�.
 */

public class RemoteServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
		
		//���ݰ�ü�� ����
		RemoteImple imple = new RemoteImple();
		
		//���̹� ������ ���� ��ü�� ���
		Registry registry= LocateRegistry.createRegistry(Constant.RMI_PORT);
		
		//Naming Ŭ������ bind() �Ǵ� rebind()�޼ҵ带 �̿��ؼ� ����� �� �ִ�.
		// 1) bind() : ��ϵǾ� �ִ� �̸��� �����ϸ� AlreadyBoundException�� �߻���Ų��.
		// 2) rebind() : ������ �̸��� �ִ��� ���ܸ� �߻���Ű�� �ʰ� ����⸦ �Ѵ�.
		
		// ���̹� ������ ���������� ����� ��(RMI URL ���� : rmi://host:port/��ü�̸�)
		// Naming.rebind("rmi://localhost:1099/im,imple);
		// Naming.rebind("im",imple);
		
		registry.bind(Constant.RMI_ID, imple);
		
		System.out.println("[RemoteSever START]!!!");
	}

}
