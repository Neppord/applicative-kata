package session1

/**
 * OneOrMoreParser repeats the parser one or as long as the input matches the parser
 *
 * OneOrMoreParser(MatchParser("1")).parse("1123") == "11" to "23"
 * OneOrMoreParser(MatchParser("1")).parse("23") throws exception
 * */
class OneOrMoreParser(val toRepeat: Parser<String>) : Parser<String> {
    override fun parse(string: String): Pair<String, String> {
        return try {
            val (first, second) = toRepeat.parse(string)
            val (first1, second1) = this.parse(second)
            first + first1 to second1
        } catch (e: Exception) {
            toRepeat.parse(string)
        }
    }
}