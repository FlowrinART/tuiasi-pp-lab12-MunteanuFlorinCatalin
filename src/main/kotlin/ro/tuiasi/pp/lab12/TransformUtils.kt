// TransformUtils.kt
package ro.tuiasi.pp.lab12

typealias Transform<V> = (V) -> V

object TransformUtils {

    infix fun <V> Transform<V>.andThen(g: Transform<V>): Transform<V> {
        return { value -> g(this(value)) }
    }

    fun applyTransform(map: HashMap<String, Int>, transform: Transform<Int>): HashMap<String, Int> {
        val rezultat = HashMap<String, Int>()

        for ((cheie, valoare) in map) {
            rezultat[cheie] = transform(valoare)
        }

        return rezultat
    }
}