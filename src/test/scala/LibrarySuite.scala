/*
 * This Scala Testsuite was auto generated by running 'gradle init --type scala-library'
 * by 'twer' at '6/26/14 3:52 PM' with Gradle 1.11
 *
 * @author twer, @date 6/26/14 3:52 PM
 */

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LibrarySuite extends FunSuite {
  test("someLibraryMethod is always true") {
    def library = new Library()
    assert(library.someLibraryMethod)
  }
}
