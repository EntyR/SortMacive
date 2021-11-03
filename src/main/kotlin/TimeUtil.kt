object TimeUtil {
    fun getNanoTime(): Long {
        return System.nanoTime()
    }
    fun getDuration(start: Long, end: Long): Long {
        return end - start
    }
}