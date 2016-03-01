package br.com.natanaelpantoja.instrumentation;

import java.lang.instrument.Instrumentation;

public class MainAgent {

	public static void premain(String agentArgument, Instrumentation instrumentation) {
		System.out.println("Meu Java Agent");
		instrumentation.addTransformer(new MeuTransformer());
	}
}
