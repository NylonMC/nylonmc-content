from rubicon.java import JavaClass
import nylonmc.content.minecraft as mc

def main():
    log = JavaClass("org/apache/logging/log4j/LogManager").getLogger("Modid")

    log.info("Hello Fabric World!")
    try:
        _fabric_item_settings = mc.ItemSettings()
        _fabric_item_settings.group(mc.ItemGroups.getMisc())
        class FabricItem(mc.Item):
            def onUse(self, world, user, hand, return_value):
                log.info("If You See This You Right Clicked tutorial:fabric_item")
        fabric_item = FabricItem(_fabric_item_settings)
        log.info(fabric_item._settings)
        mc.registry.register_item(mc.Identifier("tutorial", "fabric_item"), fabric_item)
        import sys
        log.info(str(sys.getrefcount(fabric_item)))
    except Exception as e:
        log.error(str(e))
        import traceback
        track = traceback.format_exc()
        log.error(track)