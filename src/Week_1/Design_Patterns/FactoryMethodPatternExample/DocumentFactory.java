package Week_1.Design_Patterns.FactoryMethodPatternExample;

public abstract class DocumentFactory {
    public abstract Document createDocument();

    public void openDocument(){
        Document document = createDocument();
        document.open();
    }
}
