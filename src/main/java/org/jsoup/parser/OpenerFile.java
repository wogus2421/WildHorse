package org.jsoup.parser;

import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenerFile {
    Path relativePath;
    String path;
    String filePath;
    String browserPath;

    OpenerFile() {
        this.relativePath = Paths.get("");
        this.path = relativePath.toAbsolutePath().toString(); // 프로젝트 패스가 잡힘
        this.filePath = path + "/src/public/" + makeNewPath() + ".html";
        this.browserPath = "file://" + filePath;
    }

    int makeNewPath() {
        return (int)(Math.random() * 100) + 1;
    }

    void open(Document doc) {
        final File f = new File(this.filePath);
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f.getPath()), "UTF8"));
            out.write(doc.outerHtml());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().browse(new URI(this.browserPath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
