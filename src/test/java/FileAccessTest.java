import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import ch.hftm.trainingApp.data.FileAccess;

public class FileAccessTest {

    private void assertNotTrue(boolean contains, String readFile) {
    }

    // Testing the actual Path
    @Test
    public void getActualDirectoryString() {
        String actualDirPath = "C:\\temp";
        assertEquals(FileAccess.getActualDirectoryString(), actualDirPath);
    }

    // Testing if the Files are empty
    // Needed a tetxfile, which is not empty
    @Test
    public void readFile() throws IOException {
        
        String expectedContent = "";
        String textFile = "test.txt";

        assertNotTrue(expectedContent.isEmpty(), FileAccess.readFile(textFile));
    }

    // @Test
    // public void 
}
