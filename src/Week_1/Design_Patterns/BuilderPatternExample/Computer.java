package Week_1.Design_Patterns.BuilderPatternExample;

public class Computer {
    // Attributes
    private final String CPU;
    private final String RAM;
    private final String Storage;
    private final String GPU;
    private final String OS;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
    }

    // Getters
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getOS() {
        return OS;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + 
               ", GPU=" + (GPU != null ? GPU : "None") + ", OS=" + (OS != null ? OS : "None") + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;
        private final String Storage;

        // Optional attributes
        private String GPU;
        private String OS;

        // Constructor for required attributes
        public Builder(String CPU, String RAM, String Storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.Storage = Storage;
        }

        // Methods to set optional attributes (returns Builder for method chaining)
        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        // Build method to return Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
