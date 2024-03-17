@file:Suppress("UNUSED_PARAMETER")
package mmcs.assignment2

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E

    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)

    operator fun set(cell: Cell, value: E)
}

/**
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> {
    if (height <= 0 || width <= 0)
        throw IllegalArgumentException("height and width should be more(>) 0")
    return MatrixImpl(height, width, e)
}

/**
 * Реализация интерфейса "матрица"
 */

@Suppress("EqualsOrHashCode")
class MatrixImpl<E>(height: Int, width: Int, e: E) : Matrix<E> {

    private var m: MutableList<MutableList<E>> = MutableList(height) { MutableList(width) { e } };

    override val height: Int = height

    override val width: Int = width

    override fun get(row: Int, column: Int): E
    {
        return m[row][column]
    }

    override fun get(cell: Cell): E =  m[cell.row][cell.column]

    override fun set(row: Int, column: Int, value: E) {
        m[row][column] = value
    }

    override fun set(cell: Cell, value: E) {
        m[cell.row][cell.column] = value
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Matrix<*>)
            return false
        for (i in 0 until this.height) {
            for (j in 0 until this.width) {
                if (m[i][j] != other[i, j] )
                    return false
            }
        }
        return true
    }

    override fun toString(): String {
        var result: String = ""
        for (i in 0 until height) {
            for (j in 0 until width) {
                result += "${m[i][j]}"
            }
            result += "\n"
        }
        return  result
    }
}
