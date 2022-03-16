package session1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OrParserTest {
    @Test
    fun `one of the parser match`() {
        assertEquals(
            "1" to "23",
            OrParser(MatchParser("1"), MatchParser("2"))
                .parse("123")
        )
    }
    
    @Test
    fun `one of the parsers doesn't match`() {
        assertEquals(
            "2" to "3",
            OrParser(MatchParser("1"), MatchParser("2"))
                .parse("23")
        )
    }
}