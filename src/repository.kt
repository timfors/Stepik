package repository

import java.util.*

import kotlin.collections.ArrayList

class Repository(val components: ArrayList<Array<String>> = ArrayList()) {
    fun addPair(key: String, value: String) {
        this.components.add(arrayOf(key, value))
    }

    fun findPair(key: String, value: String): List<Array<String>> {
        //проверка на пустые значения
        if (key.trim() == "") {
            return this.components.filter { it: Array<String> -> value.toLowerCase() in it[1].toLowerCase() }
        } else if (value.trim() == "") {
            return this.components.filter { it: Array<String> -> key.toLowerCase() in it[0].toLowerCase() }
        }
        
        return this.components.filter { it: Array<String> -> key.toLowerCase() in it[0].toLowerCase() }
                .filter { it: Array<String> -> value.toLowerCase() in it[1].toLowerCase() }

    }

    fun delete(key: String, value: String): Int {
        //Кол-во удаленных пар
        return this.findPair(key, value)
            .map{pair : Array<String> -> this.components.remove(pair)}.count()
    }
}
