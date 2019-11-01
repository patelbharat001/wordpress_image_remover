import java.io.File;
import java.util.Scanner;

/**
 * This is just a basic program which will help you to remove all extra generated images
 * from wordpress which are genetaed by wordrepss and theme.
 * To use this class, compilte it and run it.
 * You might face issue if folder is readonly, to avoid this issue, copy all image to temp folder and then run this program on that folder
 * @author Bharat Ranpariya
 */
public class ImageRemover {

    public static void main(String args[]) {
        System.out.println("Enter folder path: ");
        Scanner input = new Scanner(System.in);
        String path = input.next();

        File folder = new File(path );
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String filename = listOfFiles[i].getName();
                // name-15-150x170.jpg
                if (filename.contains("-") && filename.contains("x")) {
                    // name 15 150 170.jpg
                    String[] names = filename.split("-");
                    // 150 170.jpg
                    String[] compressedName = names[names.length - 1].split("x");
                    String extentionname = compressedName[compressedName.length - 1].toLowerCase();
                    if (extentionname.contains(".jpg") || extentionname.contains(".jpeg") || extentionname.contains(".png") || extentionname.contains(".gif")){
                        listOfFiles[i].delete();
                    }
                }
            }
        }
    }
}
