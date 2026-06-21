package Week_1.Design_Patterns.FactoryMethodPatternExample;

public class Main {
    static void main() {
        DocumentFactory wordDocumentFactory = new WordDocumentFactory();
        wordDocumentFactory.openDocument();

        DocumentFactory pdfDocumentFactory = new PdfDocumentFactory();
        pdfDocumentFactory.openDocument();

        DocumentFactory excelDocumentFactory = new ExcelDocumentFactory();
        excelDocumentFactory.openDocument();
    }
}
