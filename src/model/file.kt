package model

import java.awt.image.BufferedImage

interface File {

    val name: String
    val data: ByteArray
    var image: BufferedImage
    var width: Int
    var height: Int

    fun parseHeader()
    fun createImage()

    fun getValueOfBytes(count: Int, index: Int): Long {

        val bytes = data.copyOfRange(index, index + count)
        var value: Long = 0

        bytes.reverse()


        for (i in bytes) {

            var tmp = i.toInt()
            if (tmp < 0) tmp +=256
            value += tmp
            if (i != bytes.last()) value = value.shl(8)

        }

        return value

    }

}