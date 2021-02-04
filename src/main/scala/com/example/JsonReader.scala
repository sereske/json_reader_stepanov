package com.example
import io.circe.parser
import io.circe.generic.semiauto.deriveDecoder
import org.apache.spark.{SparkConf, SparkContext}

object JsonReader extends App {
  if (args.length == 0) {
    println("path is not defined")
    sys.exit(1)
  }
  val conf = new SparkConf().setAppName("Json Reader").setMaster("local[*]")

  val context = new SparkContext(conf)
  val path = args(0)
  implicit val wineDecoder = deriveDecoder[Wine]
  for (row <- context.textFile(path)) {
    val wine = parser.decode[Wine](row)
    println(wine)
  }
}
case class Wine(id: Int, country: String, points: Int, title: String, variety: String, winery: String)

