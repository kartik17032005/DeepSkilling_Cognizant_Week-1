package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class PdfDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
