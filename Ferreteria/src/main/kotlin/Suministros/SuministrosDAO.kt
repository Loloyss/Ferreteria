package Suministros

import Premios.Premios

interface SuministrosDAO {
    fun getSuministros():ArrayList<Suministros>
    fun getSuministrosID(id:String): Suministros?
    fun insertSuministros(Suministros: Suministros):Boolean
    fun insertArrSuministros(arrSum: ArrayList<Suministros>):Boolean
}