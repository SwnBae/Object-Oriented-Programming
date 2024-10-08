import java.util.ArrayList;

public class ImageViewer {
    ArrayList<ImageViewerInterface> plugins;
    public ImageViewer() {
        plugins = new ArrayList<ImageViewerInterface>();
    }

    public void addPlugIn(ImageViewerInterface ivi) {
        plugins.add(ivi);
    }

    public void show(String fileName, String ext) {
        boolean found = false;
        for (ImageViewerInterface p : plugins) {
            if (p.getExtension().equals(ext)) {
                p.show(fileName);
                found = true;
            }
        }
        if (found == false) {
            System.out.printf("Image viewer plugin for the extension, %s, is not registered", ext);

        }
    }

}
