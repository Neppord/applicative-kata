import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NullKtTest {
    @Test
    internal fun `none null`() {
        val f: ((Int) -> (Int) -> Int) = { x -> { y -> x * y }}
        val x:Int? = 3
        val y:Int? = 2
        assertEquals(6, f.fmap(x).ap(y))
    }
    
    @Test
    internal fun `null`() {
        val f: ((Int) -> (Int) -> Int) = { x -> { y -> x * y }}
        val x:Int? = 3
        val y:Int? = 2
        assertEquals(null, f.fmap(null).ap(y))
        assertEquals(null, f.fmap(x).ap(null))
    }
}