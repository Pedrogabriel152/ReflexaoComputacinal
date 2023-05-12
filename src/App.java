import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import br.edu.ifg.Loja;
import br.edu.ifg.Produto;
import br.edu.ifg.TesteReflexao;

public class App {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();
        Scanner sc = new Scanner(System.in);
        TesteReflexao complexidade = new TesteReflexao();
        int opcao = 0;

        Produto tenis = new Produto(10, 50, "Tenis", "Calcados");
        loja.adicionaProduto(tenis);

        Produto camisa = new Produto(50, 100, "Camisa", "Vestimento");
        loja.adicionaProduto(camisa);

        Produto notebook = new Produto(5000, 100, "Notebook", "Tecnologia");
        loja.adicionaProduto(notebook);

        Produto celular = new Produto(50, 100, "Celular", "Tecnologia");
        loja.adicionaProduto(celular);

        Produto cinto = new Produto(50, 100, "Cinto", "Acessorio");
        loja.adicionaProduto(cinto);

        System.out.println("O que deseja fazer");
        System.out.println("1 - Comprar produto");
        System.out.println("2 - Sair");

        opcao = sc.nextInt();

        while(opcao == 1) {
            
            if(opcao == 1){
                Produto produto = escolheProduto(loja);

                System.out.println("\nQuantos produtos deseja comprar");
                int quantCompra = sc.nextInt();

                complexidade.verificaSePrecisaAlterarMetodo(loja, produto, quantCompra);

                System.out.println("O que deseja fazer");
                System.out.println("1 - Comprar produto");
                System.out.println("2 - Sair");

                opcao = sc.nextInt();
            }else{
                break;
            }
        }

        sc.close();
        
    }

    public static Produto escolheProduto(Loja loja) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Produto> produtos = new HashMap<String, Produto>();
        int i = 1;
        ArrayList<String> keys = new ArrayList<String>();
        int opcao = 0;
        Produto produtoSelecionado;

        produtos = loja.getProdutos();

        while(opcao == 0 || opcao > (produtos.size())){
            System.out.println("\n\nEscolha o produto que deseja compra:");

            if(i >= produtos.size()){
                i = 1;
            }

            for (String key : produtos.keySet()) {
                System.out.println(i+"-"+ key);
                i++;   
                keys.add(key);
            }
            
            opcao = sc.nextInt();
        }

        produtoSelecionado = produtos.get(keys.get(opcao -1));

        return produtoSelecionado;

    }
}
