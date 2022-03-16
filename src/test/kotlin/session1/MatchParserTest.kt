package session1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MatchParserTest {
    // test success
    // test exception
    
    @Test
    fun `it matches its input`(){
        assertEquals(
            "Hello" to " world!",
            MatchParser("Hello").parse("Hello world!")
        )
        
        assertEquals(
            "Hell" to " world!",
            MatchParser("Hell").parse("Hell world!")
        )
        
        assertEquals(
            "Hej" to " folk!",
            MatchParser("Hej").parse("Hej folk!")
        )
    }

    @Test
    fun `parse return wrong`() {
        assertThrows<Exception> { 
            val subject = MatchParser("Hello")
            subject.parse("earth")
        }
        assertThrows<Exception> { 
            val subject = MatchParser("Hello")
            subject.parse("Hell world!")
        }
        assertThrows<Exception> { 
            val subject = MatchParser("Hello")
            subject.parse("world Hello!")
        }
        
    }
}