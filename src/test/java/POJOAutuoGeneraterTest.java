import hr01.other.AutoJOPO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

public class POJOAutuoGeneraterTest {


 @Test
    public void test() throws IOException {

     AutoJOPO autoJOPO=new AutoJOPO("MenuAndRole","hr01.security.MenuAndRole");
     autoJOPO
             .addField("private","Integer","id")
             .addField("private","Integer","menuId")
             .addField("private","Integer","roleId")
             //.addField("private","String","email")
             //.addField("private","boolean","enable")
            // .addField("private","boolean","locked")
             .buildFiles();

     //System.out.println(beanString);

 }
}
