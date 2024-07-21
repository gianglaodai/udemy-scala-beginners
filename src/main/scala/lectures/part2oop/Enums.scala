package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE
    def openDocumen(): Unit =
      if (this == READ) println ("opnening document...")
      else println("reading not allowed.")
  }
  val somePermissions: Permissions = Permissions.READ
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
  }
  
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionWithBits = PermissionWithBits.EXECUTE
  }
}
