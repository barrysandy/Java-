package com.xgb.org.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PreventDuplicated {

	private final static String LOCK_PATH = "G://";
	private final static String LOCK_FILE = ".lcok";
	private final static String PREMISSIONS = "rw-------";
	
	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
			System.err.println("The program received kill SiNGAL.");
			
		}));
		
		checkRuning();
	
		for(int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.err.println("program is runing.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	

	}
	
	private static void checkRuning() throws IOException{
		Path path = getLockFile();
		if(path.toFile().exists()) {
			throw new RuntimeException("The Program already running.");
		}
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PREMISSIONS);
		Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
	}

	private static Path getLockFile() {
		
		return Paths.get(LOCK_PATH, LOCK_FILE);
	}
}
