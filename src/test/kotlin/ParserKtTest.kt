import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ParserKtTest {
    @Test
    fun foo() {
    }
    
    @Test
    fun pureTest() {
        val parser = pure("name")
        assertEquals("name" to "@gmail.com", parser.invoke("@gmail.com"))
    }
    
    @Test
    fun fmapTest() {
        val a = pure("name")
        val aToB = { output: String -> output.length }
        val input = "input"
        assertEquals(7 to input, aToB.fmap(a)(input))
    }
}