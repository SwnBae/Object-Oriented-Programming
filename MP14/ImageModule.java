public class ImageModule {
    String extension;

    public ImageModule(String ext) {
        extension = ext;
    }

    public String getName() {
        return extension + " Module";
    }

    //@Override
    public void show(String fileName) {
        System.out.printf(extension + " image loading: %s\n", fileName);
    }

    //@Override
    public String getExtension() {
        return extension;
    }
}
