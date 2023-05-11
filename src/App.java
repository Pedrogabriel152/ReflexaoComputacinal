import br.edu.ifg.Loja;
import br.edu.ifg.Produto;
import br.edu.ifg.TesteReflexao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TesteReflexao complexidade = new TesteReflexao();
        Loja loja = new Loja();

        Produto tenis = new Produto(10, 50, "Tenis", "Calcados");
        loja.adicionaProduto(tenis);

        Produto camisa = new Produto(50, 100, "Camisa", "Vestimento");
        loja.adicionaProduto(camisa);


        
        long memoriaComplexa = 0;
        long memoriaSimples = 0;

        memoriaComplexa =  complexidade.calculaComplexidade(loja, camisa, memoriaComplexa, memoriaSimples);
        
        memoriaSimples = complexidade.calculaComplexidade(loja, camisa, memoriaComplexa, memoriaSimples);
    }
}
