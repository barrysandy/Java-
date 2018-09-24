package com.xgb.org.chapter10;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//�Զ�����������������ClassLoader��ֱ�ӻ��߼������
public class MyClassLoader extends ClassLoader{
	
	//����Ĭ�ϵ�class���·��
	private final static Path DEFAULT_CLASS_DIR = Paths.get("G:", "classloader1");
	
	private final Path classDir;
	
	//ʹ��Ĭ�ϵ�Class·��
	public MyClassLoader() {
		super();
		this.classDir = DEFAULT_CLASS_DIR;
	}
	
	//�������ƶ���class·��
	public MyClassLoader(String classDir) {
		super();
		this.classDir = Paths.get(classDir);
	}
	
	//ָ��class·��ʱ��ָ�����������
	public MyClassLoader(String classDir,ClassLoader parent) {
		super();
		this.classDir = Paths.get(classDir);
	}
	
	//��д�����findClass�������˲���������Ҫ
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//��ȡclass����������
		byte[] classBytes = this.readClassBytes(name);
		//�������Ϊnull������û�ж�ȡ���κ���Ϣ�����׳��쳣
		if(null == classBytes || classBytes.length == 0) {
			throw new ClassNotFoundException("Can not load the class " + name);
		}
		//����defineClass��������class
		return this.defineClass(name,classBytes,0,classBytes.length);
	}
	
	//��class�ļ������ڴ�
	private byte[] readClassBytes(String name) throws ClassNotFoundException {
		//�������ָ���תΪ�ļ��ָ���
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
		if(!classFullPath.toFile().exists()) {
			throw new ClassNotFoundException("The Class " + name + " not found.");
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Files.copy(classFullPath, baos);
			return baos.toByteArray();
		} catch (Exception e) {
			throw new ClassNotFoundException("Load The Class " + name + " occur error.",e);
		}
		
	}
	
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		return loadClass(name , false);
	}
	
	
	//�ƻ�����ί�л���   ͨ����дloadClass��ʵ��
	protected Class<?> loadClass(String name ,boolean resolve) throws ClassNotFoundException{
		//1
		synchronized (getClassLoadingLock(name)) {
			//2
			Class<?> klass = findLoadedClass(name);
			//3
			if(klass == null) {
				//4
				if(name.startsWith("java.") || name.startsWith("javax")) {
					try {
						klass = getSystemClassLoader().loadClass(name);
					} catch (Exception e) {
						//ignore
					}
				}else {
					//5
					try {
						klass = this.findClass(name);
					} catch (Exception e) {
						//ignore
					}
					//6
					if(klass == null) {
						if(getParent() != null) {
							klass = getSystemClassLoader().loadClass(name);
						}
					}
				}
			}
			
			//7
			if(null == klass) {
				throw new ClassNotFoundException("The Class " + name + "not found.");
			}
			if(resolve) {
				resolveClass(klass);
			}
			
			return klass;
		}
	}
	
	
	@Override
	public String toString() {
		return "My ClassLoader";
	}
	
}
