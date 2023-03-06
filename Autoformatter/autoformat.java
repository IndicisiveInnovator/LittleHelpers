import java.io.*;
import java.util.Scanner;
public class autoformat{

    public static void main (String args[]){

        try{
        String filepath = "format.txt";
        Scanner scan = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
            
        // use buffered reader and file reader instead of scanner and string buffer
        FileReader read = new FileReader("format.txt");
        BufferedReader br = new BufferedReader(read);

/* TODO:  Remove this while loop and used buffered reader to scan through and 
add contents to a string */
        while (scan.hasNextLine()) {
            //add everything from the file to the string buffer
          buffer.append(scan.nextLine()+ System.lineSeparator());
        }


        //combine everything in the buffer and turn it into a string
        String fileContents = buffer.toString();
        //test to see if there are any contents in the buffer
        //System.out.println("contents" + fileContents);

        scan.close(); //close the scanner cause we dont need it anymore

        //split all the contents of the string into an array
        String[] array = fileContents.split("\n");

        //create this buffered writer to reformat the text file
        BufferedWriter write = new BufferedWriter(new FileWriter("format.txt"));

        //use this for loop to write and reformat the text file
        for(int i = 0; i< array.length;i++){
            String newLine = array[i].substring(array[i].indexOf('.') +1).trim();
            write.append(newLine + "\n");
;
           
        }
        write.close();//close the writer

    
} catch(Exception e){
    e.getStackTrace();
}





}
}