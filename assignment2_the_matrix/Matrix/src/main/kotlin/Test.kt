package mmcs.assignment2

fun main() {
    var m = MatrixImpl(3,4,1)
    println("m:\n" + m)
    var m1 = MatrixImpl(3,4,1)
    println("m:\n" + m1)
    println("m1.equals(m):\n"+m1.equals(m))

    var m2 = createMatrix(3,4,2)
    println("m2:\n"+m2)
    println("m1.equals(m2):\n"+m1.equals(m2))

    println("\nm. height: ${m.height}, width: ${m.width}")
    for ( i in 0 until m.height)
        for ( j in 0 until m.width)
            m[i,j] = i+j
    println("m: \n${m}")

    println("rotate(m): \n${rotate(m)}")

    println("m.plus(m1): \n${m.plus(m1)}")
    var m3 = createMatrix(4,3,3)
    println("m3: \n ${m3}")
    println("m.times(m1): \n${m.times(m3)}")
    //TODO()
    var mt1 = createMatrix(5,4,0)
    mt1[0,0] = 1
    mt1[0,2] = 1
    mt1[2,0] = 1
    mt1[1,2] = 1
    mt1[3,2] = 1
    println("mt1: \n${mt1}")
    var h = findHoles(mt1)
    println("h: ${h}")
    println("${h.rows} ряд, ${h.columns}-я колонки")

    //TODO()
    var lock = createMatrix(3,3,1)
    lock[0,1] = 0
    lock[1,0] = 0
    lock[1,2] = 0
    println("lock: \n${lock}")
    var key = createMatrix(2,2,1)
    key[0,1] = 0
    key[1,0] = 0
    println("key: \n${key}")
    var tres = canOpenLock(key,lock)
    println("(${tres.first}, требуемый сдвиг по высоте ${tres.second}, требуемый сдвиг по ширине ${tres.third})")
}