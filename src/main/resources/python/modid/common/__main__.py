from rubicon.java import JavaClass

log = JavaClass("org/apache/logging/log4j/LogManager").getLogger("Modid")

log.info("Hello Fabric World!")