

/*
 *  a -> b concat b -> c
 *  = a -> c
 * list<b> map (b -> c)
 *  = list<c>
 */
fun <A, B, C> ((A) -> B).map(f: (B) -> C): (A) -> C =
    { a -> f(invoke(a)) }