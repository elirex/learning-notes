

interface Observer {
    fun update(event: String)
}

interface Subject {
    fun registerObserver(observer: Observer)
    fun unregisterObserver(observer: Observer)
    fun notifyObservers()
}

class ConcreteObserverA : Observer {

    override fun update(event: String) {
        println("ConcreterObserverA [update] event: $event")
    }

}

class ConcreteObserverB : Observer {

    override fun update(event: String) {
        println("ConcreterObserverB [update] event: $event")
    }

}

class ConcreteSubject : Subject {

    private val observers: ArrayList<Observer> by lazy {
        ArrayList<Observer>()
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update("New event")
        }
    }

    override fun registerObserver(observer: Observer) {
        if (!observers.contains(observer)) observers.add(observer)
    }

    override fun unregisterObserver(observer: Observer) {
        if (observers.contains(observer)) observers.remove(observer)
    }

}


fun main() {
    val observerA = ConcreteObserverA()
    val observerB = ConcreteObserverB()
    val subject = ConcreteSubject()

    subject.registerObserver(observerA)
    subject.registerObserver(observerB)
    subject.notifyObservers()
    subject.registerObserver(observerA)
    subject.registerObserver(observerB)
}