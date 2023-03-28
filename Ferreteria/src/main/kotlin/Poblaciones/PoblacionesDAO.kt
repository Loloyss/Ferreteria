package Poblaciones


interface PoblacionesDAO {

    fun getPoblaciones():ArrayList<Poblaciones>
    fun getPoblacionesyID(id:String): Poblaciones?
    fun insertPoblaciones(Poblaciones: Poblaciones):Boolean
    fun insertArr(arrPoblaciones: ArrayList<Poblaciones>):Boolean
}