package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class ExcelDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening excel document...");
    }
}
