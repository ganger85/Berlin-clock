
object BerlinClock {

  // If any line doesn't fit in 80 chars, it's recommended to split it.
  def convertToBerlinTime(s: String) = {
    val parts = s.split(":").map(_.toInt)
    Array(
      seconds(parts(2)),
      topHours(parts(0)),
      bottomHours(parts(0)),
      topMinutes(parts(1)),
      bottomMinutes(parts(1)))
  }

  // When match has only two possible values, it's simpler to use an 'if'
  def seconds(number: Int) = if (number % 2 == 0) "Y" else "O"

  def topMinutes(i: Int) = applyPattern(generateTop(generateNumber(i), 11))

  def bottomMinutes(i: Int): String = generateBottom(i).replace("R", "Y")

  def topHours(i: Int): String = generateTop(generateNumber(i), 4)

  def bottomHours(i: Int) = generateBottom(i)

  // Better using foldLeft than vars
  def applyPattern(s: String) =
    ("" /: s.zipWithIndex) {
      case (s2, (c, count)) => s2 + replace(count, c)
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

  //Folds...folds everywhere...
  def generateTop(j: Int, total: Int): String =
    ("" /: (0 until total))(
      (l, ii) => if (ii < j) l + "R" else l + "0")

  def generateBottom(i: Int): String = {
    generateTop(i % 5, 4)
  }

}
