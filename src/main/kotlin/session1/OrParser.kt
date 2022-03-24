package session1
/**
 * OrParser tries to first parse with the first parser and then with theOther parser
 * returning the result of the first that works.
 * 
 * OrParser(MatchParser("1"), MatchParser("2")).parse("123") == "1" to "23"
 * OrParser(MatchParser("1"), MatchParser("2")).parse("23") == "2" to "3"
 * */
class OrParser<Out>(val first: Parser<Out>, val theOther: Parser<Out>): Parser<Out> {
    override fun parse(string: String): Pair<Out, String> {
        return try {
            first.parse(string)
        } catch (e:Exception) {
            theOther.parse(string)
        }
    }
}