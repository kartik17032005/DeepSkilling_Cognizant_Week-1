package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
