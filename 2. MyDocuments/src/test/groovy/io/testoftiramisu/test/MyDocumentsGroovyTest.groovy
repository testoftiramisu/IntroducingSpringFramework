package io.testoftiramisu.test

import io.testoftiramisu.groovy.model.Document
import io.testoftiramisu.groovy.model.Type
import io.testoftiramisu.groovy.service.SearchEngine
import org.junit.Test

import static org.junit.Assert.*

class MyDocumentsGroovyTest {


    @Test
    public void testFindByType() {
        def documents = engine.findByType(types.web)
        assertNotNull documents
        assertTrue documents.size() == 1
        assertEquals types.web.name, documents[0].type.name
        assertEquals types.web.desc, documents[0].type.desc
        assertEquals types.web.extension, documents[0].type.extension
    }

    @Test
    public void testListAll() {
        def documents = engine.listAll()
        assertNotNull documents
        assertTrue documents.size == 4
    }

    def engine = [
            findByType: { type ->
                docs.findAll { it.type.name == type.name }
            },
            listAll   : {
                docs
            }] as SearchEngine

    def types = [
            pdf : new Type(name: "PDF", desc: "Portable Document Format", extension: ".pdf"),
            note: new Type(name: "NOTE", desc: "Text Notes", extension: ".txt"),
            web : new Type(name: "WEB", desc: "Web Link", extension: ".url")]

    def docs = [
            new Document(name: "Book Template", type: types.pdf, location: "/Users/Tiramisu/Documents/tmp/Book Template.pdf"),
            new Document(name: "Sample Contract", type: types.pdf, location: "/Users/Tiramisu/Documents/tmp/Sample Contract.pdf"),
            new Document(name: "Clustering with RabbitMQ", type: types.note, location: "/Users/Tiramisu/Documents/tmp/Clustering with RabbitMQ.txt"),
            new Document(name: "Pro Spring Security Book", type: types.web, location: "http://www.apress.com/9781430248187")]


}
