package controller

import model.*
import view.Viewer
import java.io.FileInputStream


class ControllerBMP(private val path: String, private val view: Viewer): Controller {

    private val data: ByteArray

    init {

        val file = FileInputStream(path)
        data = ByteArray(file.available())
        file.read(data)

        if (!validateFormat()) throw IllegalArgumentException("Wrong format file.")

    }

    override fun validateFormat(): Boolean {
        return (data[0].toChar() == 'B') && (data[1].toChar() == 'M')
    }

    override fun createModel(): BMP {

        val name = path.takeLastWhile { it != '\\' }

        val bitCount = data[0x1c].toInt()
        val model: BMP

        when (bitCount) {
            8 -> {
                model = BMP8bit(name, data)
            }
            24 -> {
                model = BMP24bit(name, data)
            }
            32 -> {
                model = BMP32bit(name, data)
            }
            else -> {
                throw Throwable("Wrong type of file")
            }
        }

        model.addObserver(view)
        model.parseHeader()
        model.createImage()

        return model

    }

}