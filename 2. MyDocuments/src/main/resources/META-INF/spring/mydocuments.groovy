import io.testoftiramisu.java.model.Document
import io.testoftiramisu.java.model.Type
import io.testoftiramisu.spring.data.DocumentRepository
import io.testoftiramisu.spring.data.TypeDataRepository
import io.testoftiramisu.spring.service.SearchEngineService


beans {

    engine(SearchEngineService) {
        documentDAO = ref("documentDAO")
    }

    documentDAO(DocumentRepository) {
        documents = [ref("doc1"), ref("doc2"), ref("doc3"), ref("doc4")]
    }

    typeDAO(TypeDataRepository) {
        types = [pdfType: ref("pdfType"), webType: ref("webType"), noteType: ref("noteType")]
    }

    doc1(Document) {
        name = "Book Template"
        type = ref("pdfType")
        location = "/Users/Tiramisu/Documents/tmp/Book Template.pdf"
    }

    doc2(Document) {
        name = "Sample Contract"
        type = ref("pdfType")
        location = "/Users/Tiramisu/Documents/tmp/Sample Contract.pdf"
    }

    doc3(Document) {
        name = "Clustering with RabbitMQ"
        type = ref("noteType")
        location = "/Users/Tiramisu/Documents/tmp/Clustering with RabbitMQ.txt"
    }

    doc4(Document) {
        name = "Pro Spring Security Book"
        type = ref("webType")
        location = "http://www.apress.com/9781430248187"
    }

    webType(io.testoftiramisu.java.model.Type) {
        name = "WEB"
        description = "Web Link"
        extension = ".url"
    }

    pdfType(io.testoftiramisu.java.model.Type) {
        name = "PDF"
        description = "Portable Document Format"
        extension = ".url"
    }

    noteType(io.testoftiramisu.java.model.Type) {
        name = "NOTE"
        description = "Text Notes"
        extension = ".txt"
    }
}