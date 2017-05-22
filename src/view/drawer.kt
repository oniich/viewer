package view

import model.*
import javax.swing.*


class Drawer(private val frame: JFrame) {

    fun draw(model: File) {

        val panel = ImagePanel(model.image)
        panel.setSize(model.width, model.height)

        frame.setBounds(100, 100, model.width, model.height)
        frame.contentPane = panel

    }

}
