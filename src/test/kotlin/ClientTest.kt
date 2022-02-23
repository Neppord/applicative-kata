import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClientTest {
    @Test
    fun test() {
        val client = object:Client<Int, Int> {
            override fun send(r: Int): Int {
                return r + 1
            }
        }
        val newClient = client.fmap { "a" }
        assertEquals("a", newClient.send(20))
    }

    @Test
    fun applicative() {
        val firstNames = listOf("Doggy", "Fluffy", "Spot")
        val lastNames = listOf("Pumpkins", "Smith", "Scooby")
        val firstNameClient = object:Client<Int, String> {
            override fun send(r: Int): String {
                return firstNames[r]
            }
        }
        val lastNameClient = object:Client<Int, String> {
            override fun send(r: Int): String {
                return lastNames[r]
            }
        }
        val toFullName: (String) -> (String) -> String = {first: String -> { last: String -> "$first $last" } }
        
        val fullnameClient: Client<Int, String> = lastNameClient.apply(firstNameClient.fmap(toFullName))
        //val fullnameClientAP: Client<Int, String> = pure(toFullName).ap(firstNameClient).ap(lastNameClient)
        
        
        assertEquals("Fluffy Smith", fullnameClient.send(1))
    }
}