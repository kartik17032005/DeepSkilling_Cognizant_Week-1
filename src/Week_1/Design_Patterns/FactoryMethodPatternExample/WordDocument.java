package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class WordDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening word document...");
    }
}
