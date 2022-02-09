
fun <A, B> ((A) -> B).fmap(list: List<A>): List<B> =
    list.map(this)

fun <A, B> List<(A) -> B>.ap(other: List<A>): List<B> {
    val emptyList: MutableList<B> = mutableListOf()
    for (o in other) {
        for (f in this) {
            emptyList.add(f(o))
        }
    }
    return emptyList
}

fun <A> List<A>.or(other: List<A>): List<A> =
    TODO("This is part of Alternative, wait with this one until your done with Applicative") 