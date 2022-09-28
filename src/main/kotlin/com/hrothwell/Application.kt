package com.hrothwell

import io.micronaut.runtime.Micronaut

object Application{
	@JvmStatic
	fun main(args: Array<String>) {
		Micronaut
			.build(*args)
			.packages("com.hrothwell")
			.mainClass(Application.javaClass)
			.start()
	}
}

