
fun <A, B> ((A) -> B).fmap(list: List<A>): List<B> {
    return list.map(this)
}

fun <A, B> List<(A) -> B>.ap(other: List<A>): List<B> {
    val emptyList: MutableList<B> = mutableListOf()
    for (o in other) {
        for (f in this) {
            emptyList.add(f(o))
        }
    }
    return emptyList
}