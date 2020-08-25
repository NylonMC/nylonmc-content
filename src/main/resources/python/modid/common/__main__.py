from rubicon.java import JavaClass
import nylonmc.content.minecraft as mc

log = JavaClass("org/apache/logging/log4j/LogManager").getLogger("Modid")

log.info("Hello Fabric World!")

_fabric_item_settings = mc.ItemSettings()
_fabric_item_settings.group(mc.ItemGroups.getMisc())
fabric_item = mc.Item(_fabric_item_settings)
mc.Registry.register(mc.Registry.getItemRegistry(), mc.Identifier("tutorial", "fabric_item"), fabric_item)