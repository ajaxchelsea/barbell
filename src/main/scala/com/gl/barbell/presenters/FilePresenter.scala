package com.gl.barbell.presenters

import java.io.{FileWriter, File, PrintWriter}

class FilePresenter(path: String) {
  val file: File = new File(path)
  file.delete()

  def present(text: String) = {
    val pw = new FileWriter(file, true)
    pw.write(text + System.lineSeparator())
    pw.close
  }

}
