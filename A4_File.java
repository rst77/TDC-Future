import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.Timestamp;

import org.graalvm.polyglot.Context;

public class A4_File {

    /**
     * Endereço completo do arquivo de script.
     */
    public static final String pathArquivo = "/home/renato/TDC-Future-2022/src";

    public static void main(String[] args) {

        /**
         * Cria o contexto polyglota com permissão de acesso amplo
         */
        Context polygloContext = Context.newBuilder()
                                    .allowAllAccess(true)
                                    .build();

        /**
         * Injeta um valor no contexto que pode ser usado no script.
         */
        int semente = 11;
        polygloContext.getBindings("js").putMember("semente", semente);

        /**
         * Lê o conteúdo do arquivo de script.
         */
        String content = A4_File.leConteudoArquivo();

        /**
         * Executa o do arquivo pela primeira vez.
         */
        System.out.println();
        Timestamp tsi = new Timestamp(System.currentTimeMillis());
        polygloContext.eval("js", content);
        System.out.println("Tempo total --> " + (System.currentTimeMillis() - tsi.getTime()) );

        /**
         * Trava execução esperando um ENTER
         */
        A4_File.promptEnterKey();

        /**
         * Injeta um novo valor de semente.
         */
        semente = 220;
        polygloContext.getBindings("js").putMember("semente", semente);

        /**
         * Executa o código ja compilado pela segunda vez.
         */
        tsi = new Timestamp(System.currentTimeMillis());
        System.out.println();
        polygloContext.eval("js", content);
        System.out.println("Tempo total --> " + (System.currentTimeMillis() - tsi.getTime()) );

        System.out.println();

    }

    /**
     * Segura a execução do programa e aguarda que seja pressionada a tecla ENTER.
     */
    public static void promptEnterKey(){
        System.out.println("\nPressione \"ENTER\" para rodar o código compliado...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna o conteúdo do arquivo de script.
     */
    public static String leConteudoArquivo() {
        String content = null; 

        try {
            content = Files.readString(Paths.get( pathArquivo + "/Script1.js" ));
        } catch (IOException e) {
            System.out.println("Arquivo js não encontrado.");
        }

        return content;
    }
}
