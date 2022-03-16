package session1

/**
 * OneOrMoreParser repeats the parser one or as long as the input matches the parser
 * 
 * OneOrMoreParser(MatchParser("1")).parser("1123") == "11" to "23"
 * OneOrMoreParser(MatchParser("1")).parser("23") throws exception
 * */
class OneOrMoreParser(val toRepeat:Parser<String>):Parser<String> {
    override fun parse(string: String): Pair<String, String> {
        TODO("Not yet implemented")
    }
}