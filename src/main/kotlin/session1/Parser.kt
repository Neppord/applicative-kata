package session1

fun interface Parser<Out> {
    fun parse(string: String): Pair<Out, String>
}