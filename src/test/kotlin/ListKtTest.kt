import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListKtTest {
    
    @Test
    fun example() {
        val operator: (Int) -> ((Int, Int) -> Int) -> (Int) -> Int =
            {x -> {op -> { y -> op(x, y)}}}
        
        val results = operator
            .fmap(listOf(1, 2, 3))
            .ap(listOf({x, y -> x + y}, {x, y -> x * y}))
            .ap(listOf(1, 2, 3))
        
        assertEquals(
            listOf(2, 3, 4, 1, 2, 3, 3, 4, 5, 2, 4, 6, 4, 5, 6, 3, 6, 9),
            results
        )
    }
}