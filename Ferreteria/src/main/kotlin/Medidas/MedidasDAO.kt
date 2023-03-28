package Medidas

interface MedidasDAO {

    fun getMedidas():ArrayList<Medidas>
    fun getMedidaByID(id:String): Medidas?
    fun insertMedidas(Medidas: Medidas):Boolean
    fun insertArr(arrCompras: ArrayList<Medidas>):Boolean

}