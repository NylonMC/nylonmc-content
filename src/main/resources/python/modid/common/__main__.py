from rubicon.java import JavaClass

_log = JavaClass("org/apache/logging/log4j/LogManager").getLogger("Modid")

_log.info("Hello Fabric World!")