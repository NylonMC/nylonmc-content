import nylonmc.content.client_commands as cc

from rubicon.java import JavaClass
log = JavaClass("org/apache/logging/log4j/LogManager").getLogger("Modid Command")
log.info("test")

class _MyCommand(cc.Command):
    def run(self, context):
        log.info("command ran")
        return 1
cc.register(cc.ArgumentBuilders.literal("pythoncommand").executes(_MyCommand()))