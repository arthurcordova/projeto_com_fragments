package com.proway.projetofragments

import androidx.fragment.app.Fragment

fun main() {

    val cachorro = Cachorro()
    val camelo = Camelo()


    alimentar(camelo)

}


fun <T : Animal> alimentar(parametro: T) {

    parametro.comer()

    when (parametro) {
        is Cachorro -> println(parametro.raca)
        is Camelo -> println(parametro.numeroOndasNasCostas)
    }
}


class Cachorro(
    val raca: String = "pitbull"

) : Animal() {
    override fun comer() {
        println("Cachorro comento ração...")
    }
}

class Camelo(
    val numeroOndasNasCostas: Int = 2
) : Animal() {
    override fun comer() {
        println("Camelo comento areia...")
    }
}

open class Animal {
    open fun comer() {
        print("Animal comendo....")
    }
}

