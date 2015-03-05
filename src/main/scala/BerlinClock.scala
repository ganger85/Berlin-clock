
object BerlinClock {

  def applyPattern(s: String) = {

    var count: Int = 0
    var s2: String = ""
    for (c <- s) {
      if (isReplaceable(count, c)) s2 += 'R'
      else if (c == 'R') s2 += 'Y'
      else s2 += c
      count += 1
    }

    s2
  }

  def isReplaceable(count: Int, c: Char): Boolean = {
    (count == 2 | count == 5 | count == 8) && c != '0'
  }

  def topMinutes(i: Int) = {


    applyPattern(generateTop(generateNumber(i), 11))
  }


  def generateNumber(i: Int): Int = {
    (i - (i % 5)) / 5
  }

  def bottomHours(i: Int) = generateTop(i % 5, 4)

  def topHours(i: Int): String = {

    val l = generateTop(generateNumber(i), 4)
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
