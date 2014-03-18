package views.twbs

/**
 * Marker class for horizontal form which holds the classes for the label and the input
 * @param labelClass
 * @param inputClass
 */
class FormHorizontal(val labelClass: String = "col-md-2", val inputClass: String = "col-md-10");

/**
 * Collection of helpers
 */
object TwbsHelpers {

  /**
   * Gets the class from the seq
   * @param htmlArgs
   */
  def getClasses(htmlArgs: (Symbol,Any)*):String = {
    htmlArgs.toMap.get('class).map(_.toString).getOrElse("")
  }
}