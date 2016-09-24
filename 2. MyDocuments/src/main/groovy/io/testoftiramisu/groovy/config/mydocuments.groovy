package io.testoftiramisu.groovy.config

import io.testoftiramisu.java.model.Document
import io.testoftiramisu.java.model.Type
import io.testoftiramisu.spring.data.DocumentRepository
import io.testoftiramisu.spring.service.SearchEngineService


// Groovy bean Configuration Example
beans {

    engine(SearchEngineService) {
        documentDAO = ref("documentDAO")
    }

    documentDAO(DocumentRepository) {
        doc1 = ref("doc1")
        doc2 = ref("doc2")
        doc3 = ref("doc3")
        doc4 = ref("doc4")
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
        name = "Pro Security Book"
        type = ref("webType")
        location = "http://www.apress.com/9781430248187"
    }

    webType(Type){
        name= "WEB"
        description= "Web Link"
        extension = ".url"
    }

    pdfType(Type){
        name= "PDF"
        description= "Portable Document Format"
        extension = ".pdf"
    }

    noteType(Type){
        name= "NOTE"
        description= "Text Notes"
        extension = ".txt"
    }
}