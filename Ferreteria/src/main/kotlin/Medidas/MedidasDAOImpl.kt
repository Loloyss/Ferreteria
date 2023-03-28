package Medidas

import ConexionBD
import Constantes

class MedidasDAOImpl: MedidasDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)


    override fun getMedidas(): ArrayList<Medidas> {
        conexion.conectar()

        var arrMedida = ArrayList<Medidas>()
        var query = "SELECT * FROM medidas"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var codigo = st.getString("codigo")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var stock = st.getInt("stock")
            var med = Medidas(codigo, referencia, medida, stock)

            arrMedida.add(med)
        }

        ps?.close()
        conexion.desconectar()

        return arrMedida
    }

    override fun getMedidaByID(id: String): Medidas? {

        var medida: Medidas ?= null

        conexion.conectar()

        var arrMedida = ArrayList<Medidas>()
        var query = "SELECT * FROM medidas  where codigo = ?"

        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        if (st!!.next()) {
            var codigo = st.getString("codigo")
            var referencia = st.getString("referencia")
            var medida = st.getString("medida")
            var stock = st.getInt("stock")
            var med = Medidas(codigo, referencia, medida, stock)
            arrMedida.add(med)
        }

        ps?.close()
        conexion.desconectar()

        return medida
    }

    override fun insertMedidas(medidas: Medidas): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)

        try {
            ps?.setString(1, medidas.codigo )
            ps?.setString(2,medidas.referencia)
            ps?.setString(3, medidas.medida)
            ps?.setInt(4, medidas.stock)
            var st = ps?.executeUpdate()

        }catch (e: Exception){
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }

    override fun insertArr(arrCompras: ArrayList<Medidas>): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?, ?, ?)"

        var ps = conexion.getPreparedStatement(query)

        try {
            for (i in arrCompras){
                ps?.setString(1, i.codigo )
                ps?.setString(2,i.referencia)
                ps?.setString(3, i.medida)
                ps?.setInt(6, i.stock)
                var st = ps?.executeUpdate()
            }

        }catch (e: Exception){
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }
}