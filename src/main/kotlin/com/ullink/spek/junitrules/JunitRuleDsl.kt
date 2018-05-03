package com.ullink.spek.junitrules

import org.jetbrains.spek.api.dsl.SpecBody
import org.junit.rules.ExternalResource

private fun createAdapters(externalResource: Array<out ExternalResource>, adapterSetup: (ExternalResourceAdapter) -> Unit) {
    externalResource.forEach {
        adapterSetup.invoke(ExternalResourceAdapter(it))
    }
}

fun SpecBody.withTestRules(vararg externalResource: ExternalResource) {
    createAdapters(externalResource, {
        beforeEachTest {
            it.before()
        }
        afterEachTest {
            it.after()
        }
    })
}

fun SpecBody.withGroupRules(vararg externalResource: ExternalResource) {
    createAdapters(externalResource, {
        beforeGroup {
            it.before()
        }
        afterGroup {
            it.after()
        }
    })
}