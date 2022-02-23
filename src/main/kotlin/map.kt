fun <K,V, VOUT> Map<K,V>.fmap(f: (V) -> VOUT): Map<K, VOUT> {
    val ret = mutableMapOf<K, VOUT>()
    this.forEach { entry ->
        ret[entry.key] = f(entry.value)
    }
//    for (entry in this) {
//        ret[entry.key] = f(entry.value)
//    }
    return ret
}

fun <K, V> Set<K>.fmap(f:(K) -> V): Set<V> {
    val ret = mutableSetOf<V>()
    this.forEach { 
        ret.add(f(it))
    }
    return ret
}

data class Animal<out P>(private val food: P) {
    
    fun poo(): P{
        return food
    }
    
    fun <POUT> fmap(f:(P) -> POUT): Animal<POUT> {
        val newFood: POUT = f(food)
        return Animal(newFood)
    }
}
/*
typealias Request = Int
typealias Response = String
typealias URLRequest = String

fun getLocation(request: Request): Response {
    client.comap(::convert).send(request)
}

fun Request.convert(): URLRequest {
    return ""
}
*/

interface Client<in REQUEST, out RESPONSE> {
    
    fun send(r: REQUEST): RESPONSE
    
    fun <NEWREQUEST> comap(f:(NEWREQUEST) -> REQUEST): Client<NEWREQUEST, RESPONSE> {
        val client = object:Client<NEWREQUEST, RESPONSE>{
            override fun send(r: NEWREQUEST): RESPONSE {
                val request: REQUEST = f(r)
                return this@Client.send(request)
            }
        }
        return client
    }
}