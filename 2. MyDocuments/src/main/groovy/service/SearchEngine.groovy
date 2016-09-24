package service

import model.Type

interface SearchEngine {
	def findByType(Type documentType)
	def listAll()
}
