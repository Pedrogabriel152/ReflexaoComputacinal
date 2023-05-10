package br.edu.ifg;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteReflexao {
    public void calculaComplexidade()
            throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException {

        Produto produto = new Produto(10, 5, "Game", "Jogo");

        // Obtém a instância do MemoryMXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Carrega a classe e obtém o objeto Class correspondente
        Class<?> clazz = Produto.class;
        Field valor = clazz.getDeclaredField("valor");
        Field quantidade = clazz.getDeclaredField("quantidade");
        Field nome = clazz.getDeclaredField("nome");
        Field tipo = clazz.getDeclaredField("tipo");

        valor.setAccessible(true);
        valor.setFloat(produto, 10);

        System.out.println(produto.getValor());
        // Obtém o método desejado utilizando reflexão
        // Method method = clazz.getMethod("getProdutos");

        // // Executa o garbage collector antes de medir o consumo de memória
        // System.gc();

        // // Obtém o consumo de memória antes da execução do método
        // MemoryUsage beforeMemoryUsage = memoryBean.getHeapMemoryUsage();

        // // Chama o método desejado
        // method.invoke(null, produto, 1);

        // // Executa o garbage collector após a execução do método
        // System.gc();

        // // Obtém o consumo de memória após a execução do método
        // MemoryUsage afterMemoryUsage = memoryBean.getHeapMemoryUsage();

        // // Calcula a diferença de consumo de memória
        // long memoryUsageDiff = afterMemoryUsage.getUsed() -
        // beforeMemoryUsage.getUsed();

        // // Imprime o resultado
        // System.out.println("Consumo de memória do método: " + memoryUsageDiff + "
        // bytes");
    }
}
