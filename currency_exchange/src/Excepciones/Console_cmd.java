package Excepciones;
import java.io.IOException;

public class Console_cmd {
    
    public static void Clear_cmd() throws IOException, InterruptedException {
        
        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }
    }


}
