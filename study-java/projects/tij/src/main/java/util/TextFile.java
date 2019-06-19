package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


public class TextFile implements Iterable<String> {
    File file;
    String[] contents;
    String separator;

    void readContent() {
        try {
            FileInputStream fis = new FileInputStream(this.file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            contents = new String(b, "UTF8").split(this.separator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TextFile(String fileName, String separator) {
        file = new File(fileName);
        this.separator = separator;
        readContent();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int current = 0;
            int maxIndex = contents.length-1;
            @Override
            public boolean hasNext() {
                return current <= maxIndex;
            }

            @Override
            public String next() {
                return contents[current++];
            }
        };
    }

    public static void main(String[] args) {
        for(String s: new TextFile("test",";")){
            System.out.println(s);
        }
    }
}
