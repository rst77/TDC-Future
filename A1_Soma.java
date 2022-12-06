import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;


public class A1_Soma {
     public static void main(String[] args) {
        /**
         * Cria o contexto polyglota com permissão de acesso amplo
         */
        Context polygloContext = Context.newBuilder()
                                    .allowAllAccess(true)
                                    .build();

        /**
         * Cria uma simples função em javascript.
         * 
         * function soma(x,y) {
         *                      return x+y;
         *                    }
         */
        Value soma = polygloContext.eval("js", "( function soma(x,y) {return x+y;} )");

        /**
         * Verifica se é uma função executável. -- Just for fun
         */
        System.out.println("\nExecutavel?? ---> " + soma.canExecute());

        /**
         * Invoca a função JavaScript.
         */
        Value resultado = soma.execute(10,20);

        /** 
         * Imprime o resultado e demais atributos do objeto Value.
         */
        System.out.println("\nResultado ---> " + resultado);
        System.out.println("\nÉ String ----> " + resultado.isString());
        System.out.println("\nÉ Number ----> " + resultado.isNumber());
        System.out.println();
        


    }
}
