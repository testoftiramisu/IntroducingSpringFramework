package io.testoftiramisu.groovy.service

import io.testoftiramisu.groovy.model.Type

interface SearchEngine {
	def findByType(Type documentType)
	def listAll()
}
