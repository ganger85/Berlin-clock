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
  "Bottom minutes" should "have 4 lamps" in {
    BerlinClock.bottomMinutes(0).length should be(4)
  }

  it should "light a yellow lamp for every minute left from top minutes" in {
    BerlinClock.bottomMinutes(0) should be("0000")
    BerlinClock.bottomMinutes(17) should be("YY00")
    BerlinClock.bottomMinutes(59) should be("YYYY")
  }


  "Berlin Clock" should "result in array with 5 elements" in {
    BerlinClock.convertToBerlinTime("13:17:01").size should be(5)
  }

  it should "result in correct seconds, hours and minutes" in {
    val berlinTime = BerlinClock.convertToBerlinTime("16:37:16")
    val expected = Array("Y", "RRR0", "R000", "YYRYYRY0000", "YY00")
    berlinTime should equal(expected)
  }
  }
