import Articulos.Articulos
import Articulos.ArticulosDAOImpl
import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class MainKtTest {

    @org.junit.jupiter.api.Test
    @DisplayName("select articulos")
    fun main() {
        var articulos=ArticulosDAOImpl()
        var result=articulos.getArticuloByID("HO","003")
        assertNotEquals(Articulos("HO","003","Baston del vacio",5.5F,0.0F),result)
    }
}