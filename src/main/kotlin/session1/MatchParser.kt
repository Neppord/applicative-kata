package session1

/**
 * Match parser parsers inout that matches the prefix
 * 
 * MatchParser("Hello").parser("Hello world!") == "Hello" to " world"
 * MatchParser("Hello").parser("Hell world!") throws exception
 **/
class MatchParser(val toMatch: String): Parser<String> {
    override fun parse(string: String): Pair<String, String> {
        TODO("Not yet implemented")
    }
}