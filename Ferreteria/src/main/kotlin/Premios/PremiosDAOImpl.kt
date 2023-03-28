package Premios

import ConexionBD
import Poblaciones.Poblaciones

class PremiosDAOImpl : PremiosDAO {

    val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun getPremios(): ArrayList<Premios> {
        conexion.conectar()

        var arrPr = ArrayList<Premios>()
        var query = "SELECT * FROM premios"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        while (st!!.next()) {
            var cif = st.getString("cif")
            var premio = st.getString("premio")
            var pr = Premios(cif, premio)

            arrPr.add(pr)
        }

        ps?.close()
        conexion.desconectar()

        return arrPr
    }

    override fun getPpremioID(id: String): Premios? {
        conexion.conectar()

        var pr: Premios? = null
        var query = "SELECT * FROM premios where cif = ?"
        var ps = conexion.getPreparedStatement(query)
        var st = ps?.executeQuery()

        if (st!!.next()) {
            var cif = st.getString("cif")
            var premio = st.getString("premio")
            pr = Premios(cif, premio)
        }

        ps?.close()
        conexion.desconectar()
        return pr
    }

    override fun insertPremios(Premios: Premios): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?)"

        var ps = conexion.getPreparedStatement(query)

        try {
            ps?.setString(1, Premios.cif)
            ps?.setString(2, Premios.premio)
            var st = ps?.executeUpdate()

        } catch (e: Exception) {
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }

    override fun insertArrPremios(arrCompras: ArrayList<Premios>): Boolean {
        conexion.conectar()

        var query = "insert into compras values (?, ?)"

        var ps = conexion.getPreparedStatement(query)

        try {
            for (i in arrCompras) {
                ps?.setString(1, i.cif)
                ps?.setString(2, i.premio)
                var st = ps?.executeUpdate()
            }
        } catch (e: Exception) {
            println(e)
        }

        ps?.close()
        conexion.desconectar()

        return true
    }


}