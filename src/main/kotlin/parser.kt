typealias Parser<A> = (String) -> Pair<A, String>
typealias Operator<A> = (A, A) -> A

fun <A> pure(a: A): Parser<A> =
    TODO("Returns the value without consuming input")

fun <A, B> ((A) -> B).fmap(parser: Parser<A>): Parser<B> = TODO()

fun <A, B> Parser<(A) -> B>.ap(other: Parser<A>): Parser<B> = TODO()

fun <A> Parser<A>.or(other: Parser<A>): Parser<A> = 
    TODO("This is part of Alternative, wait with this one until your done with Applicative") 

fun word(text: String): Pair<String, String> = TODO()

fun digits(text: String): Pair<String, String> = TODO()

fun integer(text: String): Pair<Int, String> = TODO()

fun plus(text: String): Pair<String, String> = TODO()

fun operator(text: String): Pair<Operator<Int>, String> = TODO()

fun expression(text: String): Pair<Int, String> = TODO()
