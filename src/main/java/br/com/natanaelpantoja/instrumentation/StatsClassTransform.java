//package br.com.natanaelpantoja.instrumentation;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.security.ProtectionDomain;
//
//import javassist.ClassPool;
//import javassist.CtClass;
//import javassist.CtMethod;
//
//public class StatsClassTransform implements ClassFileTransformer {
//
//	@Override
//	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
////		System.out.println();
////		System.out.println("Processing class " + className);
////
////		String normalizedClassName = className.replaceAll("/", ".");
////
////		ClassReader classReader = null;
////		try {
////			classReader = new ClassReader(normalizedClassName);
////		} catch (IOException e1) {
////			e1.printStackTrace();
////		}
////
////		ClassNode classNode = new ClassNode();
////		classReader.accept(classNode, ClassReader.SKIP_DEBUG);
////
////		@SuppressWarnings("unchecked")
////		List<MethodNode> allMethods = classNode.methods;
////		for (MethodNode methodNode : allMethods) {
////			System.out.println(methodNode.name);
////		}
////		return classfileBuffer;
//   
//        byte[] byteCode = classfileBuffer;
//            try {
//                ClassPool cp = ClassPool.getDefault();
//                CtClass cc = cp.get("br.com.natanaelpantoja.instrumentation.TesteApp");
//                System.out.println("Teste");
//                CtMethod m = cc.getDeclaredMethod("main");
//                m.addLocalVariable("elapsedTime", CtClass.longType);
//                m.insertBefore("elapsedTime = System.currentTimeMillis();");
//                m.insertAfter("{elapsedTime = System.currentTimeMillis() - elapsedTime;"
//                        + "System.out.println(\"Method Executed in ms: \" + elapsedTime);}");
//                byteCode = cc.toBytecode();
//                cc.detach();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        return byteCode;
//	}
//
//	private static void processBizMethods(Class<?> classObject) {
//		if (MyBusinessClass.class.equals(classObject)) {
//			Method[] allMethods = classObject.getDeclaredMethods();
//			for (Method aMethod : allMethods) {
//				System.out.println(aMethod.getName());
//				int modifiers = aMethod.getModifiers();
//				if (Modifier.isPrivate(modifiers)) {
//					System.out.println("Method " + aMethod.getName() + " is private");
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		processBizMethods(MyBusinessClass.class);
//	}
//
//}
