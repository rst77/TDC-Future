import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import com.r13a.polyglot.Produto;


public class A3_Bindings {
     public static void main(String[] args) {

        /**
         * Cria o contexto polyglota com permissão de acesso amplo
         */
        Context polygloContext = Context.newBuilder()
                                    .allowAllAccess(true)
                                    .build();

        /**
         * Função que le os atributos do objeto do Java por injeção.
         * 
         * function printaProduto() { 
         *                              console.log(); 
         *                              console.log(produto.getNome() + ' - ' + produto.getQuantidade() ); 
         *                              console.log(); 
         *                          }
         */
        Value soma = polygloContext.eval("js", "( function printaProduto() { console.log(); console.log(produto.getNome() + ' - ' + produto.getQuantidade() ); console.log(); } )");

        /**
         * Cria a instância do objeto.
         */
        Produto produto = new Produto("Caneta Azul, Azul Caneta", 100, 3.5);

        /**
         * Obtêm ligação do contexto.
         */
        Value js = polygloContext.getBindings("js");

        /** 
         * Injeta valor no contexto 
         */ 
        js.putMember("produto", produto);

        soma.execute();

        


    }
}
