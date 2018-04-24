package repository

import java.util.*

import kotlin.collections.ArrayList

class Repository(val components: ArrayList<Array<String?>> = ArrayList()) {
    fun addPair(key: String?, value: String?) {
        this.components.add(arrayOf(key, value))
    }

    fun findPair(key: String?, value: String?): List<Array<String?>> {
        if (key.toString().replace(" ", "") == "") {
            return this.components.filter { it: Array<String?> -> value == it[1] }
        } else if (value.toString().replace(" ", "") == "") {
            return this.components.filter { it: Array<String?> -> key == it[0] }
        }

        return this.components.filter { it: Array<String?> -> key in it }
                .filter { it: Array<String?> -> value in it }

    }

    fun delete(key: String?, value: String?): Int {
        var found = this.findPair(key, value)
        var count: Int = 0
        for (element in found) {
            this.components.remove(element)
            count++
        }
        return count
    }
}