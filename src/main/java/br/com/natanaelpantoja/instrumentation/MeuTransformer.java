package br.com.natanaelpantoja.instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URL;
import java.security.ProtectionDomain;

import javassist.ByteArrayClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class MeuTransformer implements ClassFileTransformer {
	private ClassPool pool;

	public MeuTransformer() {
		pool = ClassPool.getDefault();
	}

	public byte[] transform(ClassLoader classLoader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println("Entrei");
		try {
			pool.insertClassPath(new ByteArrayClassPath(className, classfileBuffer));
			CtClass cclass = pool.get(className.replaceAll("/", "."));
			if (!cclass.isFrozen()) {
				  for (CtMethod currentMethod : cclass.getDeclaredMethods()) {
					  System.out.println(currentMethod.getName());
				  }
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return classfileBuffer;
	}

}
