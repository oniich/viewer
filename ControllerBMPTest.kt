import controller.ControllerBMP
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import view.Viewer
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


internal class ControllerBMPTest {

    @Test
    fun TestPixel() {
        val path = "E:\\Downloads\\bmp\\haker_24bit.bmp"
        val controller = ControllerBMP(path, Viewer())
        val model = controller.createModel()
        val image: BufferedImage = ImageIO.read(File(path))

        for (j in 0..(model.image.height - 1)) {
            for (k in 0..(model.image.width - 1)) {

                val actualPixel = model.image.getRGB(k, j)
                val expectedPixel = image.getRGB(k, j)

                assertEquals(expectedPixel, actualPixel)

            }
        }
    }
}