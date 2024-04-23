import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Number of e-commerce consumers, number of men and women")
      .getOrCreate()

    val df = spark
      .read
      .option("header", "false")
      .schema(StructType(Array(
        StructField("id", LongType, nullable = true),
        StructField("login_nam", StringType, nullable = true),
        StructField("nick_name", StringType, nullable = true),
        StructField("passwd", StringType, nullable = true),
        StructField("name", StringType, nullable = true),
        StructField("phone_num", StringType, nullable = true),
        StructField("email", StringType, nullable = true),
        StructField("head_img", StringType, nullable = true),
        StructField("user_level", StringType, nullable = true),
        StructField("birthday", DateType, nullable = true),
        StructField("gender", StringType, nullable = true),
        StructField("create_time", TimestampType, nullable = true),
        StructField("operate_time", TimestampType, nullable = true),
      )))
      .csv("hdfs:/file2_5/user_info.csv")

    val data = df.groupBy("gender").agg(count("gender").as("number")).orderBy("gender")

    data.show()
    spark.stop()
  }
}
