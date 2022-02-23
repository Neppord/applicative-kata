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

interface Client<REQUEST, out RESPONSE> {
    
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
    
    fun <NEWRESPONSE> fmap(f: (RESPONSE) -> NEWRESPONSE): Client<REQUEST, NEWRESPONSE> {
        val client = object:Client<REQUEST, NEWRESPONSE>{
            override fun send(r: REQUEST): NEWRESPONSE {
                return f(this@Client.send(r))
            }
        }
        return client
    }
    
    fun <B> apply(fClient: Client<REQUEST, (RESPONSE) -> B>): Client<REQUEST, B> {
        val client = object:Client<REQUEST, B>{
            override fun send(r: REQUEST): B {
                val f: (RESPONSE) -> B = fClient.send(r)
                return f(this@Client.send(r))
            }
        }
        return client
    }
    
    companion object {
        fun <RESPONSE> pure(response: RESPONSE): Client<Any, RESPONSE> {
            val client = object:Client<Any, RESPONSE>{
                override fun send(r: Any): RESPONSE {
                    return response
                }
            }
            return client
        }
    }
}

fun <REQUEST, RESPONSE, B> Client<REQUEST, (RESPONSE) -> B>.ap(c: Client<REQUEST, RESPONSE>): Client<REQUEST, B> {
    val client = object:Client<REQUEST, B>{
        override fun send(r: REQUEST): B {
            return this@ap.send(r).invoke(c.send(r))
        }
    }
    return client
}