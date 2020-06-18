import akka.stream._
import akka.stream.scaladsl._

import akka.{ Done, NotUsed }
import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
import java.nio.file.Paths

object Main extends App {

  implicit val system: ActorSystem          = ActorSystem("QuickStart")
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val source: Source[Int, NotUsed] = Source(1 to 100)
  source.runForeach(i => println(i))

  val done: Future[Done] = source.runForeach(i => println(i))
  done.onComplete(_ => system.terminate())

  Await.ready(done, Duration.Inf)
}
