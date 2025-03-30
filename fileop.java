import java.io.*;
import java.util.*;

public class fileop 
{
    
    // Method to write data to a file

    public static void writeToFile(String filename, String content)
     {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
         {
            writer.write(content);
            System.out.println("Data written to " + filename);
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read data from a file

    public static void readFromFile(String filename) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
         {
            String line;
            System.out.println("Reading from " + filename + ":");
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
        }
         catch (IOException e)
          {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

      
    // Method to modify content in a file (replace old text with new text)
        public static void modifyFile(String filename, String oldContent, String newContent) 
        {
            try {
                File file = new File(filename);
                if (!file.exists())
                 {
                    System.out.println("File does not exist. Nothing to modify.");
                    return;
                }
    
                // Read the file content
                StringBuilder contentBuilder = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    String line;
                    while ((line = reader.readLine()) != null)
                     {
                        contentBuilder.append(line).append("\n");
                    }
                }
    
                // Replace old content with new content
                String updatedContent = contentBuilder.toString().replace(oldContent, newContent);
    
                // Write the updated content back to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
                 {
                    writer.write(updatedContent);
                }
    
                System.out.println("File modified successfully!");
    
            } 
            catch (IOException e) 
            {
                System.out.println("An error occurred while modifying the file.");
                e.printStackTrace();
            }
        }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String filename = "example.txt";

        // Step 1: Write to the file

        System.out.println("Enter content to write to the file:");
        String contentToWrite = scanner.nextLine();
        writeToFile(filename, contentToWrite);

        // Step 2: Read from the file
                
        readFromFile(filename);

     // Step 3: Modify the file
            System.out.println("Enter the text you want to replace:");
            String oldText = scanner.nextLine();
            System.out.println("Enter the new text:");
            String newText = scanner.nextLine();
            modifyFile(filename, oldText, newText);
    
            // Step 4: Read the modified content
            readFromFile(filename);
           scanner.close();

    }
}
