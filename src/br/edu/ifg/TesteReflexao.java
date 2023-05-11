package br.edu.ifg;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TesteReflexao {
    public long calculaComplexidade(Loja loja, Produto produto, long memoriaComplexa, long memoriaSimples)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException {

        // Obtém a instância do MemoryMXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Carrega a classe e obtém o objeto Class correspondente
        Class<?> classe = Loja.class;

        // Obtém o método desejado utilizando reflexão
        Method metodo = classe.getDeclaredMethod("realizarVenda", Produto.class, int.class);

        // Executa o garbage collector antes de medir o consumo de memória
        System.gc();

        metodo.setAccessible(true);

        // Obtém o consumo de memória antes da execução do método
        MemoryUsage beforeMemoryUsage = memoryBean.getHeapMemoryUsage();

        // Chama o método desejado
        metodo.invoke(loja, produto, 2);

        // Executa o garbage collector após a execução do método
        System.gc();

        // Obtém o consumo de memória após a execução do método
        MemoryUsage afterMemoryUsage = memoryBean.getHeapMemoryUsage();

        // Calcula a diferença de consumo de memória
        long memoryUsageDiff = afterMemoryUsage.getUsed() - beforeMemoryUsage.getUsed();

        // Imprime o resultado
        System.out.println("Consumo de memória do método: " + memoryUsageDiff + " bytes");
        return memoryUsageDiff;
    }
}
