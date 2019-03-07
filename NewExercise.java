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
    System.out.print("What would you like to name the file? ");
    String file = input.next();

    String newDir = pwd + "/Exercise" + num;
    File dir = new File(newDir);
    boolean dstatus = dir.mkdir();

    String filePath = newDir + "/" + file + ".java";
    File f = new File(filePath);
    boolean fstatus = f.createNewFile();

    System.out.println("\nCreated directory: " + dstatus);
    System.out.println("Created file: " + fstatus);
  }
}
