
object BerlinClock {

  def generateTop(j: Int): String = {
    var l: String = ""
    for (ii <- 0 until 4)
      if (ii < j) l += "R" else l += "0"
    l
  }

  def topHours(i: Int): String = {
    val number = (i - (i % 5)) / 5
    val l = generateTop(number)
    l
  }


  def seconds(number: Int) = number % 2 match {
    case (0) => "Y"
    case _ => "O"
  }

}
