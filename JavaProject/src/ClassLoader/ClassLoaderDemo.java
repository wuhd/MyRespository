package ClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
/*
 * AppClassLoader
 * ExtClassLoader
 * BootstrapClassLoader
 */
public class ClassLoaderDemo {

	public static void main(String[] args)  {
		// 1��ӡClassLoaderDemo�������AppClassLoader·��
		Class classMain = ClassLoaderDemo.class;
		ClassLoader classLoader = classMain.getClassLoader();
		System.out.println("classLoader :" + classLoader);
	
		// 2��ӡappClassLoader�ļ���·��(��ʵ���Ǹ���Ŀ��class path)
		URL[] mUrls = ((URLClassLoader)classLoader).getURLs();
		print(mUrls);
		
		// 3ͨ��getParent��������ӡparent�ֶ�
		ClassLoader parentLoader = classLoader.getParent();
		System.out.println("parentLoader :" + parentLoader);
		
		// 4��ӡExtClassLoader�ļ���·��
		URL[] mUrls_parent = ((URLClassLoader)parentLoader).getURLs();
		print(mUrls_parent);
		
		// 5ͨ��getParent��������ӡparentLoader��parent�ֶ�
		ClassLoader parentLoader_2 = parentLoader.getParent();
		System.out.println("parentLoader_2 :" + parentLoader_2);
		
		// 6��ӡBootstrapClassLoader�������·��
		try {
			Class classLauncher = Class.forName("sun.misc.Launcher");
			Method methodGetClassPath = classLauncher.getDeclaredMethod("getBootstrapClassPath", null);
			if(methodGetClassPath != null){
				methodGetClassPath.setAccessible(true);
				Object mObject = methodGetClassPath.invoke(null, null);
				if(mObject!=null){
					Method methodGetURLS = mObject.getClass().getDeclaredMethod("getURLs", null);
					if(methodGetURLS!=null){
						URL[] mUrls2 = (URL[]) methodGetURLS.invoke(mObject, null);
						print(mUrls2);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void print(URL[] urls){
		for (URL url : urls) {
			System.out.println("url:"+url);
		}
	}
}
