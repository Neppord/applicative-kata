package session1

fun interface Parser<Out> {
    fun parse(string: String): Pair<Out, String>
    fun or(other: Parser<Out>): Parser<Out> {
        return OrParser(this, other)
    }
}