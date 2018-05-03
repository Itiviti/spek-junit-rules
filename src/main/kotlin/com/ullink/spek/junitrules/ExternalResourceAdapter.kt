package com.ullink.spek.junitrules

import org.junit.rules.ExternalResource
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.isAccessible

class ExternalResourceAdapter(private val externalResource: ExternalResource) {
    fun before() {
        executeMethod("before")
    }

    fun after() {
        executeMethod("after")
    }

    private fun executeMethod(name: String) {
        val externalResourceClass = externalResource::class
        val function = externalResourceClass.memberFunctions.first { it.name == name }
        function.isAccessible = true
        function.call(externalResource)
    }

}