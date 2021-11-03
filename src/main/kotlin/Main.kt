import java.io.File

fun main(args: Array<String>) {
    val file = File("src/main/kotlin/text")
    val list = file.readLines()
    val data = DataUtil(list.toMutableList())

    data.bubbleSort()
}