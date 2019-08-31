package com_Real_Time.Test


/**
  * 指标统计
  */
object Jedis2Result {

  def getPro(ip: String, logs: List[(Long, Long, String)]): String = {
    val lip: Long = ip2Long(ip)
    var l = 0
    var r = logs.size
    var mid = 0
    while (l <= r) {
      mid = (l + r)/2
      if (logs(mid)._2 < lip)
        l = mid
      else if (logs(mid)._1 > lip)
        r = mid
      else
        return logs(mid)._3
    }
    ""
  }

  // 将IP转换成十进制
  def ip2Long(ip:String):Long ={
    val s = ip.split("[.]")
    var ipNum =0L
    for(i<-0 until s.length){
      ipNum = s(i).toLong | ipNum << 8L
    }
    ipNum
  }
}

