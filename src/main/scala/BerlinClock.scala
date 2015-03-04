
object BerlinClock {
  def topHours(i: Int) = {
    val l="0000"
    l.toCharArray
  }


  def seconds(number: Int) = number % 2 match {
    case (0) => "Y"
    case _ => "O"
  }

}
