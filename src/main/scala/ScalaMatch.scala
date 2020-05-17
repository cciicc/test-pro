import java.util

import scala.collection.mutable
import scala.collection.immutable
import scala.runtime.Nothing$

/**
  * Created by fanghuicheng on 2019-06-05 14:50
  */
object ScalaMatch {

  def main(args: Array[String]): Unit = {

    import collection.JavaConversions._

    val cc:String=null
    val cc_int:Int=0

    exe5()
  }



  //可变容器、不可变容器
  def exe5()={

    val a =new testimmu(1,1)
    val b =new testimmu(2,2)
    val c =new testimmu(3,3)


    var map1 = immutable.Map("a"->"first","b"->"second")
    map1+=("c"->"thrid")
    val map3 = immutable.Map("a"->"first","b"->"second")
    val map5 = immutable.Map("a"->a,"b"->b,"c"->c)
//    map3+=("c"->"thrid")
    //immutable不可变，1虽模拟了map的扩展，但本质是返回一个新的集合。所以map3会出错



    var map2 = mutable.Map("a"->"first","b"->"second")
    map2+=("c"->"thrid")
    val map4 = mutable.Map("a"->"first","b"->"second")
    map4+=("c"->"thrid")
    val map6 = mutable.Map("a"->a,"b"->b,"c"->c)

    a.setParam1(111111)
    println(map5)//集合不可变，但是若集合对象是可变对象，则集合终归还是可变的（容器内的对象状态发生变化）
    println(map6)

  }


  def interfaceTest1(a:String)={
    println(a)
  }

  def interfaceTest2(f:String=>Unit)={f("")}

  def hf(f:String=>Unit,tt:String) = {
    println("pre")
    f(tt)
    println("aft")
  }



  def getHostAndPort(hostAndPortsStr: String): util.HashSet[Map[String,Int]] = {
    val hostAndPorts = new util.HashSet[Map[String,Int]]()
    for (str <- hostAndPortsStr.split(",")) {
      hostAndPorts.add(Map(str.split(":")(0)->str.split(":")(1).toInt))
    }
    hostAndPorts
  }



//  etl.foreachRDD(rdd=>{
//    rdd.toDF("id","detail")
//      .withColumn("ts",lit(format.format(System.currentTimeMillis())))
//      .withColumn("field",lit(num.toString))
//      .coalesce(1)
//      .write
//      .mode(SaveMode.Append)
//      .parquet(s"/year=${format.format(System.currentTimeMillis()).substring(0,4)}/month=${format.format(System.currentTimeMillis()).substring(4,6)}/day=${format.format(System.currentTimeMillis()).substring(6,8)}/${format.format(System.currentTimeMillis()).substring(8,10)}/$num")
//  })

  //模式匹配
  def exe1():Unit={
    //常量匹配
    //变量匹配
    //构造器匹配
    //通配符匹配
    //变量绑定匹配
    //类型匹配
  }

  //赋值和模式匹配
  def exe2()={
    List(1,List(2,3,4,5,6,7)) match { case List(_, x@List(2,_*)) => println(x.size) }//构造器+变量绑定匹配

    val (a,b) = (100,200)//构造器+变量绑定

    val 2=2//常量匹配
  }

  //for语句中模式匹配
  def exe3(log1:String,log2:String,log3:String)={
    for(i@"o2o"<-List(log1,log2,log3)) println(i)
    for ((name,"o2o") <- Set("wang"->log1,log3->log2) ) print(name)
  }

  //小括号和花括号
  def exe4()={

    List(2).map{ case 2 => "OK" }

  }
}

class testimmu(var param1:Int,var param2:Int){


  def setParam1(param:Int)=this.param1=param
  def setParam2(param:Int)=this.param2=param

  override def toString: String = s"a testimmu obj computed with param1:${param1},param2:${param2}"

}
