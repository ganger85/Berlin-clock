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
  }
