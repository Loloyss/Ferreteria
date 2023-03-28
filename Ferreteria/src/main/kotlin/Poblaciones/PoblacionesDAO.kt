package Poblaciones


interface PoblacionesDAO {

    fun getPoblaciones():ArrayList<Poblaciones>
    fun getPoblacioneyID(id:String): Poblaciones?
    fun insertPoblaciones(Poblaciones: Poblaciones):Boolean
    fun insertArr(arrCompras: ArrayList<Poblaciones>):Boolean
}