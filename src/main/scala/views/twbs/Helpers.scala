package views.twbs

import play.twirl.api.Html

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

  /**
  * gets a field constraint as a html attr
  * constAsHtmlAttr(field,"constraint.min","min") returns min="10"
  */
  def constAsHtmlAttr(field: play.api.data.Field, constraintName: String, attrName: String): Html = {
    field.constraints.find(p => p._1 == constraintName) match {
       case Some(constraint) => {
          new Html(attrName+"=\""+constraint._2.head.toString+"\"")
       }
       case None => new Html("")
    }
  }
}
