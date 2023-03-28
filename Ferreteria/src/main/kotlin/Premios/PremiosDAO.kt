package Premios


interface PremiosDAO {
    fun getPremios():ArrayList<Premios>
    fun getPpremioID(id:String): Premios?
    fun insertPremios(Premios: Premios):Boolean
    fun insertArrPremios(arrCompras: ArrayList<Premios>):Boolean
}