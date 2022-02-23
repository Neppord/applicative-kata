/*
 *  a -> b concat b -> c
 *  = a -> c
 * list<b> map (b -> c)
 *  = list<c>
 */
fun <A, B, C> ((A) -> B).map(f: (B) -> C): (A) -> C =
    { a -> f(invoke(a)) }

// Cofunctor for function
// f: (A) -> B
// translate: (C) -> A
// f.comap(translate): C -> B
fun <A, B, C> ((A) -> B).comap(f: (C) -> A): (C) -> B {
    return { c ->
        val a = f(c)
        this(a)
    }
} 