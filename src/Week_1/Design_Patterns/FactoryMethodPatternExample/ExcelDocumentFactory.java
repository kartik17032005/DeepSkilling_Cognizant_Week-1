package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
