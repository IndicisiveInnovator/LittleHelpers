import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class autoformat{

    public static void main (String args[]){
        BufferedReader br = null;
        File file = new File("Autoformatter/format.txt");

        try{
        String filepath = "format.txt";
        StringBuffer buffer = new StringBuffer();
            
        // use buffered reader and file reader instead of scanner and string buffer
    
        FileReader read = new FileReader(file);
        br = new BufferedReader(read);

        String currLine;
        while((currLine = br.readLine()) != null){
            buffer.append(currLine + "\n" );
            //System.out.println(currLine);
        }

       //combine everything in the buffer and turn it into a string
        String fileContents = buffer.toString();
        //test to see if there are any contents in the buffer
        System.out.println("contents" + fileContents);

        //split all the contents of the string into an array
        String[] array = fileContents.split("\n");

        //create this buffered writer to reformat the text file
        BufferedWriter write = new BufferedWriter(new FileWriter("Autoformatter/format.txt"));

        //use this for loop to write and reformat the text file
        for(int i = 0; i< array.length;i++){
            String newLine = array[i].substring(array[i].indexOf('.') +1).trim();
            write.append(newLine + "\n");
;
           
        }
        write.close();//close the writer 

} catch(IOException e){
   e.printStackTrace();
}catch(Exception e){
    e.getStackTrace();
    } 
finally{
try{
    if(br != null)
        br.close();
    } catch(IOException ex){
        ex.printStackTrace();
    }
}
}
}