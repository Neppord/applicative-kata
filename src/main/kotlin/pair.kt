
fun <A, B, C> Pair<A, B>.map(f: (A) -> C):Pair<C, B> =
    f(first) to second

fun <A, B, C> ((A) -> C).fmap(p :Pair<A, B> ):Pair<C, B> = p.map(this)