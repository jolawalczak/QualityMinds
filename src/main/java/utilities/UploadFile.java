package utilities;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

@Slf4j
public class UploadFile {

    public static void uploadFile(String fileLocation, Robot robot) {

        try {

            setClipboardData(fileLocation);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(3000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            log.info(e.toString());
        }
    }


    public static void setClipboardData (String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static String getClipboardData() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }


}
