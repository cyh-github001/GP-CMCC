//package com_Real_Time.Utils
//
//import com.alibaba.fastjson.JSON
//import org.apache.kafka.clients.consumer.ConsumerRecord
//import org.apache.spark.rdd.RDD
//
//object Utils {
//
//  /**
//    * 解析文件 获取基础数据 并保存到内存中
//    * @param baseRdd
//    * @return
//    */
//  def Api_BaseDate(baseRdd: RDD[ConsumerRecord[String, String]]): RDD[(String, String, List[Double], String, String)] = {
//    val baseData: RDD[(String, String, List[Double], String, String)] =
//      baseRdd.map(rdd => JSON.parseObject(rdd.value()))
//        .filter(x => x.getString("serviceName").equals("reChargeNotifyReq"))
//        .map(rdd => {
//          //事物结果
//          val result = rdd.getString("bussinessRst")
//          //获得充值金额
//          val fee = rdd.getString("chargefee").toDouble
//          //获取省份
//          val provinceCode = rdd.getString("provinceCode")
//          println(provinceCode)
//          //获取充值得发起时间和结束时间
//          val requestId = rdd.getString("requestId")
//          //获取日期
//          val data = requestId.substring(0, 8)
//          //小时
//          val hour = requestId.substring(8, 10)
//          //分钟
//          val minute = requestId.substring(10, 12)
//          //充值结束的时间
//          val receiveTime = rdd.getString("receiveNotifyTime")
//
//          val time = CalculateTools.getDate(requestId, receiveTime)
//          val SuccedResult: (Int, Double, Long) = if (result.equals("0000")) (1, fee, time) else (0, 0, 0)
//
//
//          (data, hour,List[Double](1, SuccedResult._1, SuccedResult._2, SuccedResult._3), provinceCode,minute)
//
//        }).cache()
//    baseData
//  }
//
//
//}
