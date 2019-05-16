import Human.{Hello, HowAreYou, HowIAm}
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

object MaPremiereApplication extends App {
  val system = ActorSystem("Mind7-Akka")

  val charlie: ActorRef = system.actorOf(Human.props)

  charlie ! Hello
  charlie ! HowAreYou

  val sad = HowIAm(false)
  charlie ! sad

}

class Human extends Actor with ActorLogging {
  override def receive: Receive = {
    case Hello => log.info("Hello dear :)")
    case HowAreYou => log.info("I'm fine dude, thanks for asking")
    case HowIAm(happy) =>
      if (happy) log.info("I am Groot")
      else log.info("Well, have a kitkat")
  }
}

object Human {
  def props = Props[Human]

  // Saying Hello
  case object Hello

  // Asking how Someone is
  case object HowAreYou

  // response to someone asking how we are
  case class HowIAm(happy: Boolean)

}