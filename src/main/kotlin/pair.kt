
fun <A, B, C> Pair<A, B>.map(f: (A) -> C):Pair<C, B> =
    f(first) to second