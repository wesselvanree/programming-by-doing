import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NewExercise
{
  public static void main(String[] args) throws IOException
  {
    java.util.Scanner input = new Scanner(System.in);
    Path currentRelativePath = Paths.get("");

    String pwd = currentRelativePath.toAbsolutePath().toString();

    // input directory name
    System.out.print("\nExercise number: ");
    int num = input.nextInt();

    // input filename
    System.out.print("What would you like to name the class? ");
    String file = input.next();

    // create directory
    String newDir = pwd + "/Exercise" + num;
    File dir = new File(newDir);
    boolean dstatus = dir.mkdir();

    // create file
    String filePath = newDir + "/" + file + ".java";
    File f = new File(filePath);
    boolean fstatus = f.createNewFile();

    // outputs status
    System.out.println("\nCreated directory: " + dstatus);
    System.out.println("Created file: " + fstatus);

    // write inside file
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
      String text = "public class " + file + "\n{\n  public static void main(String[] args)\n  {\n    \n  }\n}";
      bw.write(text);
      bw.close();
      System.out.println("Typed inside " + file + ".java for you.");
    } catch (IOException ex){
      System.out.println("couldn't write inside "+ file +".java: " + ex);
    }
  }
}
