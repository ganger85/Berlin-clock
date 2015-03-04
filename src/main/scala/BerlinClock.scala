
object BerlinClock {
  def seconds(number: Int) = number % 2 match {
    case (0) => "Y"
    case _ => "O"
  }

}
