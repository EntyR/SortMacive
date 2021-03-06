import kotlin.random.Random

class DataUtil(private val _list: MutableList<String>) {

    val list: List<String> = _list

    fun bubbleSort() {

        val curTime = TimeUtil.getNanoTime()

        val size = _list.size

        for (i in 0 until size) {

            for (t in (size-1).downTo(i+1)) {

                if (_list[t] < _list[t - 1]) {
                    swap(t, t - 1)
                }
            }
        }
        TimeUtil.getDuration(curTime, TimeUtil.getNanoTime())
    }

    fun insertSort() {

        val curTime = TimeUtil.getNanoTime()
        val size = _list.size
        for (i in 1 until size) {
            val holder = _list[i]
            var counter: Int = i - 1
            while (holder < _list[counter] && counter >= 0) {
                shift(counter, counter + 1)
                counter--
            }
            if (counter < 0) {
                _list[0] = holder
            } else {
                _list[counter + 1] = holder
            }
        }
        TimeUtil.getDuration(curTime, TimeUtil.getNanoTime())
    }

    fun selectionSort() {

        val curTime = TimeUtil.getNanoTime()

        val startTime = TimeUtil.getNanoTime()

        for (i in 0 until _list.size) {
            val sorted = i + 1
            var minElem = _list[i]
            for (sel in sorted until _list.size) {
                if (minElem > _list[sorted]) {
                    minElem = _list[sorted]
                }

            }
            _list[i] = minElem
        }

        TimeUtil.getDuration(curTime, TimeUtil.getNanoTime())

    }

    fun horusSort(startValue: Int, endValue: Int) {

        val curTime = TimeUtil.getNanoTime()

        if (startValue - endValue == 1) {
            println("exit")
            return
        }
        val pivot = divide(startValue, endValue)
        horusSort(startValue, pivot)
        horusSort(pivot, startValue)
        TimeUtil.getDuration(curTime, TimeUtil.getNanoTime())
    }

    private fun divide(startValue: Int, endValue: Int): Int {
        val pivot = _list[Random.nextInt(startValue, endValue + 1)]

        var m = startValue
        for (i in startValue..endValue) {
            if (_list[i] < pivot) {
                swap(i, m)
                m++
            }
        }
        return m
    }

    private fun swap(elemOne: Int, elemSec: Int) {
        val holder = _list[elemOne]
        _list[elemOne] = _list[elemSec]
        _list[elemSec] = holder
    }

    private fun shift(elemForShift: Int, place: Int) {
        _list[place] = _list[elemForShift]
    }
}