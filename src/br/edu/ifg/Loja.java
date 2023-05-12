package br.edu.ifg;

import java.util.HashMap;

public class Loja {
    private HashMap<String, Produto> produtos = new HashMap<String, Produto>();

    public Loja() {
    }

    public void adicionaProduto(Produto produto) {
        HashMap<String, Produto> produtos = this.getProdutos();

        produtos.put(produto.getNome(), produto);
        this.setProdutos(produtos);
    }

    // public void realizarVenda(Produto produto, int quantCompra) {
    //     int quant = produto.getQuantidade();
    //     if (quantCompra > quant || quant == 0) {
    //         System.out.println("Sem produtos suficientes no estoque");
    //         return;
    //     }

    //     produto.setQuantidade(quant - quantCompra);
    //     System.out.println("Compra realizada com sucesso, restante no estoque: " + produto.getQuantidade());
    // }

    public void realizarVenda(Produto produto, int quantCompra) {
        HashMap<String, Produto> produtos = this.getProdutos();
        Boolean product = false;

        System.out.println("\n\nExecutou esse metodo");

        for (String key : produtos.keySet()) {
            Produto produtoExistente = produtos.get(key);

            if (produtoExistente.getNome().equals(produto.getNome())) {
                product = true;
            }
        }

        if (!product) {
            System.out.println("Este produto não exites na loja");
            return;
        }

        int quant = produto.getQuantidade();
        if (quantCompra > quant || quant == 0) {
            System.out.println("Sem produtos suficientes no estoque");
            return;
        }

        produto.setQuantidade(quant - quantCompra);
        System.out.println("Compra realizada com sucesso, restante no estoque: " + produto.getQuantidade());
    }

    public HashMap<String, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<String, Produto> produtos) {
        this.produtos = produtos;
    }

}
