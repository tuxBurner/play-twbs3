package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {


  /**
   * Form for the form examples
   */
  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "age" -> number(min = 0, max = 100),
      "static" -> text,
      "gender" -> text
    )(UserData.apply)(UserData.unapply)
  )

  /**
   * Entity which binds the data from the userForm
   * @param name
   * @param age
   * @param static
   */
  case class UserData(name: String, age: Int, static: String, gender: String)


  def index = Action {
    val anyData = Map("static" -> "Just a static text in the form")



    Ok(views.html.index(userForm.fill(new UserData("",0,"I am a static string in this form","male"))))
  }

  def formTest = Action {
    implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.index(formWithErrors))
      },
      userData => {
        /* binding success, you get the actual value. */
        Ok(views.html.index(userForm))
      }
    );
  }

}
