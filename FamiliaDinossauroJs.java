import org.graalvm.polyglot.*;

import com.r13a.familiadinossauro.Ovo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FamiliaDinossauroJs {
  
    public static void main(String[] args) {
        Context context = Context.newBuilder()
                .allowAllAccess(true)
                .build();

                String content = null;
        try {
            String arquivo = "/home/renato/TDC-Future-2022/src/mamae.js";
            System.out.println("\nArquivo de script --> " + arquivo);
            System.out.println();
            content = Files.readString(Paths.get(arquivo));
        } catch (IOException e) {
            System.out.println("Arquivo js não encontrado.");
        }

        context.getBindings("js").putMember("ovo", new Ovo()); 
        
        context.eval("js", content);

    }
}
