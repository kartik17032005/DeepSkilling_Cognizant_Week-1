package Week_1.Design_Patterns.BuilderPatternExample;

public class Main {
    static void main() {
        // Creating a Basic Computer (only required fields)
        Computer basicComp = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();

        // Creating a Gaming Computer (with GPU and OS)
        Computer gamingComp = new Computer.Builder("AMD Ryzen 7", "16GB", "1TB SSD")
                .setGPU("NVIDIA RTX 4070")
                .setOS("Windows 11")
                .build();

        // Creating an Office Computer (with OS, without GPU)
        Computer officeComp = new Computer.Builder("Intel i5", "16GB", "512GB SSD")
                .setOS("Ubuntu 22.04")
                .build();

        // Display configurations
        System.out.println("Basic Computer Configuration:");
        System.out.println(basicComp);
        System.out.println();

        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComp);
        System.out.println();

        System.out.println("Office Computer Configuration:");
        System.out.println(officeComp);
    }
}
