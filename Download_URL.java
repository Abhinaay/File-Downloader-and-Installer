package URL_Download;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class Download_URL 
{
	public static void main(String[] args) {
        // Make sure that this directory exists or change the path
        String dirName = "D:\\Downloaded";
	String fileName="\\vlc-3.0.6-win32.exe";
        try {
            saveFileFromUrlWithJavaIO(
	//Replace "\\vlc-3.0.6-win32.exe" with your desired filename
	// Here url of vlc media player is written. You can change it as per your requirement.
                dirName + fileName, "https://mirrors.estointernet.in/videolan/vlc/3.0.6/win32/vlc-3.0.6-win32.exe");
            System.out.println("finished");
	 // File is installed through command line.
	// You can comment these 2 lines if you only want to download the file.

            String command = dirName+fileName;
            Runtime.getRuntime().exec("cmd /c "+command);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	// Using Java IO
    public static void saveFileFromUrlWithJavaIO(String filePath, String fileUrl)
    throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try { in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(filePath);
            byte data[] = new byte[1024];
            int count;
            while ((count = in .read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if ( in != null)
                in .close();
            if (fout != null)
                fout.close();
        }
    }
   
}
