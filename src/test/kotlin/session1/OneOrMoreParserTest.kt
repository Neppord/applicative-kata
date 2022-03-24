package session1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/*
* P("1").p("112") -> "11", "2"
* P("2").p("223") -> "22", "3"
* P("1").p("11") -> "11", ""
* P("2").p("3") -> BOOM!
* */

class OneOrMoreParserTest {
    @Test
    fun itMatchesItsInputWithoutRepeating(){
        assertEquals(
            "1" to "22",
            OneOrMoreParser(MatchParser("1")).parse("122")
        )
        assertEquals(
            "2" to "33",
            OneOrMoreParser(MatchParser("2")).parse("233")
        )
    }

    @Test
    fun itMatchesItsInputWithRepeating(){
        assertEquals(
            "11" to "2",
            OneOrMoreParser(MatchParser("1")).parse("112")
        )
        assertEquals(
            "22" to "3",
            OneOrMoreParser(MatchParser("2")).parse("223")
        )
        assertEquals(
            "222" to "3",
            OneOrMoreParser(MatchParser("2")).parse("2223")
        )
        assertEquals(
            "2222222" to "3",
            OneOrMoreParser(MatchParser("2")).parse("22222223")
        )
    }
}