package index

import repository.Repository as Repository
import java.util.*

fun main(args: Array<String>) {
    var dataBase = Repository()
    var done: Boolean = false
    while (done === false) {
        print("\nВыберите команду:\n1) Добавить пару\n2) Найти пару\n3) Удалить пару\n4)закончить\n")
        when (readLine().toString().replace(" ", "")) {
            "1" -> {
                dataBase.addPair(readLine(), readLine())
                print("done")
            }
            "2" -> {
                var elements = dataBase.findPair(readLine(), readLine())
                for (element in elements ) print(element.contentToString())
            }
            "3" -> {
                var count = dataBase.delete(readLine(), readLine())
                print("$count пар удалено")
            }
            "4" -> done = true
        }
    }
}