package session1

/**
 * Match parser parsers inout that matches the prefix
 *
 * MatchParser("Hello").parse("Hello world!") == "Hello" to " world"
 * MatchParser("Hello").parse("Hell world!") throws exception
 **/
class MatchParser(val toMatch: String) : Parser<String> {
    override fun parse(string: String): Pair<String, String> {
        if (!string.startsWith(toMatch)) {
            throw Exception("parse returns wrong")
        }
        val remaining =
            string.subSequence(toMatch.length, string.length).toString()
        return toMatch to remaining
    }
}