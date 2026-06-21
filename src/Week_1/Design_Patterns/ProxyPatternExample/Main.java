package Week_1.Design_Patterns.ProxyPatternExample;

public class Main {
    static void main() {
        Image image1 = new ProxyImage("landscape_wallpaper.jpg");
        Image image2 = new ProxyImage("portrait_photo.png");

        // The image1 will be loaded from the remote server on the first display call
        System.out.println("First call to display image1:");
        image1.display();
        System.out.println();

        // The image1 will not be loaded again, but displayed from cache
        System.out.println("Second call to display image1:");
        image1.display();
        System.out.println();

        // Testing image2
        System.out.println("First call to display image2:");
        image2.display();
        System.out.println();

        System.out.println("Second call to display image2:");
        image2.display();
    }
}
