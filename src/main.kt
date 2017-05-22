import view.Viewer
import java.io.IOException


fun main(args: Array<String>) {

    val viewer = Viewer()

    while (true) {

        var path: String? = null

        try {

            path = readLine()

        } catch(e: IOException) {

            println(e.message)
            break

        } finally {

            viewer.run(path)

        }

    }

}
