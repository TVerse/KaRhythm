package nl.sogyo.kbd

import org.scalatest._

class PatternSpec extends FlatSpec with MustMatchers {
  "A pattern" should "be creatable with a Vector(Vector(0))" in {
    val p = Pattern(Track(false))
    p.data mustBe Vector(Track(false))
  }

  it should "have a defined length" in {
    val p = Pattern(Track(false))
    p.length mustBe 1
  }

  it should "have a defined number of tracks" in {
    val p = Pattern(Track(false))
    p.tracks mustBe 1
  }

  it should "throw NoTracksDefinedException when given 0 tracks" in {
    a[NoTracksDefinedException] should be thrownBy {
      Pattern()
    }
  }

  it should "throw ZeroLengthTrackException when given 0 length tracks" in {
    a[ZeroLengthTrackException] should be thrownBy {
      Pattern(Track())
    }
  }

  it should "throw UnevenLengthException when given different length in different tracks" in {
    an[UnevenLengthException] should be thrownBy {
      Pattern(Track(false), Track(true, false))
    }
  }
}
