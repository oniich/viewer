package controller

import model.File

interface Controller {

    fun validateFormat(): Boolean
    fun createModel(): File

}
