package com.cwind.system;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * This program is mainly for illustrating the usage of System.getProperties() and System.
 * Reference: http://blog.csdn.net/russle/article/details/4972536
 * @author wchen
 *
 */

public class TestSystemProperties {
	
	public static void main(String[] args) {
		Properties props = System.getProperties();
		Set<Entry<Object, Object>> entries = props.entrySet();
		
		for(Entry<Object, Object> entry : entries){
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		/**
		 * 	Sample output:
		 * 	java.runtime.name: Java(TM) SE Runtime Environment
			sun.boot.library.path: D:\Program Files\Java\jre1.8.0_25\bin
			java.vm.version: 25.25-b02
			java.vm.vendor: Oracle Corporation
			java.vendor.url: http://java.oracle.com/
			path.separator: ;
			java.vm.name: Java HotSpot(TM) 64-Bit Server VM
			file.encoding.pkg: sun.io
			user.country: US
			user.script: 
			sun.java.launcher: SUN_STANDARD
			sun.os.patch.level: 
			java.vm.specification.name: Java Virtual Machine Specification
			user.dir: E:\SourceCodes\GitHub\BillyChen\CwindJavaLab\AdvancedJava
			java.runtime.version: 1.8.0_25-b18
			java.awt.graphicsenv: sun.awt.Win32GraphicsEnvironment
			java.endorsed.dirs: D:\Program Files\Java\jre1.8.0_25\lib\endorsed
			os.arch: amd64
			java.io.tmpdir: C:\Users\wchen\AppData\Local\Temp\
			line.separator: 
			
			java.vm.specification.vendor: Oracle Corporation
			user.variant: 
			os.name: Windows 7
			sun.jnu.encoding: GBK
			java.library.path: D:\Program Files\Java\jre1.8.0_25\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;D:\Downloads\Software\elasticsearch-1.4.4\bin;D:\Downloads\Software\curl;C:\ProgramData\Oracle\Java\javapath;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Common Files\Roxio Shared\DLLShared\;C:\Program Files (x86)\Common Files\Roxio Shared\10.0\DLLShared\;C:\Program Files\Intel\WiFi\bin\;C:\Program Files\Common Files\Intel\WirelessCommon\;D:\apache-maven-2.2.1\bin;D:\Program Files\Java\jdk1.8.0_25\bin;D:\jboss-as-7.1.1.Final\bin;C:\Program Files\MySQL\MySQL Server 5.5\bin;D:\Program Files (x86)\Subversion\bin;D:\Program Files (x86)\MySQL\MySQL Utilities\;D:\Program Files (x86)\Code Collaborator Client;C:\Program Files\TortoiseSVN\bin;D:\Program Files\TortoiseHg\;D:\Program Files\Collaborator Client;D:\nodejs\;D:\Python27\Scripts;D:\Python27;C:\Program Files (x86)\Skype\Phone\;D:\cygwin\bin;D:\Ruby193\bin;C:\Users\wchen\AppData\Roaming\npm;D:\apache-tomcat-8.0.3\lib;D:\apache-tomcat-8.0.3\bin;.
			java.specification.name: Java Platform API Specification
			java.class.version: 52.0
			sun.management.compiler: HotSpot 64-Bit Tiered Compilers
			os.version: 6.1
			user.home: C:\Users\wchen
			user.timezone: 
			java.awt.printerjob: sun.awt.windows.WPrinterJob
			file.encoding: UTF-8
			java.specification.version: 1.8
			java.class.path: E:\SourceCodes\GitHub\BillyChen\CwindJavaLab\AdvancedJava\target\test-classes;E:\SourceCodes\GitHub\BillyChen\CwindJavaLab\AdvancedJava\target\classes;C:\Users\wchen\.m2\repository\junit\junit\4.8.2\junit-4.8.2.jar
			user.name: wchen
			java.vm.specification.version: 1.8
			sun.java.command: com.cwind.system.TestSystemProperties
			java.home: D:\Program Files\Java\jre1.8.0_25
			sun.arch.data.model: 64
			user.language: en
			java.specification.vendor: Oracle Corporation
			awt.toolkit: sun.awt.windows.WToolkit
			java.vm.info: mixed mode
			java.version: 1.8.0_25
			java.ext.dirs: D:\Program Files\Java\jre1.8.0_25\lib\ext;C:\Windows\Sun\Java\lib\ext
			sun.boot.class.path: D:\Program Files\Java\jre1.8.0_25\lib\resources.jar;D:\Program Files\Java\jre1.8.0_25\lib\rt.jar;D:\Program Files\Java\jre1.8.0_25\lib\sunrsasign.jar;D:\Program Files\Java\jre1.8.0_25\lib\jsse.jar;D:\Program Files\Java\jre1.8.0_25\lib\jce.jar;D:\Program Files\Java\jre1.8.0_25\lib\charsets.jar;D:\Program Files\Java\jre1.8.0_25\lib\jfr.jar;D:\Program Files\Java\jre1.8.0_25\classes
			java.vendor: Oracle Corporation
			file.separator: \
			java.vendor.url.bug: http://bugreport.sun.com/bugreport/
			sun.io.unicode.encoding: UnicodeLittle
			sun.cpu.endian: little
			sun.desktop: windows
			sun.cpu.isalist: amd64
		 */
		
		/**
		 * System.getenv(key) is used to get the environment variables.
		 */
		
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(System.getenv("ABC"));
	}

}
