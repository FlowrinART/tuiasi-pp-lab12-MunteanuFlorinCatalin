// ObservableMap.kt
package ro.tuiasi.pp.lab12

class ObservableMap<K, V>(
    private val inner: MutableMap<K, V>,
    private val onPut: (key: K, oldValue: V?, newValue: V) -> Unit = { cheie, vechi, nou ->
        println("[ObservableMap] Cheie='$cheie', Valoare veche=$vechi, Valoare nouă=$nou")
    }
) : MutableMap<K, V> by inner {

    override fun put(key: K, value: V): V? {
        val valoareVeche = inner[key]
        onPut(key, valoareVeche, value)
        return inner.put(key, value)
    }
}