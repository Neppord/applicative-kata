import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/*
 * intId:
 *  1 -> 1
 *  2 -> 2
 */

/*
 * id:
 *  1 -> 1
 */
internal class IdKtTest {
    @Test
    fun intId_should_return_the_same_integer() {
        assertEquals(1, 1.intId())
        assertEquals(2, 2.intId())
    }
    @Test
    fun id_should_return_the_same_integer() {
        assertEquals(1, 1.id())
    }
}