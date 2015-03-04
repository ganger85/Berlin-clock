
object BerlinClock {
  def topMinutes(i: Int) = generateTop((i - (i / 12)) % 12, 11)


  def bottomHours(i: Int) = generateTop(i % 5, 4)

  def topHours(i: Int): String = {
    val number = (i - (i % 5)) / 5
    val l = generateTop(number, 4)
    l
  }

  def seconds(number: Int) = number % 2 match {
    case (0) => "Y"
    case _ => "O"
  }

  def generateTop(j: Int, total: Int): String = {
    var l: String = ""
    for (ii <- 0 until total)
      if (ii < j) l += "R" else l += "0"
    l
  }


}
