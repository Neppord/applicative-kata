fun <A, B> ((A) -> B).fmap(a: A?): B? = a?.let(this)

fun <A, B> ((A) -> B)?.ap(a: A?): B? = this?.fmap(a)

fun <A> A?.or(other: A?): A? = this ?: other