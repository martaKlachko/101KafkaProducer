import java.io.*;

public class Main {
    public static void main(String[] args)  {

        KafkaFileProducer producer = new KafkaFileProducer("test1");
        int lineCount = 0;
        FileInputStream fis;
        BufferedReader br = null;
        try {
            fis = new FileInputStream("src/main/resources/train.csv");
            //Construct BufferedReader from InputStreamReader
            br = new BufferedReader(new InputStreamReader(fis));

            String line ;
            while ((line = br.readLine()) != null) {
                lineCount++;
                producer.sendMessage(lineCount+"", line);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}