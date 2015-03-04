class ClockTest extends  UnitSpec{

  "Yellow lamp" should "blink on/off every two seconds" in {
    BerlinClock.seconds(0) should be ("Y")
    BerlinClock.seconds(1) should be ("O")
  }

 "Top hours" should "have 4 lamps" in {
    BerlinClock.topHours(7).length should be (4)
  }
  it should "light a red lamp for every 5 hours" in {
    BerlinClock.topHours(0) should be("0000")
    BerlinClock.topHours(13) should be("RR00")
    BerlinClock.topHours(23) should be("RRRR")
    BerlinClock.topHours(24) should be("RRRR")
  }
  "Bottom hours" should "have 4 lamps" in {
    BerlinClock.bottomHours(5).length should be(4)
  }

  it should "light a red lamp for every hour left from top hours" in {
    BerlinClock.bottomHours(0) should be("0000")
    BerlinClock.bottomHours(13) should be("RRR0")
    BerlinClock.bottomHours(23) should be("RRR0")
    BerlinClock.bottomHours(24) should be("RRRR")
  }

  "Top minutes" should "have 11 lamps" in {
    BerlinClock.topMinutes(34).length should be(11)
  }
  it should "have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter" in {
    val minutes32 = BerlinClock.topMinutes(32)
    minutes32(2) should be('R')
    minutes32(5) should be('R')
    minutes32(8) should be('0')
  }
  it should "light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter" in {
    BerlinClock.topMinutes(0) should be("00000000000")
    BerlinClock.topMinutes(17) should be("YYR00000000")
    BerlinClock.topMinutes(59) should be("YYRYYRYYRYY")
  }
  }
