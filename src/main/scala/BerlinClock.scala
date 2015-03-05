
object BerlinClock {

  def convertToBerlinTime(s: String) = {
    val parts = s.split(":").map(_.toInt)
    Array(seconds(parts(2)), topHours(parts(0)), bottomHours(parts(0)), topMinutes(parts(1)))

    //val toReturnArray=Array(seconds(sArray[3]):Int,)
    s.toCharArray
  }

  def bottomMinutes(i: Int): String = generateTop(i % 5, 4).replace("R", "Y")


  def seconds(number: Int) = number % 2 match {
    case (0) => "Y"
    case _ => "O"
  }

  def topMinutes(i: Int) = applyPattern(generateTop(generateNumber(i), 11))

  def topHours(i: Int): String = generateTop(generateNumber(i), 4)

  def bottomHours(i: Int) = generateTop(i % 5, 4)

  def applyPattern(s: String) = {

    var count: Int = 0
    var s2: String = ""

    for (c <- s) {
      s2 += replace(count, c)
      count += 1
    }
    s2
  }

  def replace(c: Int, ch: Char): Char = {
    if (isReplaceable(c, ch)) 'R'
    else if (ch == 'R') 'Y'
    else ch
  }

  def isReplaceable(count: Int, c: Char): Boolean = {
    (count == 2 | count == 5 | count == 8) && c != '0'
  }

  def generateNumber(i: Int): Int = (i - (i % 5)) / 5

  def generateTop(j: Int, total: Int): String = {
    var l: String = ""
    for (ii <- 0 until total)
      if (ii < j) l += "R" else l += "0"
    l
  }


}
