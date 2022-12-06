import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import com.r13a.polyglot.Produto;

public class A2_Classe {
     public static void main(String[] args) {

        /**
         * Cria o contexto polyglota com permissão de acesso amplo
         */
        Context polygloContext = Context.newBuilder()
                                    .allowAllAccess(true)
                                    .build();

        /**
         * Cria uma função que imprime o valor de um método de um objeto enviado pelo Java.
         * 
         * function soma(produto) {
         *                          console.log(produto.getNome() + ' - ' + produto.getQuantidade() );
         *                         }
         */
        Value soma = polygloContext.eval("js", "( function soma(produto) { console.log(produto.getNome() + ' - ' + produto.getQuantidade() );} )");

        /**
         * Cria o objeto que será enviado para a função JavaScript.
         */
        Produto p = new Produto("Caneta Azul, Azul Caneta", 100, 3.5);

        /**
         * Executa a função e gera o resultado.
         */
        System.out.println();
        soma.execute(p);
        System.out.println();

    }
}
