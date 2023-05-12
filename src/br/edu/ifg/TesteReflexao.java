package br.edu.ifg;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteReflexao {
    private long memoriaComplexa = 0;
    private long memoriaSimples = 0;

    public void verificaSePrecisaAlterarMetodo(Loja loja, Produto produto, int quantCompra)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException,
            NoSuchFieldException {

        // Obtém a instância do MemoryMXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        Method metodo = this.recuperaMetodo();

        if(this.memoriaComplexa > this.getMemoriaSimples()){
            loja = this.alteraMetodo(loja);
        }

        long memoriaDiferenca = this.verificaMemoriaGasta(metodo, memoryBean, loja, produto, quantCompra);

        this.alteraMemoria(memoriaDiferenca);
    }

    public long verificaMemoriaGasta(Method metodo, MemoryMXBean memoryBean, Loja loja, Produto produto, int quantCompra) throws IllegalAccessException, InvocationTargetException{
         // Executa o garbage collector antes de medir o consumo de memória
         System.gc();

         // Obtém o consumo de memória antes da execução do método
         MemoryUsage beforeMemoryUsage = memoryBean.getHeapMemoryUsage();
 
         // Chama o método desejado
         metodo.invoke(loja, produto, quantCompra);
 
         // Executa o garbage collector após a execução do método
         System.gc();
 
         // Obtém o consumo de memória após a execução do método
         MemoryUsage afterMemoryUsage = memoryBean.getHeapMemoryUsage();
 
         // Calcula a diferença de consumo de memória
         long memoriaDiferenca = afterMemoryUsage.getUsed() - beforeMemoryUsage.getUsed();
 
         // Imprime o resultado
         System.out.println("Consumo de memória do método: " + memoriaDiferenca + " bytes\n\n");

         return memoriaDiferenca;
    }

    public Method recuperaMetodo() throws NoSuchMethodException, SecurityException{
        // Carrega a classe e obtém o objeto Class correspondente
        Class<?> classe = Loja.class;

        // Obtém o método desejado utilizando reflexão
        Method metodo = classe.getDeclaredMethod("realizarVenda", Produto.class, int.class);

        metodo.setAccessible(true);

        return metodo;
    }

    public Loja alteraMetodo(Loja loja){
        Loja modificar = new Loja() {
            @Override
            public void realizarVenda(Produto produto, int quantCompra){
                int quant = produto.getQuantidade();
                if (quantCompra > quant || quant == 0) {
                    System.out.println("Sem produtos suficientes no estoque");
                    return;
                }

                produto.setQuantidade(quant - quantCompra);
                System.out.println("Compra realizada com sucesso, Esta ainda no estoque no estoque: " + produto.getQuantidade());
            }
        };

        loja = modificar;

        return loja;
    }

    public void alteraMemoria(long memoriaDiferenca) {
        if(this.getMemoriaComplexa() == 0){
            this.setMemoriaComplexa(memoriaDiferenca);
        }else{
            this.setMemoriaSimplex(memoriaDiferenca);
        }
    }

    public long getMemoriaComplexa() {
        return memoriaComplexa;
    }

    public void setMemoriaComplexa(long memoriaComplexa) {
        this.memoriaComplexa = memoriaComplexa;
    }

    public long getMemoriaSimples() {
        return memoriaSimples;
    }

    public void setMemoriaSimplex(long memoriaSimplex) {
        this.memoriaSimples = memoriaSimplex;
    }

    
}
