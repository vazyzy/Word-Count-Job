package ru.livetex.wordcount

import ru.livetex.wordcount.thrift.WordsEvent
import ru.livetex.wordcount.thrift.WordsEventService.{sendWordEvent$result, sendWordEvent$args}
import org.apache.hadoop
import org.apache.hadoop.conf.Configuration
import org.apache.spark.SparkContext
import org.apache.spark.metrics.source.AccumulatorSource
import org.apache.spark.rdd.RDD
import ru.livetex.spark._


object WordCountJob extends SimpleJob[RawLog, (String, Long)]{

  override val teamName: String = "myAwesomeTeam"

  override val expectedArgs: Array[String] = Array("readPath", "writePath")

  override def readData(args: Map[String, String], jobMode: JobMode.Value)
                       (implicit sc: SparkContext): RDD[String] = {
    sc.thriftFile(args("readPath"))
  }


  override def job(rdd: RDD[RawLog])(implicit sc: SparkContext, metrics: AccumulatorSource)
  : RDD[(String, Long)] = {

    def build(codec: MessageCodec): MessageCodec = {
      codec.buildMethodDecoder("sendWordEvent", sendWordEvent$args, sendWordEvent$result)
    }

    // Декодируем сообщения
    val validRdd = decodeAndFilterMessages(rdd, build) {
      case (sendEventArg) => Seq(sendEventArg)
    }

    validRdd
      .map(getWordsCount)
      .reduceByKey(_ + _)
  }

  def getWordsCount(rdd: Log): Unit = {
    val (_, (_, )) = rdd
    request match {
      case sendWordEvent$args(WordsEvent(words)) => words.trim.split(" ")
    }
  }

  override def afterJob(rdd: RDD[(String, Long)],
                        args: Map[String, String],
                        jobMode: JobMode.Value)(implicit sc: SparkContext): Unit = {

  }

}
