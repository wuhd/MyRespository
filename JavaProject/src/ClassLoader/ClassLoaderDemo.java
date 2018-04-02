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
		// 1打印ClassLoaderDemo的类加载AppClassLoader路径
		Class classMain = ClassLoaderDemo.class;
		ClassLoader classLoader = classMain.getClassLoader();
		System.out.println("classLoader :" + classLoader);
	
		// 2打印appClassLoader的加载路径(其实就是该项目的class path)
		URL[] mUrls = ((URLClassLoader)classLoader).getURLs();
		print(mUrls);
		
		// 3通过getParent方法，打印parent字段
		ClassLoader parentLoader = classLoader.getParent();
		System.out.println("parentLoader :" + parentLoader);
		
		// 4打印ExtClassLoader的加载路径
		URL[] mUrls_parent = ((URLClassLoader)parentLoader).getURLs();
		print(mUrls_parent);
		
		// 5通过getParent方法，打印parentLoader的parent字段
		ClassLoader parentLoader_2 = parentLoader.getParent();
		System.out.println("parentLoader_2 :" + parentLoader_2);
		
		// 6打印BootstrapClassLoader的类加载路径
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
